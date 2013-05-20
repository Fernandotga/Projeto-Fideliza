package br.com.fideliza.app.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "menssagem")
public class Menssagem extends AbstractEntity {

    @Column(name = "assunto")
    private String assunto;
    @Lob
    @Column(name = "menssagem")
    private String menssagem;
    @Column(name = "data_envio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnvio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mensagem")
    private List<ClienteMensagem> clienteMensagemList;
    @JoinColumn(name = "empresa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresa;

    public Menssagem() {
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public List<ClienteMensagem> getClienteMensagemList() {
        return clienteMensagemList;
    }

    public void setClienteMensagemList(List<ClienteMensagem> clienteMensagemList) {
        this.clienteMensagemList = clienteMensagemList;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
