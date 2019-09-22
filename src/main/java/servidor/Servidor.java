package servidor;

import servidor.Entidades.Jogador;
import servidor.Entidades.Objeto;
import servidor.Entidades.Sala;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;

public class Servidor {

	private static List<Jogador> jogadores;
	private static SalaController salas;

	public static void main(String args[])  throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9876);
	    byte[] receiveData = new byte[1024];
	    while(true) {
	          DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	          serverSocket.receive(receivePacket);

	          String mensagem = new String(receivePacket.getData());
	          InetAddress IPJogador = receivePacket.getAddress();

	          executarComando(IPJogador, mensagem);
	   }
	}

	public static void executarComando(InetAddress IPJogador, String mensagem) {
		Jogador jogador = designarJogador(IPJogador);
		String sentenca [] = mensagem.split(";");
		String comando = sentenca[0];

		switch(comando) {
			case "examinar" : {}
			break;
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
			break;
		}
	}

	private static Jogador designarJogador(InetAddress IPJogador) {
		for(Jogador jogador: jogadores) {
			if(jogador.getEnderecoIP().equals(IPJogador)) {
				return jogador;
			}
		}
		Jogador novoJogador = new Jogador(IPJogador);
		jogadores.add(novoJogador);
		salas.posicionarJogador();
		return novoJogador;
	}
}
