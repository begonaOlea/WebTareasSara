<%-- 
    Document   : lista-tareas
    Created on : 23-dic-2020, 11:16:28
    Author     : user
--%>

<%@page import="com.tareas.model.Estado"%>
<%@page import="com.tareas.model.Tarea"%>
<%@page import="java.util.Collection"%>
<%@page import="com.tareas.services.TareasService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista tareas</title>
        <%@include file="WEB-INF/vista/bootstrap.html" %>
    </head>
    <body>

        <div class="container-fluid">

            <%@include file="WEB-INF/vista/cabecera.jspf" %>
            
            <%
                //Collection<Tarea> listaTareasTodo  = TareasService.getListaTareasPorEstado(Estado.TODO.getValor(), ${sessionScope.usuario.email});
            %>

            <div class="row">
                <div class="col">
                    <h4>TO DO</h4>
                </div>
                <div class="col">
                    <h4>IN PROGRESS</h4>
                </div>
                <div class="col">
                    <h4>DONE</h4>
                </div>
            </div>
        
            <a href="form-alta-tarea.jsp" class="btn btn-warning" role="button">Guardar</a>
            
        </div>
            
    </body>
</html>
