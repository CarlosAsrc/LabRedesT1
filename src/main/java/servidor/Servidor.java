package servidor;

import servidor.Entidades.Jogador;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

	private static List<Jogador> jogadores = new ArrayList<>();
	private static SalaController salas = new SalaController();

	public static void main(String args[])  throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9876);
	    byte[] receiveData = new byte[1024];
	    while(true) {
	          DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	          serverSocket.receive(receivePacket);

	          String mensagem = new String(receivePacket.getData());
	          InetAddress IPJogador = receivePacket.getAddress();

			byte[] sendData = new byte[4096];
			sendData = (mensagem.trim()+" recebido").getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
			serverSocket.send(sendPacket);
	   }
	}

	public static String executarComando(InetAddress IPJogador, String mensagem) {
		Jogador jogador = designarJogador(IPJogador);
		String sentenca [] = mensagem.split(";");
		String comando = sentenca[0].trim();

		switch(comando) {
			case "examinar" : {
				return salas.examinar(jogador, sentenca[1]);
			}

			case "mover" : {}
			break;

			case "pegar" : {}
			break;

			case "largar" : {}
			break;

			case "inventorio" : {}
			break;

			case "usar" : {}
			break;

			case "falar" : {}
			break;

			case "cochichar" : {}
			break;

			case "ajuda" : {}
		}
		return "Comando inválido";
	}

	private static Jogador designarJogador(InetAddress IPJogador) {
		for(Jogador jogador: jogadores) {
			if(jogador.getEnderecoIP().equals(IPJogador)) {
				return jogador;
			}
		}
		Jogador novoJogador = new Jogador("jogador"+(jogadores.size()+1), "sala1", IPJogador);
		jogadores.add(novoJogador);
		salas.posicionarJogador(novoJogador);
		return novoJogador;
	}
}
