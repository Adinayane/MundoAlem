package usuario;

public class Usuario {

    private String cpf;
    private String nome;
    private String dataNasc;
    
    public Usuario(String cpf, String nome, String dataNasc){
        this.cpf=cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
    }
    
    public Usuario(){
        
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return cpf;
    }
}
