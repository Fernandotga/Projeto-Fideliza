package br.com.fideliza.app.component;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.fideliza.app.model.Empresa;
import java.io.Serializable;

@Component
@SessionScoped
public class EmpresaSession implements Serializable {

    private static final long serialVersionUID = 1L;
    private Empresa empresa;
    private String language;

    public boolean isLogged() {
        return empresa != null;
    }

    public void logout() {
        empresa = null;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
