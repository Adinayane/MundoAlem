package destino;

public class Destino {

    private int idDestino;
    private String nomeDestino;
    
    public Destino(String nomeDestino){
        this.nomeDestino = nomeDestino;
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

    @Override
    public String toString() {
        return "" + idDestino;
    }
}
