
package br.ufscar.dc.dsw.model;


public class Administrador {

    public Administrador(Integer cpf, String prenome, String sobrenome, String email, String senha) {
        this.cpf = cpf;
        this.prenome = prenome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }
    private Integer cpf;
    private String prenome;
    private String sobrenome;
    private String email;
    private String senha;   

    public Administrador(String prenome, String sobrenome, String email, String senha) {        
        this.prenome = prenome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }
    
    public Administrador(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getPrenome() {
        return prenome;
    }

    public void setPrenome(String prenome) {
        this.prenome = prenome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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
}

