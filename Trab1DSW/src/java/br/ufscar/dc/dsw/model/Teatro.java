package br.ufscar.dc.dsw.model;

public class Teatro {

    private Integer cnpj;
    private String email;
    private String senha;
    private String nome;
    private String cidade;

    public Teatro(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public Teatro(String email, String senha, String nome, String cidade) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.cidade = cidade;
    }
    
    public Teatro(Integer cnpj, String email, String senha, String nome, String cidade){
        this(email,senha,nome,cidade);
        this.cnpj = cnpj;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    
    
}
