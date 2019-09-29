package servidor;

import servidor.Entidades.*;

import java.util.ArrayList;
import java.util.List;

public class SalaController {
    private static List<Sala> salas = new ArrayList<>();
    private static Sala [][] mapa = new Sala[3][5];

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
        mapa[0][1] = sala4;
        mapa[1][0] = sala1;
        mapa[1][1] = sala3;
        mapa[1][2] = sala6;
        mapa[1][3] = sala7;
        mapa[1][4] = saida;
        mapa[2][0] = sala2;
        mapa[2][1] = sala5;

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

    private static int[] buscarPosicaoSala(String nome) {
        for(int i=0; i<mapa.length; i++) {
            for(int j=0; j<mapa[0].length; j++) {
                if(mapa[i][j] != null && mapa[i][j].getNome().equals(nome)) {
                    int [] posicoes = new int [2];
                    posicoes[0] = i;
                    posicoes[1] = j;
                    return posicoes;
                }
            }
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

    public String mover(Jogador jogador, Character direcao) {
        Sala sala = buscarSalaPeloNome(jogador.getSala());
        int posicaoAtual[] = buscarPosicaoSala(sala.getNome());
        if(posicaoAtual == null) {
            return "Sala atual do jogador não foi encontrada";
        }
        int i = posicaoAtual[0];
        int j = posicaoAtual[1];
        Sala salaDestino;
        switch (direcao) {
            case 'N':
                if (i > 0 && mapa[i - 1][j] != null) {
                    salaDestino = mapa[i - 1][j];
                } else {
                    return "Não existe sala nesta direcao";
                }
                break;

            case 'S':
                if (i < mapa[0].length && mapa[i + 1][j] != null) {
                    salaDestino = mapa[i + 1][j];
                } else {
                    return "Não existe sala nesta direcao";
                }
                break;

            case 'L':
                if (j < mapa.length && mapa[i][j + 1] != null) {
                    salaDestino = mapa[i][j + 1];
                } else {
                    return "Não existe sala nesta direcao";
                }
                break;

            case 'O':
                if (j > 0 && mapa[i][j-1] != null) {
                    salaDestino = mapa[i][j - 1];
                } else {
                    return "Não existe sala nesta direcao";
                }
                break;
            default: return "Direcao inválida";
        }

        Porta portaParaSala = (Porta) sala.buscarObjeto(salaDestino.getNome()+"porta");
        if (portaParaSala != null && portaParaSala.estaAberta()) {
            salaDestino.adicionarJogador(jogador);
            sala.removerJogador(jogador);
            jogador.setSala(salaDestino.getNome());
            return "Jogador se moveu  em direção "+direcao+" da sala "+sala.getNome()+" para a sala "+salaDestino.getNome();
        } else {
            return "Não existe porta aberta para a sala solicitada";
        }
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
