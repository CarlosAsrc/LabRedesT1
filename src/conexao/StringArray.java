package conexao;

import regras.Jogo;

public class StringArray {
public static String portas() {
	String a ="";
	for (int i=0;i<Jogo.portas.size();i++) {
	a=a+Jogo.portas.get(i).getCor();
	a=a+":";
	a=a+Jogo.portas.get(i).getChave();
	a=a+":";
	a=a+Jogo.portas.get(i).getIten();
	a=a+":";
	a=a+Jogo.portas.get(i).getSituacao();
	a=a+":";
	a=a+Jogo.portas.get(i).getLocal().get(0);
	a=a+":";
	a=a+Jogo.portas.get(i).getLocal().get(1);
	if (i<Jogo.portas.size()-1) {
	a=a+">";
	}
	
	}
	return a;
}
}
