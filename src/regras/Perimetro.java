public class Perimetro {
    private String direcao;
    private Double distancia;
    public Perimetro(String direcao, double distancia) {
        this.direcao = direcao;
        this.distancia = distancia;
    }
    public Double getDistancia(){ return distancia;}
    public String getDirecao(){ return direcao;}
}