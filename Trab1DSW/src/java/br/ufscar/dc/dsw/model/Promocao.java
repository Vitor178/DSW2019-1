package br.ufscar.dc.dsw.model;


public class Promocao {
    private Integer preco;
    private String nomePeca;
    private String dia;
    private String horario;
    private Integer id;
    private Integer cnpj;


    public Promocao(Integer preco, String nomePeca, String dia, String horario, Integer id, Integer cnpj) {
        this.preco = preco;
        this.nomePeca = nomePeca;
        this.dia = dia;
        this.horario = horario;
        this.id = id;
        this.cnpj = cnpj;
    }

    public Promocao(int preco, String nomePeca, String dia, String horario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
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
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }    
    
}
