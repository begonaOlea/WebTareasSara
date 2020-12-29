<%-- 
    Document   : lista-tareas
    Created on : 23-dic-2020, 10:30:00
    Author     : Sara
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
        <%@include file="WEB-INF/vista/bootstrap.html" %>
        <%@include file="WEB-INF/vista/estilo.jspf" %>

        <title>Lista tareas</title>
    </head>
    <body>

        <div class="container-fluid" id="fondo">

            <%@include file="WEB-INF/vista/cabecera.jspf" %>
        
            <h3>Lista tareas</h3>
            
              
            <c:if test="${not empty requestScope.msgErrorUsuario}" >
                <div class="alert alert-danger">
                    <strong>Mensaje!</strong> ${requestScope.msgErrorUsuario}
                </div>
            </c:if>
            
            <c:if test="${not empty requestScope.msgErrorModificar}" >
                <div class="alert alert-danger">
                    <strong>Mensaje!</strong> ${requestScope.msgErrorModificar}
                </div>
            </c:if>  
            

            <div class="row">
                
                <div class="col">
                    
                    <h5 class="text-info">TO DO</h5>
                    
                    <table class="table">
                        <thead>
                            <tr>
                            <th>id</th>
                            <th>descripción</th>
                            <th>mover</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="t" items="${requestScope.listaTodo}">
                                <tr>
                                <td>${t.idTarea}</td>
                                <td>${t.descripcion}</td>
                                <td><a href="modificar-estado-tarea?id=${t.idTarea}&estado=<%= Estado.INPROGRESS.getValor()%>">InProgress</a></td>
                                </tr>
                            </c:forEach>
                        <tbody>
                    </table>
                    
                </div>
                
                <div class="col">
                    
                    <h5 class="text-info">IN PROGRESS</h5>
                    
                    <table class="table">
                        <thead>
                            <tr>
                            <th>id</th>
                            <th>descripción</th>
                            <th>mover</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="t" items="${requestScope.listaInprogress}">
                                <tr>
                                <td>${t.idTarea}</td>
                                <td>${t.descripcion}</td>
                                <td><a href="modificar-estado-tarea?id=${t.idTarea}&estado=<%= Estado.TODO.getValor()%>">ToDo</a> - <a href="modificar-estado-tarea?id=${t.idTarea}&estado=<%= Estado.DONE.getValor()%>">Done</a></td>
                                </tr>
                            </c:forEach>
                        <tbody>
                    </table>
                    
                </div>
                
                <div class="col">
                    
                    <h5 class="text-info">DONE</h5>
                    
                    <table class="table">
                        <thead>
                            <tr>
                            <th>id</th>
                            <th>descripción</th>
                            <th>mover</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="t" items="${requestScope.listaDone}">
                                <tr>
                                <td>${t.idTarea}</td>
                                <td>${t.descripcion}</td>
                                <td><a href="modificar-estado-tarea?id=${t.idTarea}&estado=<%= Estado.INPROGRESS.getValor()%>">InProgress</a></td>
                                </tr>
                            </c:forEach>
                        <tbody>
                    </table>
                    
                </div>  
                            
            </div>
            
                <div class="text-danger">
                    ${requestScope.msgErrorId}
                </div>  
                <div class="text-danger">
                    ${requestScope.msgErrorEstado}
                </div>
        
            <a href="form-alta-tarea.jsp" class="btn btn-info btn-block" role="button">Crear tarea</a>
            
            <%@include file="WEB-INF/vista/pie.jspf" %>   

        </div>
            
    </body>
</html>
