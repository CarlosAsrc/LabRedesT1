package conexao;

import java.io.IOException;

public class Acoes {
public static void lerAcao(Tarefa a) {
	
	String acao = a.acao;
	String mensagem = a.mensagem;
	
	if (acao.equals("J1 Pronto!")) {
		Estados.jogador1Pronto="Sim";
	}
    if (acao.equals("J2 Pronto!")) {
    	Estados.jogador2Pronto="Sim";
	}
	
}

public static void criarAcao(String a, String b) throws IOException {
	Persistencia.readenviar();
	String acao = a;
    String mensagem =  b;
    Tarefa tarefa = new Tarefa(acao,mensagem);
    GerenciadorTarefa.envio.add(tarefa);
    Persistencia.save("enviar");
}

}
