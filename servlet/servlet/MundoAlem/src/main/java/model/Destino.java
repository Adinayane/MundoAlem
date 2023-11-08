package model;

public class Destino {

    private int idDestino;
    private String nomeDestino;
    private double valorDestino;
    
    public Destino(String nomeDestino, double valorDestino){
        this.nomeDestino = nomeDestino;
        this.valorDestino = valorDestino;
    }
    
    public Destino(){
        
    }
    
    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getNomeDestino() {
        return nomeDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }
    
    public double getValorDestino() {
        return valorDestino;
    }

    public void setValorDestino(double valorDestino) {
        this.valorDestino = valorDestino;
    }

    @Override
    public String toString() {
        return "" + idDestino;
    }
}
