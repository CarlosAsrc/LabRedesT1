package servidor.Entidades;

public class Porta implements Objeto {

    private Sala destino;

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    private boolean aberta;

    public Porta(Sala destino, boolean aberta) {
        this.destino = destino;
        this.aberta = aberta;
    }

    public boolean estaAberta() {
        return aberta;
    }

    @Override
    public String getNome() {
        return this.destino.getNome()+"porta";
    }

    public Sala getDestino() {
        return destino;
    }

    public void setDestino(Sala destino) {
        this.destino = destino;
    }

    public String toString(){
        return "Porta "+(aberta ? "aberta ": "fechada ")+"que leva para "+destino.getNome();
    }
}
