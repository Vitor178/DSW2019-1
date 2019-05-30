package br.ufscar.dc.dsw.pojo;


import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TEATRO")
@NamedQueries({
    @NamedQuery(name = "Teatro.findAll", query = "SELECT c FROM Teatro c"), 
    @NamedQuery(name = "Teatro.findByNome", query = "SELECT c FROM Teatro c" 
            + " WHERE UPPER(c.nome) LIKE :nome ORDER BY c.nome")})
public class Teatro extends Usuario{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME")
    private String nome;
    private String cidade;
    private String cnpj;
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


    public List<Promocao> getPromocoes() {
        return promocoes;
    }

    public void setPromocoes(List<Promocao> promocoes) {
        this.promocoes = promocoes;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Teatro)) {
            return false;
        }
        Teatro other = (Teatro) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return nome + "/" + cidade;
    }
    
}
