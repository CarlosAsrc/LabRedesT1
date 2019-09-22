package servidor.Entidades;

import java.util.Random;

public class Sala {

    private int id;
    private Objeto [][] mapa;

    public Sala(int id) {
        this.id = id;
        mapa = new Objeto [3][3];
    }

    public void posicionarObjeto(int i, int j, Objeto objeto) {
        mapa[i][j] = objeto;
    }

    public void posicionarObjeto(Objeto objeto) {
        Random random = new Random();
        while(true) {
            int i = random.nextInt(10);
            int j = random.nextInt(10);
            if (mapa[i][random.nextInt(10)] == null) {
                mapa[i][j] = objeto;
                return;
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
