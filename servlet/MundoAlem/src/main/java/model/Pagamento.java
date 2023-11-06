package model;



public class Pagamento {
    private int idPag;
    private double valor = 0.0;
    private int parcelas = 0;
    private double valorParcela = 0.0;
    private Usuario fk_cpf;
    private TipoPagamento fk_idTipo;
    
    public Pagamento(double valor, int parcelas, 
            Usuario fk_cpf, TipoPagamento fk_idTipo){
        this.valor = valor;
        this.parcelas = parcelas;
        this.valorParcela = parcelar(valor,parcelas);
        this.fk_cpf = fk_cpf;
        this.fk_idTipo = fk_idTipo;
    }
    
    public Pagamento(){
        
    }
    
    public int getIdPag(){
        return idPag;
    }
    
    public void setIdPag(int idPag){
        this.idPag = idPag;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public Usuario getFk_Cpf() {
        return fk_cpf;
    }

    public void setFk_Cpf(Usuario fk_cpf) {
        this.fk_cpf = fk_cpf;
    }

    public TipoPagamento getFk_idTipo() {
        return fk_idTipo;
    }

    public void setFk_idTipo(TipoPagamento fk_idTipo) {
        this.fk_idTipo = fk_idTipo;
    }

    public double parcelar(double valor, int parcela) {
        double resul = valor / parcela;
        return resul;
    }
}
