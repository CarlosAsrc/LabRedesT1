package regras;

import java.util.ArrayList;
import java.util.Random;

import conexao.Estados;
import javafx.scene.image.ImageView;

public class Jogo {
	public static int inicio=0;
	public static String movimentos;
	public static boolean jogardado = false;
	public static ArrayList<String> jogadores = new ArrayList<String>();
	public static ArrayList<String> chatarray = new ArrayList<String>();
	public static int jogadordavez = 1;
	// Matriz
	public static ArrayList<ArrayList<String>> slinhas = new ArrayList<ArrayList<String>>();
public static ArrayList<ArrayList> piportas(){
	ArrayList a1 = new ArrayList<>();
	a1.add(1);
	a1.add(0);
	ArrayList a2 = new ArrayList<>();
	a2.add(3);
	a2.add(0);
	ArrayList a3 = new ArrayList<>();
	a3.add(5);
	a3.add(0);
	ArrayList a4 = new ArrayList<>();
	a4.add(7);
	a4.add(0);
	ArrayList a5 = new ArrayList<>();
	a5.add(1);
	a5.add(7);
	ArrayList a6 = new ArrayList<>();
	a6.add(3);
	a6.add(7);
	ArrayList a7 = new ArrayList<>();
	a7.add(5);
	a7.add(7);
	ArrayList a8 = new ArrayList<>();
	a8.add(7);
	a8.add(7);
	
	
	ArrayList<ArrayList> portas = new ArrayList<ArrayList>();
	
	portas.add(a1);
	portas.add(a2);
	portas.add(a3);
	portas.add(a4);
	portas.add(a5);
	portas.add(a6);
	portas.add(a7);
	portas.add(a8);
	
	
	return portas;
	
			
}
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
				for (int i=0;i<proibida.size();i++) {
					if (proibida.get(i).get(0)==a-1&&proibida.get(i).get(1)==b) {
						
						return false;
					}
				}
				return true;
			}else {
				return false;
			}
		}
		if (d.equals("s") ) {
			if (a<7) {
				for (int i=0;i<proibida.size();i++) {
					if (proibida.get(i).get(0)==a+1&&proibida.get(i).get(1)==b) {
						
						return false;
					}
				}
				return true;
			}else {
				return false;
			}
		}
		if (d.equals("l") ) {
			if (b<7) {
				for (int i=0;i<proibida.size();i++) {
					if (proibida.get(i).get(0)==a&&proibida.get(i).get(1)==b+1) {
						
						return false;
					}
				}
				return true;
			}else {
				return false;
			}
		}
		if (d.equals("o") ) {
			if (b>0) {
				for (int i=0;i<proibida.size();i++) {
					if (proibida.get(i).get(0)==a&&proibida.get(i).get(1)==b-1) {
						
						return false;
					}
				}
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
public static ArrayList<ArrayList<Integer>> paredes = new ArrayList<ArrayList<Integer>>();
public static ArrayList<ArrayList<Integer>> proibida = new ArrayList<ArrayList<Integer>>();



public static void iniciarposicoes() {
	pj1.add(7);
	pj1.add(3);
	pj2.add(7);
	pj2.add(4);
	pd1.add(0);
	pd1.add(2);
	pd2.add(0);
	pd2.add(5);
	ArrayList<Integer> parede1 = new ArrayList<Integer>();
	ArrayList<Integer> parede2 = new ArrayList<Integer>();
	ArrayList<Integer> parede3 = new ArrayList<Integer>();
	ArrayList<Integer> parede4 = new ArrayList<Integer>();
	ArrayList<Integer> parede5 = new ArrayList<Integer>();
	ArrayList<Integer> parede6 = new ArrayList<Integer>();
	ArrayList<Integer> parede7 = new ArrayList<Integer>();
	ArrayList<Integer> parede8 = new ArrayList<Integer>();
	ArrayList<Integer> parede9 = new ArrayList<Integer>();
	ArrayList<Integer> parede10 = new ArrayList<Integer>();
	parede1.add(0);
	parede1.add(0);
	parede2.add(0);
	parede2.add(1);
	parede3.add(0);
	parede3.add(6);
	parede4.add(0);
	parede4.add(7);
	parede5.add(2);
	parede5.add(0);
	parede6.add(2);
	parede6.add(7);
	parede7.add(4);
	parede7.add(0);
	parede8.add(4);
	parede8.add(7);
	parede9.add(6);
	parede9.add(0);
	parede10.add(6);
	parede10.add(7);
	
	paredes.add(parede1);
	paredes.add(parede2);
	paredes.add(parede3);
	paredes.add(parede4);
	paredes.add(parede5);
	paredes.add(parede6);
	paredes.add(parede7);
	paredes.add(parede8);
	paredes.add(parede9);
	paredes.add(parede10);

	
	for (int i=0;i<paredes.size();i++) {
		proibida.add(paredes.get(i));
	}
	ArrayList<Integer>p1 = new ArrayList<Integer>();
	p1.add(1);
	p1.add(0);
	ArrayList<Integer>p2 = new ArrayList<Integer>();
	p2.add(3);
	p2.add(0);
	ArrayList<Integer>p3 = new ArrayList<Integer>();
	p3.add(5);
	p3.add(0);
	ArrayList<Integer>p4 = new ArrayList<Integer>();
	p4.add(7);
	p4.add(0);
	ArrayList<Integer>p5 = new ArrayList<Integer>();
	p5.add(1);
	p5.add(7);
	ArrayList<Integer>p6 = new ArrayList<Integer>();
	p6.add(3);
	p6.add(7);
	ArrayList<Integer>p7 = new ArrayList<Integer>();
	p7.add(5);
	p7.add(7);
	ArrayList<Integer>p8 = new ArrayList<Integer>();
	p8.add(7);
	p8.add(7);
	ArrayList<Integer>p9 = new ArrayList<Integer>();
	p9.add(7);
	p9.add(3);	
	ArrayList<Integer>p10 = new ArrayList<Integer>();
	p10.add(7);
	p10.add(4);
	ArrayList<Integer>p11 = new ArrayList<Integer>();
	p11.add(0);
	p11.add(3);
	ArrayList<Integer>p12 = new ArrayList<Integer>();
	p12.add(0);
	p12.add(4);
	proibida.add(p1);
	proibida.add(p2);
	proibida.add(p3);
	proibida.add(p4);
	proibida.add(p5);
	proibida.add(p6);
	proibida.add(p7);
	proibida.add(p8);
	proibida.add(p9);
	proibida.add(p10);
	proibida.add(p11);
	proibida.add(p12);
	
	
	}
}
