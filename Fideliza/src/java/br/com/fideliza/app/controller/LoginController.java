package br.com.fideliza.app.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fideliza.app.annotation.Public;
import br.com.fideliza.app.component.EmpresaSession;
import br.com.fideliza.app.helper.Utils;
import br.com.fideliza.app.model.Empresa;
import br.com.fideliza.app.repository.LoginRepository;
import static br.com.caelum.vraptor.view.Results.referer;

@Resource
public class LoginController {

    private final Result result;
    private final LoginRepository repository;
    private final EmpresaSession empresaSession;

    public LoginController(Result result, LoginRepository repository, EmpresaSession empresaSession) {
        this.result = result;
        this.repository = repository;
        this.empresaSession = empresaSession;
    }

    @Public
    @Post("/autenticar")
    public void autenticar(Empresa entity) {
        Empresa empresa = repository.autenticar(entity.getEmail(), entity.getPassword());

        if (empresa != null) {
            empresaSession.setEmpresa(empresa);

            try {
                result.use(referer()).redirect();
            } catch (IllegalStateException e) {
                result.redirectTo(IndexController.class).index();
            }
        } else {
            result.include("error", Utils.i18n("email.senha.incorreta")).redirectTo(IndexController.class).index();
        }
    }

    @Get("/logout")
    public void logout() {
        empresaSession.logout();
        result.redirectTo(IndexController.class).index();
    }
}
