package br.com.fideliza.app.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cliente_fidelidade_historico")
public class ClienteFidelidadeHistorico extends AbstractEntity {

    @Column(name = "data_inicio_checkin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicioCheckin;
    @Column(name = "status_fidelidade")
    private char statusFidelidade;
    @Column(name = "data_troca")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTroca;
    @Column(name = "pontos_acumulados")
    private int pontosAcumulados;
    @JoinColumn(name = "cliente_fidelidade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClienteFidelidade clienteFidelidade;

    public ClienteFidelidadeHistorico() {
    }

    public Date getDataInicioCheckin() {
        return dataInicioCheckin;
    }

    public void setDataInicioCheckin(Date dataInicioCheckin) {
        this.dataInicioCheckin = dataInicioCheckin;
    }

    public char getStatusFidelidade() {
        return statusFidelidade;
    }

    public void setStatusFidelidade(char statusFidelidade) {
        this.statusFidelidade = statusFidelidade;
    }

    public Date getDataTroca() {
        return dataTroca;
    }

    public void setDataTroca(Date dataTroca) {
        this.dataTroca = dataTroca;
    }

    public int getPontosAcumulados() {
        return pontosAcumulados;
    }

    public void setPontosAcumulados(int pontosAcumulados) {
        this.pontosAcumulados = pontosAcumulados;
    }

    public ClienteFidelidade getClienteFidelidade() {
        return clienteFidelidade;
    }

    public void setClienteFidelidade(ClienteFidelidade clienteFidelidade) {
        this.clienteFidelidade = clienteFidelidade;
    }
}
