package br.com.fideliza.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "web")
public class Web extends AbstractEntity {

    @Column(name = "url")
    private String url;
    @JoinColumn(name = "web_endereco_tipo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WebEnderecoTipo webEnderecoTipo;
    @JoinColumn(name = "empresa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresa;

    public Web() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public WebEnderecoTipo getWebEnderecoTipo() {
        return webEnderecoTipo;
    }

    public void setWebEnderecoTipo(WebEnderecoTipo webEnderecoTipo) {
        this.webEnderecoTipo = webEnderecoTipo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
