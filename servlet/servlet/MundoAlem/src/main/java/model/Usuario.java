package model;

public class Usuario {

    private String cpf;
    private String nome;
    private String dataNasc;
    private String email;
    private String senha;
    
    public Usuario(String cpf, String nome, String dataNasc, String email, String senha){
        this.cpf=cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.email = email;
        this.senha = senha;
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
    
    public String getEmail() {
    	return email;
    }

    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getSenha() {
    	return senha;
    }
    
    public void setSenha(String senha) {
    	this.senha = senha;
    }
    
    @Override
    public String toString() {
        return cpf;
    }
}
