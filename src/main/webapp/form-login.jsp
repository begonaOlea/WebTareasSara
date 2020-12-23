<%-- 
    Document   : form-login
    Created on : 23-dic-2020, 10:48:07
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@include file="WEB-INF/vista/bootstrap.html" %>
    </head>
    <body>
        
        <div class="container-fluid">

            <%@include file="WEB-INF/vista/cabecera.jspf" %>

            <div class="row">
                <div class="col">
                    <h1>Login</h1>
                </div>
            </div>
            
                        
            <c:if test="${not empty requestScope.msgErrorLogin}" >
                <div class="alert alert-warning">
                    <strong>Mensaje!</strong> ${requestScope.msgErrorLogin}
                </div>
            </c:if>
            
            
            <form action="login" method="POST">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Email</span>
                    </div>
                    <input type="email" class="form-control" name="email" placeholder="Introduce email">
                    <div class="text-warning">
                        ${requestScope.msgErrorEmail}
                    </div>   
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                    <span class="input-group-text">Password</span>
                    </div>
                    <input type="password" class="form-control" name="password" placeholder="Introduce password">
                    <div class="text-warning">
                        ${requestScope.msgErrorPassword}
                    </div>   
                </div>
                <div class="btn-group btn-block" role="group">
                    <a href="form-alta-usuario.jsp" class="btn btn-warning" role="button">Registrar</a>
                    <button type="submit" class="btn btn-warning">Login</button>
                </div>
            </form>

        </div>

    </body>
</html>
