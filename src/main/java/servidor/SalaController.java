package servidor;

import servidor.Entidades.*;

import java.util.ArrayList;
import java.util.List;

public class SalaController {
    private static List<Sala> salas = new ArrayList<>();

    public SalaController() {
        criarSalas();
    }

    public void criarSalas() {
        Sala sala1 = new Sala("sala1");
        Sala sala2 = new Sala("sala2");
        Sala sala3 = new Sala("sala3");
        Sala sala4 = new Sala("sala4");
        Sala sala5 = new Sala("sala5");
        Sala sala6 = new Sala("sala6");
        Sala sala7 = new Sala("sala7");
        Sala saida = new Sala("saida");

        sala1.adicionarPorta(new Porta(sala2, true));
        sala1.adicionarPorta(new Porta(sala3, true));
        sala1.adicionarPorta(new Porta(sala4, false));

        sala2.adicionarPorta(new Porta(sala1, true));
        sala2.adicionarPorta(new Porta(sala5, true));
        sala2.adicionarChave(new Chave("sala4"));

        sala5.adicionarPorta(new Porta(sala2, true));
        sala5.adicionarPorta(new Porta(sala3, true));
        sala5.adicionarChave(new Chave("sala7"));

        sala3.adicionarPorta(new Porta(sala5, true));
        sala3.adicionarPorta(new Porta(sala6, false));
        sala3.adicionarPorta(new Porta(sala1, true));
        sala3.adicionarPorta(new Porta(sala4, false));
        sala3.adicionarChave(new Chave("sala6"));


        sala4.adicionarPorta(new Porta(sala1, true));
        sala4.adicionarPorta(new Porta(sala3, true));
        sala4.adicionarPorta(new Porta(sala6, false));


        sala6.adicionarPorta(new Porta(sala3, true));
        sala6.adicionarPorta(new Porta(sala4, true));
        sala6.adicionarPorta(new Porta(sala7, false));

        sala7.adicionarPorta(new Porta(sala6, true));
        sala7.adicionarPorta(new Porta(saida, false));

        salas.add(sala1);
        salas.add(sala2);
        salas.add(sala3);
        salas.add(sala4);
        salas.add(sala5);
        salas.add(sala6);
        salas.add(sala7);
        salas.add(saida);
    }


    public static void posicionarJogador(Jogador jogador) {
        Sala sala = buscarSalaPeloNome("sala1");
        sala.adicionarJogador(jogador);
    }

    private static Sala buscarSalaPeloNome(String nome) {
        for(Sala sala: salas) {
            if (sala.getNome().equals(nome)) return sala;
        }
        return null;
    }

    public String examinar(Jogador jogador, String nomeObjeto) {
        Sala sala = buscarSalaPeloNome(jogador.getSala());
        if(sala.getNome().equals(nomeObjeto)) {
            return sala.toStringComSalasAdjacentes();
        }
        Objeto objeto = sala.buscarObjeto(nomeObjeto);
        if(objeto != null) {
            return objeto.toString();
        } else {
            return "Objeto ou sala não encontrado";
        }
    }

    public void mover(Jogador jogador, Character direcao) {

    }

    public void pegar(Jogador jogador, Objeto objeto) {

    }

    public void largar(Jogador jogador, Objeto objeto) {

    }

    public static void inventorio(Jogador jogador) {

    }

    public void usar(Jogador jogador, Objeto objeto, Objeto alvo) {

    }

    public void falar(Jogador jogador, String textoFala) {

    }

    public void Cochinchar(Jogador jogadorOrigem, String textoFala, Jogador jogadorDestino) {

    }

    public String toString() {
        return  salas.get(0).toString()+
                "\n"
                +salas.get(1).toString()
                +"\n"
                +salas.get(2).toString()
                +"\n"
                +salas.get(3).toString()
                +"\n"
                +salas.get(4).toString()
                +"\n"
                +salas.get(5).toString()
                +"\n"
                +salas.get(6).toString()
                +"\n"
                +salas.get(7).toString();
    }
}
