package servidor.Entidades;

import java.net.InetAddress;

public class Jogador implements Objeto {

    private InetAddress enderecoIP;
    private String nome;
    private String sala;

    public Jogador(String nome, String sala, InetAddress enderecoIP) {
        this.enderecoIP = enderecoIP;
    }

    public InetAddress getEnderecoIP() {
        return enderecoIP;
    }

    public void setEnderecoIP(InetAddress enderecoIP) {
        this.enderecoIP = enderecoIP;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
