package br.ufscar.dc.dsw.pojo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Site extends Usuario{
    
    private String url;
    private String nome;
    private String telefone;
    @OneToMany
    private List<Promocao> promocoes;

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

    public List<Promocao> getPromocoes() {
        return promocoes;
    }

    public void setPromocoes(List<Promocao> promocoes) {
        this.promocoes = promocoes;
    }
    
    
}