package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Entity;


@Entity
public class Teatro extends Usuario implements Serializable {
    
    private String cnpj;
    private String nome;
    private String cidade;

    /*public Teatro(String cnpj, String nome, String cidade, String email, String senha, Boolean ativo) {
        super(email, senha, ativo);
        this.cnpj = cnpj;
        this.nome = nome;
        this.cidade = cidade;
    }*/

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
    
    
}
