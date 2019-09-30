package servidor;

import servidor.Entidades.Jogador;

import java.awt.*;
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

		System.out.println("=======================");
		System.out.println("The server is listening");
		System.out.println("=======================");

	    byte[] receiveData = new byte[1024];
	    while(true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);

			String mensagem = new String(receivePacket.getData()).trim();
			InetAddress IPJogador = receivePacket.getAddress();

			byte[] sendData = new byte[4096];
			sendData = executarComando(IPJogador, mensagem).getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
			serverSocket.send(sendPacket);
	   }
	}

	public static String executarComando(InetAddress IPJogador, String mensagem) {
		boolean isNew = isJogadorNew(IPJogador);

		if (isNew) System.out.println("Jogador Novo !!");
		Jogador jogador = designarJogador(IPJogador);
		String sentenca [] = mensagem.split(";");
		String comando = sentenca[0].trim();
		System.out.println(jogador.getNome() + " Comando: " + mensagem + "\nhascomands: " + hasComands(comando));
		switch(hasComands(comando)) {
			case "start" : {
				String response = "";
				if(isNew){
					response = "=================\n"
							+ "Bem-Vindo!\n\n"
							+ jogador.toString()
							+ "=================";

				}
				return response;
			}
			case "examinar" : {
				return salas.examinar(jogador, sentenca[1]);
			}

			case "mover" : {
                return salas.mover(jogador, sentenca[1].charAt(0));
            }

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

			case "mapa" :
			case "mapat" :{
				System.out.println("mapa mapa");
				return salas.toString();
			}
		}
		return "Comando inválido";
	}


	private static Jogador designarJogador(InetAddress IPJogador) {
		return isJogadorNew(IPJogador) ? createJogador(IPJogador) : getJogador(IPJogador);
	}

	private static Jogador createJogador(InetAddress IPJogador){
		Jogador novoJogador = new Jogador("jogador"+(jogadores.size()+1), "sala1", IPJogador);// sala1??? salas.get...
		jogadores.add(novoJogador);
		salas.posicionarJogador(novoJogador);
		return novoJogador;
	}

	private static Jogador getJogador(InetAddress IPJogador){
		for(Jogador jogador: jogadores) {
			if(jogador.getEnderecoIP().equals(IPJogador)) {
				return jogador;
			}
		}
		return null;
	}
	private static boolean isJogadorNew(InetAddress IPJogador){
		boolean response = true;
		for(Jogador jogador: jogadores) {
			if(jogador.getEnderecoIP().equals(IPJogador)) {
				return false;
			}
		}
		return true;
	}

	private static String hasComands(String request){
		String response = "";
		String comandos[] = {"start", "examinar", "mover", "largar", "inventorio", "usar", "falar", "cochichar", "ajuda", "mapa"};

		for (String c : comandos) {
			if (request.contains(c))
				return c ;
		}
		return null;
	}
}
