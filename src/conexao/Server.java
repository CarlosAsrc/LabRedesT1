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

import application.Main;



public class Server {

	public static boolean envia=false;
    public static  void main(String[] args) throws InterruptedException, IOException  {
   
    	System.out.println("Servidor iniciado, aguardando resposta....");
         DatagramSocket serverSocket = new DatagramSocket(9876);
         boolean bye=false;
      
      while(true) 
        {
          byte[] receivebuffer = new byte[1024];
          byte[] sendbuffer  = new byte[1024];
          DatagramPacket recvdpkt = new DatagramPacket(receivebuffer, receivebuffer.length);
          serverSocket.receive(recvdpkt);
          InetAddress IP = recvdpkt.getAddress();
          int portno = recvdpkt.getPort();
          String clientdata = new String(recvdpkt.getData());
          System.out.println("\nClient : "+ clientdata);
          //Adicionar no MR
          TimeUnit.SECONDS.sleep(2);
        if (clientdata.length()>0) {
          adicionarmr(clientdata);
        }
          analise();
          
          if (envia =true) {
          while (GerenciadorTarefa.tarefasespera.size()>0) {
         String mensagem = GerenciadorTarefa.tarefasespera.get(0).getAcao()+"/"+GerenciadorTarefa.tarefasespera.get(0).getMensagem();
        	  
        	  String serverdata = mensagem;
          
          sendbuffer = serverdata.getBytes();
          DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP,portno);
         
          serverSocket.send(sendPacket);
          GerenciadorTarefa.tarefasespera.remove(0);
          }
          }
          envia =false;
          
          
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
