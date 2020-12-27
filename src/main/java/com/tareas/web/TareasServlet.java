/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.model.Estado;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import com.tareas.services.TareasService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class TareasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession sesion = req.getSession();
        //COMPROBAR QUE EL USUARIO NO ES NULL
        Usuario usr = (Usuario)sesion.getAttribute("usuario");
        Collection<Tarea> listaTodo = TareasService.getListaTareasPorEstado(Estado.TODO.getValor(), usr.getEmail());
        Collection<Tarea> listaInprogress = TareasService.getListaTareasPorEstado(Estado.INPROGRESS.getValor(), usr.getEmail());
        Collection<Tarea> listaDone = TareasService.getListaTareasPorEstado(Estado.DONE.getValor(), usr.getEmail());
        req.setAttribute("listaTodo", listaTodo);
        req.setAttribute("listaInprogress", listaInprogress);
        req.setAttribute("listaDone", listaDone);
        RequestDispatcher rd = req.getRequestDispatcher("lista-tareas.jsp");
        rd.forward(req, resp);
        
        
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
    
    

//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet TareasServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet TareasServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

}
