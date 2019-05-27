package br.ufscar.dc.dsw.converter;

import br.ufscar.dc.dsw.dao.PapelDAO;
import br.ufscar.dc.dsw.pojo.Papel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("PapelConverter")
public class PapelConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id = Long.parseLong(string);
        PapelDAO dao = new PapelDAO();
        return dao.get(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Papel papel = (Papel) o;
        return papel.getId().toString();
    }
    
}
