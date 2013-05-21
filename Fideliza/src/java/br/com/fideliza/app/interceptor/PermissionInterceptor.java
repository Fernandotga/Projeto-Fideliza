package br.com.fideliza.app.interceptor;

import static br.com.caelum.vraptor.view.Results.http;

import java.util.Arrays;
import java.util.Collection;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.fideliza.app.annotation.Permission;
import br.com.fideliza.app.annotation.Public;
import br.com.fideliza.app.component.EmpresaSession;
import br.com.fideliza.app.controller.IndexController;
import br.com.fideliza.app.helper.Utils;
import br.com.fideliza.app.model.PerfilType;

@Intercepts
public class PermissionInterceptor implements Interceptor {

    private final Result result;
    private final EmpresaSession empresaSession;

    public PermissionInterceptor(Result result, EmpresaSession empresaSession) {
        this.result = result;
        this.empresaSession = empresaSession;
    }

    @Override
    public boolean accepts(ResourceMethod method) {
        return !(method.getMethod().isAnnotationPresent(Public.class) || method.getResource().getType().isAnnotationPresent(Public.class));
    }

    @Override
    public void intercept(InterceptorStack stack, ResourceMethod method, Object resource) {
        if (empresaSession.isLogged()) {
            Permission methodPermission = method.getMethod().getAnnotation(Permission.class);
            Permission controllerPermission = method.getResource().getType().getAnnotation(Permission.class);

            if (this.hasAccess(methodPermission) && this.hasAccess(controllerPermission)) {
                stack.next(method, resource);
            } else {
                result.use(http()).sendError(500, Utils.i18n("voce.nao.tem.permissao.para.tal.acao"));
            }
        } else {
            result.redirectTo(IndexController.class).index();
        }
    }

    private boolean hasAccess(Permission permission) {
        if (permission == null) {
            return true;
        }
        Collection<PerfilType> perfilList = Arrays.asList(permission.value());
        return perfilList.contains(empresaSession.getEmpresa().getPerfil());
    }
}
