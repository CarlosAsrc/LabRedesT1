package conexao;

import java.io.IOException;
import java.util.ArrayList;

import regras.Jogo;
import regras.Porta;

public class Acoes {
	public static void lerAcao(Tarefa a) {

		String acao = a.acao;
		String mensagem = a.mensagem;
		//Remove a virgula
		mensagem=mensagem.substring(0, mensagem.length()-1);
		
		//Nome do jogador 
		if (acao.equals("nomejogador")) {
			Estados.recebeunomejogador="sim";
			
			Estados.nomedojogador=mensagem;
			
		}
		
	    //Finaliza o jogo
		
		if (acao.equals("finalizar")) {
		Estados.finalizarjogo="sim";
		
		Estados.vencedor=mensagem;
	}
		
		//chat
		if (acao.equals("chat")) {
			Estados.nmchat="sim";
			Estados.mensagem=mensagem;
		}
		
		
		if (acao.equals("Dado")) {
			Estados.jogoudado="sim";
			Estados.jogoudadovalor=mensagem;
		}
		
		if (acao.equals("Jogador moveu")) {
			Estados.jogadormoveu="sim";
			Estados.direcao=mensagem;
		}
		
		if (acao.equals("troca jogador")) {
			if (Estados.jogadorDaVez.equals("jogador1")) {
			Estados.jogadorDaVez = "jogador2";
			}
			else if (Estados.jogadorDaVez.equals("jogador2")) {
				Estados.jogadorDaVez = "dragao";
				}
			else if (Estados.jogadorDaVez.equals("dragao")) {
				Estados.jogadorDaVez = "Night King";
				}
			else if (Estados.jogadorDaVez.equals("Night King")) {
				Estados.jogadorDaVez = "jogador1";
				}
			Estados.jogadorDaVeztrocou="sim";
		}
		if (acao.equals("J1 Pronto!")) {
			Estados.jogador1Pronto = "Sim";
		}
		if (acao.equals("J2 Pronto!")) {
			Estados.jogador2Pronto = "Sim";
		}
		if (acao.equals("iniciar")) {
			Estados.inicio = "comece";
		}
		if (acao.equals("portas")) {
			
			String cor;
			String chave;
			String iten;
			String situacao;
			String x;
			String y;
			
			String[] array1 = mensagem.split(">");
			
			for (int i = 0; i < array1.length; i++) {
				
				String[] array2 = array1[i].split(":");
				cor = array2[0];
				chave = array2[1];
				iten = array2[2];
				situacao = array2[3];
				x = array2[4];
				y = array2[5];
				
				ArrayList<Integer> local = new ArrayList<Integer>();
				local.add(Integer.parseInt(x));
				local.add(Integer.parseInt(y));
				Porta porta = new Porta(cor,chave,iten,situacao,local);
				Jogo.portas.add(porta);
			}

			
		}

	}

	public static void criarAcao(String a, String b) throws IOException {
		Persistencia.readenviar();
		String acao = a;
		String mensagem = b;
		Tarefa tarefa = new Tarefa(acao, mensagem);
		GerenciadorTarefa.envio.add(tarefa);
		Persistencia.save("enviar");
	}

}
