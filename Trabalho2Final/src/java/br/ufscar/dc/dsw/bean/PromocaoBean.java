package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.dao.SiteDAO;
import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.pojo.Promocao;
import br.ufscar.dc.dsw.pojo.Site;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class PromocaoBean implements Serializable {

    private Promocao promocao;

    public String lista() {
        return "promocao/index.xhtml";
    }

    public String cadastra() {
        promocao = new Promocao();
        return "form.xhtml?faces-redirect=true";
    }

    public String edita(Long id) {
        PromocaoDAO dao = new PromocaoDAO();
        promocao = dao.get(id);
        return "form.xhtml";
    }
                
    
    public String salva() {
        PromocaoDAO dao = new PromocaoDAO();
        TeatroDAO dao1 = new TeatroDAO();
        HttpServletRequest req = (HttpServletRequest)
        FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String email = req.getUserPrincipal().getName();
        if(promocao.getId() == null) {
            promocao.setTeatro(dao1.getByEmail(email));
            dao.save(promocao);
        } else {
            dao.update(promocao);
        }
        return "index.xhtml";
    }
    /*public String salva() {
        PromocaoDAO dao = new PromocaoDAO();
        if(promocao.getId() == null) {
            dao.update(promocao);
        } else {
            dao.save(promocao);
        }
        return "index.xhtml";
    }*/

    public String delete(Promocao promocao) {
        PromocaoDAO dao = new PromocaoDAO();
        dao.delete(promocao);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Promocao> getPromocoes() throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.getAll();
    }

    
    public Promocao getPromocao() {
        return promocao;
    }  
    
    public List<Site> getSites() throws SQLException {
        SiteDAO dao = new SiteDAO();
        return dao.getAll();
    }
}