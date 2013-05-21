package br.com.fideliza.app.repository;

import br.com.fideliza.app.model.Empresa;

public interface LoginRepository {

    Empresa autenticar(String email, String senha);
}
