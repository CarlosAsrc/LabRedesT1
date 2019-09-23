package cliente;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

	private static String ServerAddress = "localhost";
	private static int ServerPort = 9876;

	public static void main(String args  []) {
		requisitarServidor("alo");
	}

	public static boolean requisitarServidor(String mensagem) {
		try {
			DatagramSocket clientSocket = new DatagramSocket();
			InetAddress IPAddress = InetAddress.getByName("localhost");

			byte[] sendData = new byte[4096];
			sendData = mensagem.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, ServerPort);
			clientSocket.send(sendPacket);

			byte[] receiveData = new byte[4096];
			DatagramPacket response = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(response);
			String quote = new String(receiveData, 0, response.getLength());
			
			System.out.println(quote);
			clientSocket.close();
			return true;
		} catch(Exception e) {
			System.out.println("Falha na comunicação com o servidor!");
			return false;
		}
	}
}
