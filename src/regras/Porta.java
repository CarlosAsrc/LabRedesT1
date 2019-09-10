package regras;

import java.util.ArrayList;

public class Porta {
String cor;
String chave;
String iten;
String situacao;
ArrayList<Integer> local = new ArrayList<Integer>();
public Porta(String cor, String chave, String iten, String situacao, ArrayList<Integer> local) {
	super();
	this.cor = cor;
	this.chave = chave;
	this.iten = iten;
	this.situacao = situacao;
	this.local = local;
}
public String getCor() {
	return cor;
}
public void setCor(String cor) {
	this.cor = cor;
}
public String getChave() {
	return chave;
}
public void setChave(String chave) {
	this.chave = chave;
}
public String getIten() {
	return iten;
}
public void setIten(String iten) {
	this.iten = iten;
}
public String getSituacao() {
	return situacao;
}
public void setSituacao(String situacao) {
	this.situacao = situacao;
}
public ArrayList<Integer> getLocal() {
	return local;
}
public void setLocal(ArrayList<Integer> local) {
	this.local = local;
}
@Override
public String toString() {
	return "Porta [cor=" + cor + ", chave=" + chave + ", iten=" + iten + ", situacao=" + situacao + ", local=" + local
			+ "]\n";
}

}
