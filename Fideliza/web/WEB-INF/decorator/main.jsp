<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <link type="image/x-icon" rel="shortcut icon" href="/Fideliza/resources/img/favicon.png"/>

        <meta name="description" content="Projeto Fideliza" />
        <meta name="author" content="Jeferson Oliveira Cruz"/>
        <meta name="keywords" content="vraptor,fideliza,projeto,fidelidade"/>

        <link type="text/css" rel="stylesheet" href="/Fideliza/resources/css/stylesheet.css"/>

        <script type="text/javascript" charset="utf-8" src="/Fideliza/resources/js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" charset="utf-8" src="/Fideliza/resources/js/bootstrap.js"></script>
        <script type="text/javascript" charset="utf-8" src="/Fideliza/resources/js/jquery.colorbox-1.3.16.min.js"></script>

        <script type="text/javascript" charset="utf-8" src="/Fideliza/resources/js/javascript.js"></script>

        <title><decorator:title default="Main | Projeto Fideliza"/></title>
    </head>

    <body>
        <div id="mensagem"></div>
        <div id="wrapper">

            <div class="header">
                <div class="container">
                    <div id="topo">
                        <%@ include file="/header.jsp" %>
                    </div>
                </div>
            </div>

            <div class="navbar">
                <div class="navbar-inner">   
                    <div class="container">
                        <%@ include file="/menu.jsp" %>
                    </div>
                </div>
            </div>

            <div id="content">
                <div class="container">
                    <c:if test="${not empty errors}">
                        <div id="errors" class="error">
                            <c:forEach var="error" items="${errors}">
                                ${error.category} - ${error.message}<br/>
                            </c:forEach>
                        </div>
                    </c:if>

                    <c:if test="${not empty error}">
                        <div id="error" class="error">${error}</div>
                    </c:if>

                    <c:if test="${not empty message}">
                        <div id="notice" class="notice">${message}</div>
                    </c:if>

                    <decorator:body/>
                </div>
            </div>

            <div id="rodape">
                <div class="container">
                    <%@ include file="/footer.jsp" %>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            function dummy() {
                alert('Dummy function! =~');
            }
            ;

            $.ajaxSetup({
                type: 'get',
                dataType: 'json',
                scriptCharset: 'utf-8',
                error: function(xhr, status, error) {
                    mensagem('<fmt:message key="erro"/>', getError(xhr));
                }
            });

            $(function() {
                console.log('Ready! (:');
            });
        </script>
    </body>
</html>
