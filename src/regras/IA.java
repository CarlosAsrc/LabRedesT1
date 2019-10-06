package regras;

import java.util.*;

import conexao.Estados;

public class IA {

	private static int dragaoX = 0;
	private static int dragaoY = 0;
	private static Random random = new Random();
	private static Map<Integer, String> direcoes = new HashMap<Integer, String>() {
		{
			put(0, "n");
			put(1, "s");
			put(2, "l");
			put(3, "o");
		}
	};

	public static String direcionar(Integer xia, Integer yia, Integer x1, Integer y1, Integer x2, Integer y2,
			boolean visibilidade1, boolean visibilidade2) {
		
		
		dragaoX = xia;
		dragaoY = yia;

		// Ambos invisíveis
		if ((!visibilidade1) && (!visibilidade2)) {
			String movimento ="";
			while (!Jogo.validamovimento(xia, yia, movimento)) {
				ArrayList <String> ms = new ArrayList <String>();
				ms.add("n");
				ms.add("s");
				ms.add("l");
				ms.add("o");
				
				    Random random = new Random();        
		            int intervalo_randomico = random.nextInt(3);
		            movimento = ms.get(intervalo_randomico);
		            
			}
			return movimento;
		}

		// Os dois visíveis
		if (visibilidade1 && visibilidade2) {
			double distancia1 = medirDistancia(dragaoX, dragaoY, x1, y1);
			double distancia2 = medirDistancia(dragaoX, dragaoY, x2, y2);
			if (distancia1 >= distancia2) {
			return	movimentofinal(xia,yia,definirDirecao(x2, y2)) ;
			} else {
				return	movimentofinal(xia,yia,definirDirecao(x1, y1));
			}
		}

		// Somente um visível
		if (visibilidade1) {
			return	movimentofinal(xia,yia,definirDirecao(x1, y1));
		} else {
			return	movimentofinal(xia,yia,definirDirecao(x2, y2));
		}
	}

	private static String definirDirecao(int jogadorX, int jogadorY) {
		double distanciaN = medirDistancia(dragaoX - 1, dragaoY, jogadorX, jogadorY);
		double distanciaS = medirDistancia(dragaoX + 1, dragaoY, jogadorX, jogadorY);
		double distanciaL = medirDistancia(dragaoX, dragaoY + 1, jogadorX, jogadorY);
		double distanciaO = medirDistancia(dragaoX, dragaoY - 1, jogadorX, jogadorY);
		Perimetro perimetroN = new Perimetro("n", distanciaN);
		Perimetro perimetroS = new Perimetro("s", distanciaS);
		Perimetro perimetroL = new Perimetro("l", distanciaL);
		Perimetro perimetroO = new Perimetro("o", distanciaO);
		List<Perimetro> perimetros = new ArrayList<Perimetro>() {
			{
				add(perimetroN);
				add(perimetroS);
				add(perimetroL);
				add(perimetroO);
			}
		};

		perimetros.sort(Comparator.comparingDouble(Perimetro::getDistancia));

		for (Perimetro perimetro : perimetros) {
			
				return perimetro.getDirecao();
			
		}

		return "Nenhum movimento válido";
	}

	private static double medirDistancia(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.abs(x1 - x2) + Math.abs(y1 - y2));
	}

	private static String movimentofinal(Integer xia, Integer yia, String movimento) {
		
	
	
			if (Jogo.validamovimento(xia, yia, movimento)) {
				return movimento;
			}
			else {
				while (!Jogo.validamovimento(xia, yia, movimento)) {
					ArrayList <String> ms = new ArrayList <String>();
					ms.add("n");
					ms.add("s");
					ms.add("l");
					ms.add("o");
					
					    Random random = new Random();        
			            int intervalo_randomico = random.nextInt(3);
			            movimento = ms.get(intervalo_randomico);
			            
				}
				return movimento;
			

		}
	}

	
}
