package servidor;

import servidor.Entidades.Jogador;
import servidor.Entidades.Objeto;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;

public class Servidor {

	private static List<Jogador> jogadores;

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
	}

	private static Jogador designarJogador(InetAddress IPJogador) {
		for(Jogador jogador: jogadores) {
			if(jogador.getEnderecoIP().equals(IPJogador)) {
				return jogador;
			}
		}
		Jogador novoJogador = new Jogador(IPJogador);
		jogadores.add(novoJogador);
		return novoJogador;
	}

	public static void mover(Jogador jogador, Character direcao) {

	}

	public static void pegar(Jogador jogador, Objeto objeto) {

	}

	public static void largar(Jogador jogador, Objeto objeto) {

	}

	public static void inventorio(Jogador jogador) {

	}

	public static void usar(Jogador jogador, Objeto objeto, Objeto alvo) {

	}

	public static void falar(Jogador jogador, String textoFala) {

	}

	public static void Cochinchar(Jogador jogadorOrigem, String textoFala, Jogador jogadorDestino) {

	}
}
