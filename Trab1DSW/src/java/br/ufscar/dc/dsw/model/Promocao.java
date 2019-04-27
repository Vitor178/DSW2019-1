package br.ufscar.dc.dsw.model;


public class Promocao {
    private Integer id;
    private String cnpj;
    private float preco;
    private String nomePeca;
    private String dia;
    private String horario;

    public Promocao(Integer id, String cnpj, float preco, String nomePeca, String dia, String horario) {
        this.id = id;
        this.cnpj = cnpj;
        this.preco = preco;
        this.nomePeca = nomePeca;
        this.dia = dia;
        this.horario = horario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
    
}


    