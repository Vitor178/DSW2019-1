package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PapelDAO;
import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.pojo.Papel;
import br.ufscar.dc.dsw.pojo.Teatro;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ManagedBean
@SessionScoped
public class TeatroBean implements Serializable {

    private Teatro teatro;

    public String lista() {
        return "teatro/index.xhtml";
    }

    public String cadastra() {
        teatro = new Teatro();
        return "form.xhtml?faces-redirect=true";
    }

    public String edita(Long id) {
        TeatroDAO dao = new TeatroDAO();
        teatro = dao.get(id);
        return "form.xhtml";
    }

    public String salva() {
        TeatroDAO dao = new TeatroDAO();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Papel papel = new PapelDAO().get(3L);
        if (teatro.getId() == null) {
            teatro.setSenha(encoder.encode(teatro.getSenha()));
            dao.save(teatro);
            teatro.getPapel().add(papel);
            teatro.setAtivo(true);
            dao.update(teatro);
        } else {
            teatro.getPapel().clear();
            teatro.getPapel().add(papel);
            dao.update(teatro);
        }
        return "index.xhtml";
    }

    public String delete(Teatro teatro) {
        TeatroDAO dao = new TeatroDAO();
        dao.delete(teatro);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Teatro> getTeatros() throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        return dao.getAll();
    }

    public Teatro getTeatro() {
        return teatro;
    }
    
    public List<Papel> getPapel() throws SQLException {
        PapelDAO dao = new PapelDAO();
        return dao.getAll();
    }
}
