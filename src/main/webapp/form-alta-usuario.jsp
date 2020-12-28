<%-- 
    Document   : form-alta-libro
    Created on : 18-dic-2020, 9:31:23
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/vista/bootstrap.html" %>
        <%@include file="WEB-INF/vista/estilo.jspf" %>

        <title>Alta usuario</title>
    </head>
    <body>

        <div class="container-fluid" id="fondo">
            
            <%@include file="WEB-INF/vista/cabecera.jspf" %>

            <h3>Alta usuario</h3>
            
            
            <c:if test="${not empty requestScope.msgErrorAlta}" >
                <div class="alert alert-danger">
                    <strong>Mensaje!</strong> ${requestScope.msgErrorAlta}
                </div>
            </c:if>                
                
            
            <form action="alta-usuario" method="POST">
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
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Nombre</span>
                    </div>
                    <input type="text" class="form-control" name="nombre" placeholder="Introduce nombre">
                    <div class="text-danger">
                        ${requestScope.msgErrorNombre}
                    </div>   
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Apellido</span>
                    </div>
                    <input type="text" class="form-control" name="apellido" placeholder="Introduce apellido">
                    <div class="text-danger">
                        ${requestScope.msgErrorApellido}
                    </div>   
                </div>
                
                <input type="submit" class="btn btn-info btn-block" value="Guardar">
            </form>            

            <%@include file="WEB-INF/vista/pie.jspf" %>   

        </div>

    </body>
</html>
