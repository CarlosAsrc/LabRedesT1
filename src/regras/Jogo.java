package regras;

import java.util.ArrayList;
import java.util.Random;

public class Jogo {
	public static int inicio=0;
	
	public static String corporta(String a) {
		if (a.equals("amarela")) {
			return "pamarela";
		}
		if (a.equals("roxa")) {
			return "proxa";
		}
		if (a.equals("azul")) {
			return "pazul";
		}
		if (a.equals("verde")) {
			return "pverde";
		}
		if (a.equals("branca")) {
			return "pbranca";
		}
		return null;
		
	}
	public static ArrayList<Porta> portas= new ArrayList<Porta>();
	
	//conjunto das salas inferiores f1
		static	ArrayList<ArrayList<Integer>> cs1 = new ArrayList<ArrayList<Integer>>();
		//conjunto das salas inferiores f2
				static	ArrayList<ArrayList<Integer>> cs2 = new ArrayList<ArrayList<Integer>>();
	public static void sorteiaporta() {
		ArrayList<Integer> pamarela1 = new ArrayList<Integer>();
		pamarela1.add(0);
		pamarela1.add(3);
		Porta amarela1 = new Porta("amarela", "chave lendaria1", "", "fechada", pamarela1);
		ArrayList<Integer> pamarela2 = new ArrayList<Integer>();
		pamarela2.add(0);
		pamarela2.add(4);
		Porta amarela2 = new Porta("amarela","chave lendaria2", "", "fechada", pamarela2);
		
		
		//salasf1
		ArrayList<Integer> s1f1 = new ArrayList<Integer>();
		s1f1.add(1);
		s1f1.add(0);
		ArrayList<Integer> s2f1 = new ArrayList<Integer>();
		s2f1.add(3);
		s2f1.add(0);
		ArrayList<Integer> s3f1 = new ArrayList<Integer>();
		s3f1.add(5);
		s3f1.add(0);
		ArrayList<Integer> s4f1 = new ArrayList<Integer>();
		s4f1.add(7);
		s4f1.add(0);
		
		cs1.add(s1f1);
		cs1.add(s2f1);
		cs1.add(s3f1);
		cs1.add(s4f1);
		Porta roxa1 = new Porta("roxa","chave epic1","chave lendaria1","fechada",sp1());
		Porta azul1 = new Porta("azul","chave rare1","chave epic1","fechada",sp1());
		Porta verde1 = new Porta("verde","chave uncommon1","chave rare1","fechada",sp1());
		Porta branca1 = new Porta("branca","chave common1","chave uncommon1","aberta",sp1());
			
		//salasf2
				ArrayList<Integer> s1f2 = new ArrayList<Integer>();
				s1f2.add(1);
				s1f2.add(7);
				ArrayList<Integer> s2f2 = new ArrayList<Integer>();
				s2f2.add(3);
				s2f2.add(7);
				ArrayList<Integer> s3f2 = new ArrayList<Integer>();
				s3f2.add(5);
				s3f2.add(7);
				ArrayList<Integer> s4f2 = new ArrayList<Integer>();
				s4f2.add(7);
				s4f2.add(7);
				
				cs2.add(s1f2);
				cs2.add(s2f2);
				cs2.add(s3f2);
				cs2.add(s4f2);
				Porta roxa2 = new Porta("roxa","chave epic2","chave lendaria2","fechada",sp2());
				Porta azul2 = new Porta("azul","chave rare2","chave epic2","fechada",sp2());
				Porta verde2 = new Porta("verde","chave uncommon2","chave rare2","fechada",sp2());
				Porta branca2 = new Porta("branca","chave common2","chave uncommon2","aberta",sp2());
		
				portas.add(amarela1);
				portas.add(amarela2);
				portas.add(roxa1);
				portas.add(roxa2);
				portas.add(azul1);
				portas.add(azul2);
				portas.add(verde1);
				portas.add(verde2);
				portas.add(branca1);
				portas.add(branca2);
				
			//	System.out.println(portas);
	}
	public static ArrayList<Integer> sp1(){
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		Random rnd = new Random();
		int i=rnd.nextInt(cs1.size());
		a=cs1.get(i);
		cs1.remove(i);
		
		return a;
		}
	public static ArrayList<Integer> sp2(){
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		Random rnd = new Random();
		int i=rnd.nextInt(cs2.size());
		a=cs2.get(i);
		cs2.remove(i);
		
		return a;
		}
	
	
	public static boolean validamovimento(int a, int b, String d) {
		if (d.equals("n") ) {
			if (a>0) {
				return true;
			}else {
				return false;
			}
		}
		if (d.equals("s") ) {
			if (a<7) {
				return true;
			}else {
				return false;
			}
		}
		if (d.equals("l") ) {
			if (b<7) {
				return true;
			}else {
				return false;
			}
		}
		if (d.equals("o") ) {
			if (b>0) {
				return true;
			}else {
				return false;
			}
		}
		return false;
				
	}
public static String criaString(String a) {
	String b = new String();
	b=a;
	return b;
}
public static String criachat(ArrayList<String> a) {
	String imprime="";
	for (int i=0;i<a.size();i++) {
		 imprime = imprime+a.get(i)+"\n";
	}
	
	return imprime;
	
}
//Posicoes
public static ArrayList<Integer> pj1= new ArrayList<Integer>();
public static ArrayList<Integer> pj2= new ArrayList<Integer>();
public static ArrayList<Integer> pd1= new ArrayList<Integer>();
public static ArrayList<Integer> pd2= new ArrayList<Integer>();

public static void iniciarposicoes() {
	pj1.add(7);
	pj1.add(3);
	pj2.add(7);
	pj2.add(4);
	pd1.add(0);
	pd1.add(2);
	pd2.add(0);
	pd2.add(5);
}
}
