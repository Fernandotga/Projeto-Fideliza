package br.com.fideliza.app.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cliente_fidelidade")
public class ClienteFidelidade extends AbstractEntity {

    @Column(name = "pontos")
    private int pontos;
    @Column(name = "data_fidelidade")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFidelidade;
    @JoinColumn(name = "fidelidade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Fidelidade fidelidade;
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteFidelidade")
    private List<ClienteFidelidadeHistorico> clienteFidelidadeHistoricoList;

    public ClienteFidelidade() {
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Date getDataFidelidade() {
        return dataFidelidade;
    }

    public void setDataFidelidade(Date dataFidelidade) {
        this.dataFidelidade = dataFidelidade;
    }

    public Fidelidade getFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(Fidelidade fidelidade) {
        this.fidelidade = fidelidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ClienteFidelidadeHistorico> getClienteFidelidadeHistoricoList() {
        return clienteFidelidadeHistoricoList;
    }

    public void setClienteFidelidadeHistoricoList(List<ClienteFidelidadeHistorico> clienteFidelidadeHistoricoList) {
        this.clienteFidelidadeHistoricoList = clienteFidelidadeHistoricoList;
    }
}
