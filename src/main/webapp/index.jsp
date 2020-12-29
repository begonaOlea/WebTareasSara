<%-- 
    Document   : index
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

        <title>Tareas</title>
    </head>
    <body>
        
        <div class="container-fluid" id="fondo">
            
            <%@include file="WEB-INF/vista/cabecera.jspf" %>  

            
            <div class="row form-group align-items-center">
                <div class="col text-center">
                    <img src="resources/fondoTarea.jpg" class="img-thumbnail" alt="fondo">
                </div>            
            </div>            

            
            <%@include file="WEB-INF/vista/pie.jspf" %>   
            
        </div>
        
    </body>     
 
</html>
