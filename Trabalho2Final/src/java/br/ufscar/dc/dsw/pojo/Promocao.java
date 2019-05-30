package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Promocao implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private float preco;
    private String nome;
    @ManyToOne
    private Site site;
    @ManyToOne
    private Teatro teatro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date diahorario;

    
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomePeca) {
        this.nome = nomePeca;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Teatro getTeatro() {
        return teatro;
    }

    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
    }

    public Date getDiahorario() {
        return diahorario;
    }

    public void setDiahorario(Date diahorario) {
        this.diahorario = diahorario;
    }
    
    
    
}
