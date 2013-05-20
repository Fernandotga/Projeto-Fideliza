package br.com.fideliza.app.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_mensagem")
public class ClienteMensagem extends AbstractEntity {

    @JoinColumn(name = "mensagem", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Menssagem mensagem;
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente cliente;

    public ClienteMensagem() {
    }

    public Menssagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Menssagem mensagem) {
        this.mensagem = mensagem;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
