package conexao;

public class Tarefa {
public String acao;
public String mensagem;
public Tarefa(String acao, String mensagem) {
	super();
	this.acao = acao;
	this.mensagem = mensagem;
}
public String getAcao() {
	return acao;
}
public void setAcao(String acao) {
	this.acao = acao;
}
public String getMensagem() {
	return mensagem;
}
public void setMensagem(String mensagem) {
	this.mensagem = mensagem;
}
@Override
public String toString() {
	return "Tarefa [acao=" + acao + ", mensagem=" + mensagem + "]\n";
}

}
