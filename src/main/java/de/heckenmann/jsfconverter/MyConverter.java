package de.heckenmann.jsfconverter;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@RequestScoped
@Named
public class MyConverter implements Converter {

    @EJB
    private MyDao dao;

    @Override
    public Object getAsObject(final FacesContext context, final UIComponent component,
            final String value) {
        return this.dao.getById(Integer.parseInt(value));
    }

    @Override
    public String getAsString(final FacesContext context, final UIComponent component,
            final Object value) {
        return Integer.toString(((ClassToConvert) value).getId());
    }

    /*
     * GETTER & SETTER
     */
    public MyDao getDao() {
        return this.dao;
    }

    public void setDao(final MyDao dao) {
        this.dao = dao;
    }
}
