<body>
    <fieldset>
        <div id="legend">
            <legend class=""> 
                <fmt:message key="empresa.empresa"/> 
                <small> <fmt:message key="app.novo"/> </small>
            </legend>  
        </div> 

        <c:choose>
            <c:when test="${entity.id == null}">
                <c:set var="uri" value="/empresa" />
            </c:when>
            <c:otherwise>
                <c:set var="uri" value="/empresa/${entity.id}" />
            </c:otherwise>
        </c:choose>

        <form action="${pageContext.request.contextPath}${uri}" method="POST">
            <c:if test="${entity.id != null}">
                <input type="hidden" name="_method" value="put"/>
            </c:if>

            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#dados" data-toggle="tab">Dados Cadastrais</a>
                </li>
                <li>
                    <a href="#localizacao" data-toggle="tab">Localização</a>
                </li>
                <li>
                    <a href="#logo" data-toggle="tab">Logo</a>
                </li>
                <li>
                    <a href="#autenticacao" data-toggle="tab">Autenticação</a>
                </li>
            </ul>

            <div id="myTabContent" class="tab-content">

                <div class="tab-pane active in" id="dados">

                    <div class="control-group">
                        <label class="control-label" for="fantasia">
                            <fmt:message key="empresa.nome.fantasia"/>
                        </label>
                        <div class="controls">
                            <input type="text" id="fantasia" name="fantasia" class="input-xxlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="razao">
                            <fmt:message key="empresa.razao.social"/>
                        </label>
                        <div class="controls">
                            <input type="text" id="razao" name="razao" class="input-xxlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="cnpj">
                            <fmt:message key="empresa.cnpj"/>
                        </label>
                        <div class="controls">
                            <input type="text" id="cnpj" name="cnpj" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="responsavel">
                            <fmt:message key="empresa.responsavel"/>
                        </label>
                        <div class="controls">
                            <input type="text" id="responsavel" name="responsavel" class="input-xxlarge">
                        </div>
                    </div>


                </div>
            </div>

            <div class="tab-pane fade" id="localizacao">
                <div class="control-group">
                    <label class="control-label" for="cep">
                        <fmt:message key="empresa.cep"/>
                    </label>
                    <div class="controls">
                        <input type="text" id="cep" name="cep" class="input-xlarge">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="uf">
                        <fmt:message key="empresa.uf"/>
                    </label>
                    <div class="controls">
                        <input type="text" id="uf" name="uf" class="input-small">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="cidade">
                        <fmt:message key="empresa.cidade"/>
                    </label>
                    <div class="controls">
                        <input type="text" id="cidade" name="cidade" class="input-small">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="bairro">
                        <fmt:message key="empresa.bairro"/>
                    </label>
                    <div class="controls">
                        <input type="text" id="bairro" name="bairro" class="input-xxlarge">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="endereco">
                        <fmt:message key="empresa.endereco"/>
                    </label>
                    <div class="controls">
                        <input type="text" id="endereco" name="endereco" class="input-xxlarge">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="latitude">
                        <fmt:message key="empresa.latitude"/>
                    </label>
                    <div class="controls">
                        <input type="text" id="latitude" name="latitude" class="input-xxlarge">
                    </div>
                </div>


                <div class="control-group">
                    <label class="control-label" for="longitude">
                        <fmt:message key="empresa.longitude"/>
                    </label>
                    <div class="controls">
                        <input type="text" id="longitude" name="longitude" class="input-xxlarge">
                    </div>
                </div>
            </div>

            <div class="tab-pane fade" id="logo">
                <div class="control-group">
                    <label class="control-label" for="logo">
                        <fmt:message key="empresa.url.logo"/>
                    </label>
                    <div class="controls">
                        <input type="text" id="logo" name="logo" class="input-xxlarge">
                    </div>
                </div>
            </div>

            <div class="tab-pane fade" id="autenticacao">
                <div class="control-group">
                    <div class="control-group">
                        <label class="control-label" for="email">
                            <fmt:message key="empresa.email"/>
                        </label>
                        <div class="controls">
                            <input type="text" id="email" name="email" placeholder="empresa@dominio.com.br" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="senha">
                            <fmt:message key="empresa.password"/>
                        </label>
                        <div class="controls">
                            <input type="text" id="senha" name="senha" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="senhaRepetir">
                            <fmt:message key="empresa.password.repetir"/>
                        </label>
                        <div class="controls">
                            <input type="text" id="senhaRepetir" name="senhaRepetir" class="input-xlarge">
                        </div>
                    </div>
                </div>
            </div>

            <div class="control-group">
                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-success">
                        <fmt:message key="app.gravar" />
                    </button>
                    <button class="btn">
                        <fmt:message key="app.cancelar" />
                    </button>
                    <c:choose>
                        <c:when test="${entity.id != null}">
                            <button class="btn btn-danger">
                                <fmt:message key="app.excluir" />
                            </button> 
                        </c:when>
                    </c:choose>
                </div>
            </div>


        </form>
    </fieldset>
</body>
