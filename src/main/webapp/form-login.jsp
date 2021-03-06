<%-- 
    Document   : form-login
    Created on : 23-dic-2020, 10:30:00
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/vista/bootstrap.html" %>
        <%@include file="WEB-INF/vista/estilo.jspf" %>
                
        <title>Login</title>
    </head>
    <body>
        
        <div class="container-fluid" id="fondo">

            <%@include file="WEB-INF/vista/cabecera.jspf" %>

            <h3>Login</h3>
            
                        
            <c:if test="${not empty requestScope.msgErrorLogin}" >
                <div class="alert alert-danger">
                    <strong>Mensaje!</strong> ${requestScope.msgErrorLogin}
                </div>
            </c:if>
            
            
            <form action="login" method="POST">
                
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Email</span>
                    </div>
                    <input type="email" class="form-control" name="email" placeholder="Introduce email">
                    <div class="text-danger">
                        ${requestScope.msgErrorEmail}
                    </div>   
                </div>
                    
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                    <span class="input-group-text">Password</span>
                    </div>
                    <input type="password" class="form-control" name="password" placeholder="Introduce password">
                    <div class="text-danger">
                        ${requestScope.msgErrorPassword}
                    </div>   
                </div>
                    
                <div class="btn-group btn-block" role="group">
                    <a href="form-alta-usuario.jsp" class="btn btn-info" role="button">Registrar</a>
                    <button type="submit" class="btn btn-info">Login</button>
                </div>
                    
            </form>
                    
            <%@include file="WEB-INF/vista/pie.jspf" %>   

        </div>

    </body>
</html>
