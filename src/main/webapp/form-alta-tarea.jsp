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

        <title>Alta tarea</title>
    </head>
    <body>

        <div class="container-fluid">
            
            <%@include file="WEB-INF/vista/cabecera.jspf" %>

            <h2>Alta tarea</h2>
            
            
            
            <c:if test="${not empty requestScope.msgErrorAlta}" >
                <div class="alert alert-warning">
                    <strong>Mensaje!</strong> ${requestScope.msgErrorAlta}
                </div>
            </c:if>
                
                
            
            <form action="alta-tarea" method="POST">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Descripción</span>
                    </div>
                    <input type="text" class="form-control" name="descripcion" placeholder="Introduce descripción">
                    <div class="text-warning">
                        ${requestScope.msgErrorDescripcion}
                    </div>   
                </div>
                
                <input type="submit" class="btn btn-warning btn-block" value="Guardar">
            </form>            
                    
            <%@include file="WEB-INF/vista/pie.jspf" %>   

        </div>

    </body>
</html>
