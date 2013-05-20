<div class="logo">
    <img src="/Fideliza/resources/img/logonova_p.png" alt="Fideliza" title="Fideliza" />
</div>

<label class="title">beta</label>

<div id="identification">
    <fmt:message key="bem.vindo" />:

    <c:choose>
        <c:when test="${userSession.user == null}">Visitante</c:when>
        <c:otherwise>
            ${userSession.user.nome} (<a href="/Fideliza/logout">sair</a>)
        </c:otherwise>
    </c:choose>
</div>