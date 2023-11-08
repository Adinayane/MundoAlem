package model;

public class TipoPagamento extends Pagamento {

    private String descricao ;
    private int idTipo;
    
    public TipoPagamento(String descricao){
        this.descricao = descricao;
    }
    
    public TipoPagamento(){
        
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
}
