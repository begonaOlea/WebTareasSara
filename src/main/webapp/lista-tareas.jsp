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
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        
            

            <div class="row">
                <div class="col">
                    <h4>TO DO</h4>
                    <table class="table">
                <thead>
                    <tr>
                    <th>descripcion</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <c:forEach var="t" items="${requestScope.listaTodo}">
                        <td>${t.descripcion}</td>
                    </c:forEach>
                    </tr>
                <tbody>
                    </table>
                </div>
                <div class="col">
                    <h4>IN PROGRESS</h4>
                    
                    <c:forEach var="t" items="${requestScope.listaInprogress}">
                        <h4>${t.descripcion}</h4>
                    </c:forEach>
                        
                </div>
                <div class="col">
                    <h4>DONE</h4>
                    
                    <c:forEach var="t" items="${requestScope.listaDone}">
                        <h4>${t.descripcion}</h4>
                    </c:forEach>
                        
                </div>
            </div>
        
            <a href="form-alta-tarea.jsp" class="btn btn-warning btn-block" role="button">Crear tarea</a>
            
        </div>
            
    </body>
</html>
