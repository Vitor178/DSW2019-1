package br.ufscar.dc.dsw.pojo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Teatro extends Usuario{
    
    private String cnpj;
    private String nome;
    private String cidade;
    @OneToMany
    private List<Promocao> promocoes;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public List<Promocao> getPromocoes() {
        return promocoes;
    }

    public void setPromocoes(List<Promocao> promocoes) {
        this.promocoes = promocoes;
    }
    
    
}
