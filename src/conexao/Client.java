package conexao;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;


public class Client {

    
    public static void main(String[] args) throws SocketException, IOException, InterruptedException {
        
    	System.out.println("Procurando Server....");
    	
         BufferedReader clientRead =new BufferedReader(new InputStreamReader(System.in));
      
      InetAddress IP = InetAddress.getByName("192.168.0.18");
    
      DatagramSocket clientSocket = new DatagramSocket();
      while(true)   
      {
    	 
      byte[] sendbuffer = new byte[1024];
      byte[] receivebuffer = new byte[1024];
      
      
   
      String clientData = "Cliente espera";
    
      if(clientData.equalsIgnoreCase("bye"))
      {
          System.out.println("Connection ended by client");
          break;
      }
      TimeUnit.SECONDS.sleep(2);
      sendbuffer = clientData.getBytes();        
      DatagramPacket sendPacket =
      new DatagramPacket(sendbuffer, sendbuffer.length, IP, 9876);
      clientSocket.send(sendPacket);
      
      DatagramPacket receivePacket =
      new DatagramPacket(receivebuffer, receivebuffer.length);
      clientSocket.receive(receivePacket);
      String serverData = new String(receivePacket.getData());
      System.out.print("\nServer: " + serverData);
      
     
      }
      clientSocket.close();
    }
    
}
