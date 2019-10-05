package conexao;

import java.io.IOException;
import java.util.ArrayList;

import regras.Jogo;
import regras.Porta;

public class Acoes {
	public static void lerAcao(Tarefa a) {

		String acao = a.acao;
		String mensagem = a.mensagem;

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
			System.out.println("bolacha");
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
				if (i==array1.length-1) {
				y=y.substring(0, y.length()-1);
				}
				local.add(Integer.parseInt(y));
				Porta porta = new Porta(cor,chave,iten,situacao,local);
				Jogo.portas.add(porta);
			}
for (int i=0;i<Jogo.portas.size();i++) {
	System.out.println(Jogo.portas.get(i));
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
