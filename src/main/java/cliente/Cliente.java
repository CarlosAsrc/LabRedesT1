package cliente;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	private static String ServerAddress = "localhost";
	private static int ServerPort = 9876;

	public static boolean requisitarServidor(String mensagem) {
		try {
			DatagramSocket clientSocket = new DatagramSocket();
			InetAddress IPAddress = InetAddress.getByName("localhost");
			byte[] sendData = new byte[1024];
			sendData = mensagem.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, ServerPort);
			clientSocket.send(sendPacket);
			clientSocket.close();
			return true;
		} catch(Exception e) {
			System.out.println("Falha na comunicação com o servidor!");
			return false;
		}
	}
}
