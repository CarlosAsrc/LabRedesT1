package servidor.Entidades;

import java.net.InetAddress;

public class Jogador {

    private InetAddress enderecoIP;

    public Jogador(InetAddress enderecoIP) {
        this.enderecoIP = enderecoIP;
    }

    public InetAddress getEnderecoIP() {
        return enderecoIP;
    }

    public void setEnderecoIP(InetAddress enderecoIP) {
        this.enderecoIP = enderecoIP;
    }
}
