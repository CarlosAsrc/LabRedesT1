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
			return buscarPosicaoAleatoria();
		}

		// Os dois visíveis
		if (visibilidade1 && visibilidade2) {
			double distancia1 = medirDistancia(dragaoX, dragaoY, x1, y1);
			double distancia2 = medirDistancia(dragaoX, dragaoY, x2, y2);
			if (distancia1 >= distancia2) {
				return definirDirecao(x2, y2);
			} else {
				return definirDirecao(x1, y1);
			}
		}

		// Somente um visível
		if (visibilidade1) {
			return definirDirecao(x1, y1);
		} else {
			return definirDirecao(x2, y2);
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
			if (validarMovimento(perimetro.getDirecao())) {
				return perimetro.getDirecao();
			}
		}

		return "Nenhum movimento válido";
	}

	private static double medirDistancia(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.abs(x1 - x2) + Math.abs(y1 - y2));
	}

	private static String buscarPosicaoAleatoria() {
		int movimentoNumero;
		String movimento;
		while (true) {
			movimentoNumero = random.nextInt(4);
			movimento = direcoes.get(movimentoNumero);
		//	if (validarMovimento(movimento)) {
				return movimento;
			//}
		}
	}

	private static boolean validarMovimento(String movimento) {
		Integer xia = 0;
		Integer yia = 0;
		if (Estados.jogadorDaVez.equals("Dragao")) {
			xia = Jogo.pd1.get(0);
			yia = Jogo.pd1.get(1);
		}
		if (Estados.jogadorDaVez.equals("Night King")) {
			xia = Jogo.pd2.get(0);
			yia = Jogo.pd2.get(1);
		}

		if (movimento.equals("n")) {
			xia = xia - 1;
		}
		if (movimento.equals("s")) {
			xia = xia + 1;
		}
		if (movimento.equals("l")) {
			yia = yia + 1;
		}
		if (movimento.equals("o")) {
			yia = yia - 1;
		}

		for (int i = 0; i < Jogo.proibida.size(); i++) {
			if (xia == Jogo.proibida.get(i).get(0) && yia == Jogo.proibida.get(i).get(1)) {
				return false;
			}
		}
		return true;
	}
}
