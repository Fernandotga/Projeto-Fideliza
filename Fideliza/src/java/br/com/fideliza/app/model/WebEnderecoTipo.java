package br.com.fideliza.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "web_endereco_tipo")
public class WebEnderecoTipo extends AbstractEntity {

    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "webEnderecoTipo")
    private List<Web> webList;

    public WebEnderecoTipo() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Web> getWebList() {
        return webList;
    }

    public void setWebList(List<Web> webList) {
        this.webList = webList;
    }
}
