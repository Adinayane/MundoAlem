package pagamento;

public class TipoPagamento extends Pagamento {

    private String descricao ;
    private String dataVenc;
    private int idTipo;
    
    public TipoPagamento(String descricao, String dataVenc){
        this.descricao = descricao;
        this.dataVenc = dataVenc;
    }
    
    public TipoPagamento(){
        
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataVenc() {
        return dataVenc;
    }

    public void setDataVenc(String dataVenc) {
        this.dataVenc = dataVenc;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
}
