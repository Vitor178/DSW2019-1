package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Entity;


@Entity
public class Site extends Usuario implements Serializable {
    
    private String url;
    private String nome;
    private String telefone;

   /* public Site(String url, String nome, String telefone, String email, String senha, Boolean ativo) {
        super(email, senha, ativo);
        this.url = url;
        this.nome = nome;
        this.telefone = telefone;
    }*/

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