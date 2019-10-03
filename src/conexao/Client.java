package conexao;




import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;


public class Client {

	public static boolean envia=false;
    public static void main(String[] args) throws SocketException, IOException, InterruptedException {
        
    	GerenciadorTarefa.tarefase.clear();
    	GerenciadorTarefa.tarefasr.clear();
    	String acao = "ok";
    	String mensagema ="ok";
    	Tarefa tarefa = new Tarefa(acao,mensagema);
    	GerenciadorTarefa.tarefase.add(tarefa);
    	GerenciadorTarefa.tarefasr.add(tarefa);
    	Persistencia.save("mr");
    	Persistencia.save("me");
    	
    	
    	System.out.println("Procurando Server....");
    	
         BufferedReader clientRead =new BufferedReader(new InputStreamReader(System.in));
      
      InetAddress IP = InetAddress.getByName("192.168.0.18");
    
      DatagramSocket clientSocket = new DatagramSocket();
      while(true)   
      {
    	 
      byte[] sendbuffer = new byte[1024];
      byte[] receivebuffer = new byte[1024];
      
      
      analise();
      
      if (envia =true) {
      while (GerenciadorTarefa.tarefasespera.size()>0) {
    	  String mensagem = GerenciadorTarefa.tarefasespera.get(0).getAcao()+"/"+GerenciadorTarefa.tarefasespera.get(0).getMensagem();
          
    	  String clientData = mensagem;
        
      
      sendbuffer = clientData.getBytes();        
      DatagramPacket sendPacket =
      new DatagramPacket(sendbuffer, sendbuffer.length, IP, 9876);
      clientSocket.send(sendPacket);
      GerenciadorTarefa.tarefasespera.remove(0);
      }
      }
      envia =false;
      
      DatagramPacket receivePacket =
      new DatagramPacket(receivebuffer, receivebuffer.length);
      clientSocket.receive(receivePacket);
      String serverData = new String(receivePacket.getData());
      System.out.print("\nServer: " + serverData);
      TimeUnit.SECONDS.sleep(2);
      if (serverData.length()>0) {
          adicionarmr(serverData);
        }
     
      }
      
    }
    public static void analise () {
        Persistencia.read("me");
                if (GerenciadorTarefa.tarefasespera.size()>0) {
                	envia=true;
                }
        }
    public static void adicionarmr(String a) throws FileNotFoundException {
    	GerenciadorTarefa.countmr=GerenciadorTarefa.countmr+1;
       String [] array = a.split("/");
    String acao = array[0];
    String mensagem = array[1];
    Tarefa tarefa = new Tarefa(acao,mensagem);
    GerenciadorTarefa.tarefasr.add(tarefa);
    Persistencia.save("mr");
    }
    
}
