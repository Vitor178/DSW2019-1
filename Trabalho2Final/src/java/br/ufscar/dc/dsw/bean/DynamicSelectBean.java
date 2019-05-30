package br.ufscar.dc.dsw.bean;


import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.pojo.Teatro;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;
        
@ManagedBean(name = "dynamic")
public class DynamicSelectBean implements Serializable {

    private List<SelectItem> possiveisCidades;
    private String cidade;

    private List<Teatro> possiveisTeatros;
    private String teatro;

    @PostConstruct
    public void init() {
        criaListaPossiveisCidades();
        criaListaPossiveisTeatros();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
        criaListaPossiveisTeatros();
    }

    public List<SelectItem> getCidades() {
        return possiveisCidades;
    }

    private void criaListaPossiveisCidades() {
        TeatroDAO dao = new TeatroDAO();
        List<String> cidades = dao.getCidades();
        possiveisCidades = new ArrayList<>();
        if (cidades != null && cidades.size() > 0) {
            cidade = cidades.get(0);
            for(String s: cidades) {
                possiveisCidades.add(new SelectItem(s, s));
            }
        }
    }

    public String getTeatro() {
        return teatro;
    }

    public void setTeatro(String teatro) {
        this.teatro = teatro;
    }

    private void criaListaPossiveisTeatros() {
        possiveisTeatros = new TeatroDAO().getByCidade(this.cidade);
    }

    public List<Teatro> getTeatros() {
        return possiveisTeatros;
    }
}