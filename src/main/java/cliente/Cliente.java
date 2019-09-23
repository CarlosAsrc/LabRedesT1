package cliente;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	private static String ServerAddress = "localhost";
	private static int ServerPort = 9876;
	private static Scanner in = new Scanner(System.in);

	public static void main(String args  []) {
		menu();
	}

	public static String requisitarServidor(String mensagem) {
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
			clientSocket.close();
			return quote.trim();
		} catch(Exception e) {
			return "Falha na comunicação com o servidor!";
		}
	}

	public static void menu () {
		String opcao="";
		while(true) {

			System.out.println(
					requisitarServidor("mapa")+
					"\n\n"+
					"1 - Examinar [sala/objeto]\n" +
					"2 - Mover [N/S/L/O]\n" +
					"3 - Pegar [objeto]\n" +
					"4 - Largar [objeto]\n" +
					"5 - Inventório\n" +
					"6 - Usar [objeto] {alvo}\n" +
					"7 - Falar [texto]\n" +
					"8 - Cochichar [texto] [jogador]\n" +
					"9 - Ajuda\n");
			opcao = in.next();

			switch (opcao) {
				case "1": {
					String objeto = "";
					System.out.println("Informe o nome da sala ou do objeto:");
					objeto = in.next();
					System.out.println(requisitarServidor("examinar;"+objeto));
				}
				break;

				case "2": {}
				break;

				case "3": {}
				break;
				case "4": {}
				break;
				case "5": {}
				break;
				case "6": {}
				break;
				case "7": {}
				break;
				case "8": {}
				break;
				case "9": {}
			}
		}
	}
}
