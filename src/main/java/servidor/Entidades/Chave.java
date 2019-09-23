package servidor.Entidades;

public class Chave implements Objeto {

    private String sala;

    public Chave(String sala) {
        this.sala = sala;
    }

    @Override
    public String getNome() {
        return this.sala;
    }

    public String toString(){
        return "Chave que abre a sala "+sala;
    }
}
