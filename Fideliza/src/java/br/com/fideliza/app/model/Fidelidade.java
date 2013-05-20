package br.com.fideliza.app.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fidelidade")
public class Fidelidade extends AbstractEntity {

    @Column(name = "maximo_pontos")
    private int maximoPontos;
    @Column(name = "recompensa")
    private String recompensa;
    @Column(name = "validade_dias")
    private int validadeDias;
    @Lob
    @Column(name = "termos_recompensa")
    private String termosRecompensa;
    @Column(name = "usa_quantidade_limitada_checkin")
    private Boolean usaQuantidadeLimitadaCheckin;
    @Column(name = "quantidade_permitida")
    private Integer quantidadePermitida;
    @Column(name = "ativo")
    private Boolean ativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidelidade")
    private List<ClienteFidelidade> clienteFidelidadeList;
    @JoinColumn(name = "empresa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresa;

    public Fidelidade() {
    }

    public int getMaximoPontos() {
        return maximoPontos;
    }

    public void setMaximoPontos(int maximoPontos) {
        this.maximoPontos = maximoPontos;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }

    public int getValidadeDias() {
        return validadeDias;
    }

    public void setValidadeDias(int validadeDias) {
        this.validadeDias = validadeDias;
    }

    public String getTermosRecompensa() {
        return termosRecompensa;
    }

    public void setTermosRecompensa(String termosRecompensa) {
        this.termosRecompensa = termosRecompensa;
    }

    public Boolean getUsaQuantidadeLimitadaCheckin() {
        return usaQuantidadeLimitadaCheckin;
    }

    public void setUsaQuantidadeLimitadaCheckin(Boolean usaQuantidadeLimitadaCheckin) {
        this.usaQuantidadeLimitadaCheckin = usaQuantidadeLimitadaCheckin;
    }

    public Integer getQuantidadePermitida() {
        return quantidadePermitida;
    }

    public void setQuantidadePermitida(Integer quantidadePermitida) {
        this.quantidadePermitida = quantidadePermitida;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<ClienteFidelidade> getClienteFidelidadeList() {
        return clienteFidelidadeList;
    }

    public void setClienteFidelidadeList(List<ClienteFidelidade> clienteFidelidadeList) {
        this.clienteFidelidadeList = clienteFidelidadeList;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
