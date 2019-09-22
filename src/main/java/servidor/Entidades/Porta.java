package servidor.Entidades;

public class Porta implements Objeto {

    private Sala destino;
    private boolean aberta;

    public Porta(Sala destino, boolean aberta) {
        this.destino = destino;
        this.aberta = aberta;
    }

}
