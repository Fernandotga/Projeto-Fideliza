package br.com.fideliza.app.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "oferta")
public class Oferta extends AbstractEntity {

    @Column(name = "descricao_item")
    private String descricaoItem;
    @Column(name = "url_img")
    private String urlImg;
    @Lob
    @Column(name = "descricao_detalhe")
    private String descricaoDetalhe;
    @Column(name = "preco")
    private double preco;
    @Column(name = "data_inicio_oferta")
    @Temporal(TemporalType.DATE)
    private Date dataInicioOferta;
    @Column(name = "data_final_oferta")
    @Temporal(TemporalType.DATE)
    private Date dataFinalOferta;
    @JoinColumn(name = "empresa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresa;

    public Oferta() {
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getDescricaoDetalhe() {
        return descricaoDetalhe;
    }

    public void setDescricaoDetalhe(String descricaoDetalhe) {
        this.descricaoDetalhe = descricaoDetalhe;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDataInicioOferta() {
        return dataInicioOferta;
    }

    public void setDataInicioOferta(Date dataInicioOferta) {
        this.dataInicioOferta = dataInicioOferta;
    }

    public Date getDataFinalOferta() {
        return dataFinalOferta;
    }

    public void setDataFinalOferta(Date dataFinalOferta) {
        this.dataFinalOferta = dataFinalOferta;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
