package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PapelDAO;
import br.ufscar.dc.dsw.dao.SiteDAO;
import br.ufscar.dc.dsw.pojo.Papel;
import br.ufscar.dc.dsw.pojo.Site;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ManagedBean
@SessionScoped
public class SiteBean implements Serializable {

    private Site site;

    public String lista() {
        return "site/index.xhtml?faces-redirect=true";
    }

    public String cadastra() {
        site = new Site();
        return "form.xhtml?faces-redirect=true";
    }

    public String edita(Long id) {
        SiteDAO dao = new SiteDAO();
        site = dao.get(id);
        return "form.xhtml";
    }

    public String salva() {
        SiteDAO dao = new SiteDAO();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Papel papel = new PapelDAO().get(2L);
        if (site.getId() == null) {
            site.setSenha(encoder.encode(site.getSenha()));
            dao.save(site);
            site.getPapel().add(papel);
            site.setAtivo(true);
            dao.update(site);
        } else {
            site.getPapel().clear();
            site.getPapel().add(papel);
            dao.update(site);
        }
        return "index.xhtml";
    }

    public String delete(Site site) {
        SiteDAO dao = new SiteDAO();
        dao.delete(site);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Site> getSites() throws SQLException {
        SiteDAO dao = new SiteDAO();
        return dao.getAll();
    }

    public Site getSite() {
        return site;
    }
    
    public List<Papel> getPapel() throws SQLException {
        PapelDAO dao = new PapelDAO();
        return dao.getAll();
    }
}