package br.com.fideliza.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cliente")
public class Cliente extends AbstractEntity {

    @Column(name = "nome_completo")
    private String nomeCompleto;
    @Column(name = "cep")
    private String cep;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "genero")
    private Character genero;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<ClienteFidelidade> clienteFidelidadeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<ClienteMensagem> clienteMensagemList;

    public Cliente() {
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<ClienteFidelidade> getClienteFidelidadeList() {
        return clienteFidelidadeList;
    }

    public void setClienteFidelidadeList(List<ClienteFidelidade> clienteFidelidadeList) {
        this.clienteFidelidadeList = clienteFidelidadeList;
    }

    public List<ClienteMensagem> getClienteMensagemList() {
        return clienteMensagemList;
    }

    public void setClienteMensagemList(List<ClienteMensagem> clienteMensagemList) {
        this.clienteMensagemList = clienteMensagemList;
    }
}
