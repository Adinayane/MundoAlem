package destino;

import usuario.Usuario;

public class DestinoEscolhido {
    
    public DestinoEscolhido(String dataIda, String dataVolta,
            Usuario fk_cpf, Destino fk_idDestino){
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
        this.fk_Cpf = fk_cpf;
        this.fk_idDestino = fk_idDestino;
    }
    
    public DestinoEscolhido(){
        
    }
    
    public int getNumViagem() {
        return numViagem;
    }

    public void setNumViagem(int numViagem) {
        this.numViagem = numViagem;
    }

    public String getDataIda() {
        return dataIda;
    }

    public void setDataIda(String dataIda) {
        this.dataIda = dataIda;
    }

    public String getDataVolta() {
        return dataVolta;
    }

    public void setDataVolta(String dataVolta) {
        this.dataVolta = dataVolta;
    }

    public Usuario getFk_Cpf() {
        return fk_Cpf;
    }

    public void setFk_Cpf(Usuario fk_Cpf) {
        this.fk_Cpf = fk_Cpf;
    }

    public Destino getFk_idDestino() {
        return fk_idDestino;
    }

    public void setFk_idDestino(Destino fk_idDestino) {
        this.fk_idDestino = fk_idDestino;
    }

    private int numViagem;
    private String dataIda;
    private String dataVolta;
    private Usuario fk_Cpf;
    private Destino fk_idDestino;
}
