<ul class="nav">
    <c:if test="${empresaSession.empresa == null}">
        <li class="active"><a href="/Fideliza/">Identificação</a></li> 
        <li><a href="/Fideliza/empresa/criarEmpresa">Cadastre-se</a></li> 
        </c:if>
        <c:if test="${empresaSession.empresa != null}">
        <li><a href="/Fideliza/principal">Painel</a></li> |
        <li><a href="#">Ofertas</a></li> 
        <li><a href="#">Fidelidade</a></li> 
        <li><a href="#">Clientes</a></li> 
        <li><a href="#">Mensagens</a></li> 
        <li><a href="#">Relatórios</a></li> 
        <li><a href="#">Empresa</a></li> 
        </c:if>
    <li class="divider-vertical"></li>    
    <li><a href="#">Sobre</a></li>
</ul>