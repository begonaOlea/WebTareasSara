/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author begonaolea
 */
@WebServlet(name = "BegonaServlet", urlPatterns = {"/lista-tareas"})
public class BegonaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
//          HttpSession s = req.getSession();
//          Usuario usr ;
//          if(s.getAttribute("usuario") == null ){
//              resp.sendRedirect("form-login.jsp");
//          }else{
//              
//              usr  = (Usuario)s.getAttribute("usuario");
//          }
//    
//          List<Tarea> listTodo = db.getListTareaPorUsuairoEstao(usr.getEmail, EStado);
//          
//          req.setAttribute("listaTodo", listTodo);
//          
//          -- hacer request dispacher
    
    }

    
}
