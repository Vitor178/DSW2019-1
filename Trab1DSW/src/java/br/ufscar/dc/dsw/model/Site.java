
package br.ufscar.dc.dsw.model;

public class Site {
    
    private Integer id;
    private String email;
    private String senha;
    private String url;
    private String nome;
    private String telefone;

    public Site(Integer id) {
        this.id = id;
    }

    public Site(String email, String senha, String url, String nome, String telefone) {
        this.email = email;
        this.senha = senha;
        this.url = url;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public Site(Integer id, String email, String senha, String url, String nome, String telefone){
        this(email,senha,url,nome,telefone);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
