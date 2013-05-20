package br.com.fideliza.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefone")
public class Telefone extends AbstractEntity {

    @Column(name = "telefone")
    private String telefone;
    @JoinColumn(name = "telefone_tipo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TelefoneTipo telefoneTipo;
    @JoinColumn(name = "empresa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresa;

    public Telefone() {
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TelefoneTipo getTelefoneTipo() {
        return telefoneTipo;
    }

    public void setTelefoneTipo(TelefoneTipo telefoneTipo) {
        this.telefoneTipo = telefoneTipo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
