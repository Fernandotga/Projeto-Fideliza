package br.com.fideliza.app.controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.fideliza.app.annotation.Permission;
import br.com.fideliza.app.annotation.Public;
import br.com.fideliza.app.component.EmpresaSession;
import br.com.fideliza.app.exception.CommonException;
import br.com.fideliza.app.model.Empresa;
import br.com.fideliza.app.model.PerfilType;
import br.com.fideliza.app.repository.EmpresaRepository;
import br.com.fideliza.app.util.Utils;
import java.util.Locale;
import static br.com.caelum.vraptor.view.Results.referer;

@Resource
@Permission({PerfilType.MEMBRO, PerfilType.MODERADOR, PerfilType.ADMINISTRADOR})
public class EmpresaController {

    private final Result result;
    private final EmpresaRepository repository;
    private final EmpresaSession empresaSession;
    private final Validator validator;

    public EmpresaController(Result result, EmpresaRepository repository, EmpresaSession empresaSession, Validator validator) {
        this.result = result;
        this.repository = repository;
        this.empresaSession = empresaSession;
        this.validator = validator;
    }

    @Put("/empresa/{entity.id}")
    public void atualizar(Empresa entity) {
        validator.validate(entity);
        validator.onErrorRedirectTo(this).editar(entity);

        try {
            entity = repository.save(entity);
            result.include("notice", Utils.i18n("usuario.atualizado.sucesso")).redirectTo(this).listagem();
        } catch (CommonException e) {
            result.include("error", Utils.i18n(e.getMessage())).redirectTo(this).editar(entity);
        }
    }

    @Get("/empresa/criarEmpresa")
    public void criar(Empresa entity) {
        result
                .include("perfilList", PerfilType.values())
                .include("entity", entity);
    }

    @Get("/empresa/{entity.id}/editarEmpresa")
    public void editar(Empresa entity) {
        result.include("perfilList", PerfilType.values());

        if (entity.getEmail() == null) {
            result.include("entity", repository.find(entity.getId()));
        } else {
            result.include("entity", entity);
        }
    }

    @Get("/empresa")
    public void listagem() {
        result.include("entityList", repository.all());
    }

    @Delete("/empresa/{entity.id}")
    public void remover(Empresa entity) {
        repository.remove(entity);

        result
                .include("notice", Utils.i18n("usuario.removido.sucesso"))
                .redirectTo(this).listagem();
    }

    @Post("/empresa")
    public void salvar(Empresa entity) {
        validator.validate(entity);
        validator.onErrorRedirectTo(this).criar(entity);
        try {
            entity = repository.save(entity);
            result.include("notice", Utils.i18n("usuario.salvo.sucesso")).redirectTo(this).listagem();
        } catch (CommonException e) {
            result.include("error", Utils.i18n(e.getMessage())).redirectTo(this).criar(entity);
        }
    }

    @Public
    @Get("/translate/{language}/{country}")
    public void translateTo(String language, String country) {
        try {
            Locale.setDefault(new Locale(language, country));

            empresaSession.setLanguage(language + "_" + country.toUpperCase());

            result.use(referer()).redirect();
        } catch (IllegalStateException e) {
            result.redirectTo(IndexController.class).index();
        }
    }
}
