
package br.ufscar.dc.dsw.model;


public class Cadastro {
    private String tipo;
    private String email;
    private String senha;

    public Cadastro(String tipo, String email, String senha) {
        this.tipo = tipo;
        this.email = email;
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
