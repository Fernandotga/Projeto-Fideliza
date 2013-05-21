<!DOCTYPE html>
<html>
    <head>
        <title><fmt:message key="app.title"/></title>
    </head>
    <body>
        <form class="form-horizontal" action='' method="POST">
            <fieldset>
                <div id="legend">
                    <legend class=""> 
                        <fmt:message key="empresa.empresa"/> 
                        <small> <fmt:message key="login.login"/> </small>
                    </legend>  
                </div>  

                <div class="control-group">
                    <!-- E-Mail -->
                    <label class="control-label"  for="email">
                        <fmt:message key="login.email"/>
                    </label>
                    <div class="controls">
                        <input type="text" id="email" name="email" placeholder="empresa@dominio.com.br" class="input-xlarge">
                    </div>
                </div>

                <div class="control-group">
                    <!-- Senha -->
                    <label class="control-label" for="password">
                        <fmt:message key="login.senha" />
                    </label>
                    <div class="controls">
                        <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
                    </div>
                </div>

                <div class="control-group">
                    <!-- Button -->
                    <div class="controls">
                        <button class="btn btn-success">
                            <fmt:message key="login.autenticar" />
                        </button>
                    </div>
                </div>
            </fieldset>
        </form>                
    </body>
</html>