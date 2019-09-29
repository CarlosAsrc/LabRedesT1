package servidor.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Sala implements Objeto{

    private String nome;
    private List<Chave> chaves;
    private List<Porta> portas;
    private List<Jogador> jogadores;


    public Sala(String nome) {
        this.nome = nome;
        chaves = new ArrayList<>();
        portas = new ArrayList<>();
        jogadores = new ArrayList<>();
    }

    public void adicionarChave(Chave chave) {
        this.chaves.add(chave);
    }

    public void adicionarPorta(Porta porta) {
        this.portas.add(porta);
    }

    public void adicionarJogador(Jogador jogador) {
        this.jogadores.add(jogador);
    }

    public Objeto buscarObjeto(String nome) {
        if(this.nome.equals(nome)) {
            return this;
        }
        for(Chave chave: chaves) {
            if(chave.getNome().equals(nome)) {
                return chave;
            }
        }
        for(Porta porta: portas) {
            if(porta.getNome().equals(nome)) {
                return porta;
            }
        }
        return null;
    }

    @Override
    public String getNome() {
        return this.nome;
    }


    public String toString(){
        String chaves="";
        for(Chave chave: this.chaves) {
            chaves = chaves +" "+chave.getNome();
        }

        String portas="";
        for(Porta porta: this.portas) {
            portas = portas +" "+porta.getNome();
        }
        String jogadores="";
        for(Jogador jogador: this.jogadores) {
            jogadores = jogadores +" "+jogador.getNome();
        }
        return "__________________________________________________________\n"+
                "| "+nome+
                "\n| Portas: "
                +portas
                +"\n| Chaves: "
                +chaves
                +"\n| Jogadores: "
                +jogadores
                +"\n__________________________________________________________";
    }


    public String toStringComSalasAdjacentes() {
        String resp = this.toString()+"\nSALAS ADJACENTES:";
        for(Porta porta: portas) {
            resp = resp+"\n"+porta.getDestino().toString();
        }
        return resp;
    }

    public void removerJogador(Jogador jogador) {
        jogadores.remove(jogador);
    }
}