package de.heckenmann.jsfconverter;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class CdiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private MyDao dao;

    private Collection<ClassToConvert> list;

    private ClassToConvert selection;

    public MyDao getDao() {
        return this.dao;
    }

    public Collection<ClassToConvert> getList() {
        return this.list;
    }

    public ClassToConvert getSelection() {
        return this.selection;
    }

    @PostConstruct
    public void init() {
        this.list = this.dao.getAll();
    }

    public void setDao(final MyDao dao) {
        this.dao = dao;
    }

    public void setList(final Collection<ClassToConvert> list) {
        this.list = list;
    }

    public void setSelection(final ClassToConvert selection) {
        this.selection = selection;
    }
}
