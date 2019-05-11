package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Promocao implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private float preco;
    private String nomePeca;
    private String dia;
    private String horario;
    
    private Teatro teatro;
    private Site site;

    
    
}
