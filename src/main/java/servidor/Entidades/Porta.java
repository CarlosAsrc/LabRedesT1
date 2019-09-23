package servidor.Entidades;

public class Porta implements Objeto {

    private Sala destino;
    private boolean aberta;

    public Porta(Sala destino, boolean aberta) {
        this.destino = destino;
        this.aberta = aberta;
    }

    @Override
    public String getNome() {
        return this.destino.getNome()+"porta";
    }

    public String toString(){
        return "Porta "+(aberta ? "aberta ": "fechada ")+"que leva para "+destino.getNome();
    }
}
