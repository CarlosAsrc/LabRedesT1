package servidor;

import servidor.Entidades.*;

import java.util.List;

public class SalaController {
    private static List<Sala> salas;

    public SalaController() {
        criarSalas();
    }

    public void criarSalas() {
        Sala sala1 = new Sala(1);
        Sala sala2 = new Sala(2);
        Sala sala3 = new Sala(3);
        Sala sala4 = new Sala(4);
        Sala sala5 = new Sala(5);
        Sala sala6 = new Sala(6);
        Sala sala7 = new Sala(7);
        Sala saida = new Sala(8);

        sala1.posicionarObjeto(0, 0, new Porta(sala2, true));
        sala1.posicionarObjeto(0, 1, new Porta(sala3, true));
        sala1.posicionarObjeto(0, 2, new Porta(sala4, false));

        sala2.posicionarObjeto(2, 2, new Porta(sala1, true));
        sala2.posicionarObjeto(0, 2, new Porta(sala5, true));
        sala2.posicionarObjeto(1,1, new Chave("sala4"));

        sala5.posicionarObjeto(2, 0, new Porta(sala2, true));
        sala5.posicionarObjeto(2, 2, new Porta(sala3, true));
        sala5.posicionarObjeto(0,1, new Chave("sala7"));

        sala3.posicionarObjeto(0, 0, new Porta(sala5, true));
        sala3.posicionarObjeto(0, 2, new Porta(sala6, false));
        sala3.posicionarObjeto(2, 1, new Porta(sala1, true));
        sala3.posicionarObjeto(2, 1, new Porta(sala4, false));
        sala3.posicionarObjeto(2,2, new Chave("sala6"));

        sala4.posicionarObjeto(2, 0, new Porta(sala1, true));
        sala4.posicionarObjeto(1, 0, new Porta(sala3, true));
        sala4.posicionarObjeto(0, 1, new Porta(sala6,  false));

        sala6.posicionarObjeto(2, 0, new Porta(sala3, true));
        sala6.posicionarObjeto(2, 1, new Porta(sala4, true));
        sala6.posicionarObjeto(0, 0, new Porta(sala7,  false));

        sala7.posicionarObjeto(2, 2, new Porta(sala6, true));
        sala7.posicionarObjeto(0, 0, new Porta(saida,  false));
    }


    public static void posicionarJogador(Objeto jogador) {
        Sala sala = getSalaById(1);
        sala.posicionarObjeto(jogador);
    }

    private static Sala getSalaById(int id) {
        for(Sala sala: salas) {
            if (sala.getId() == id) return sala;
        }
        return null;
    }

    public static void mover(Jogador jogador, Character direcao) {

    }

    public static void pegar(Jogador jogador, Objeto objeto) {

    }

    public static void largar(Jogador jogador, Objeto objeto) {

    }

    public static void inventorio(Jogador jogador) {

    }

    public static void usar(Jogador jogador, Objeto objeto, Objeto alvo) {

    }

    public static void falar(Jogador jogador, String textoFala) {

    }

    public static void Cochinchar(Jogador jogadorOrigem, String textoFala, Jogador jogadorDestino) {

    }
}
