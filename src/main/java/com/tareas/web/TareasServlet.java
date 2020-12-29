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
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sara
 */
public class TareasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Obtengo el usuario de la sesión.
        HttpSession sesion = req.getSession();
        
        String jspAmostrar = "";
        if(sesion.getAttribute("usuario") == null){
            //jspAmostrar = "form-login.jsp";
            //resp.sendRedirect("form-login.jsp");
            String msgErrorUsuario = "El usuario no ha iniciado sesión.";
            jspAmostrar = "lista-tareas.jsp";
            req.setAttribute("msgErrorUsuario", msgErrorUsuario);
        }else{
            jspAmostrar = "lista-tareas.jsp";
            Usuario usuario = (Usuario)sesion.getAttribute("usuario");
            Collection<Tarea> listaTodo = TareasService.getTareasPorEstado(Estado.TODO.getValor(), usuario.getEmail());
            Collection<Tarea> listaInprogress = TareasService.getTareasPorEstado(Estado.INPROGRESS.getValor(), usuario.getEmail());
            Collection<Tarea> listaDone = TareasService.getTareasPorEstado(Estado.DONE.getValor(), usuario.getEmail());
            req.setAttribute("listaTodo", listaTodo);
            req.setAttribute("listaInprogress", listaInprogress);
            req.setAttribute("listaDone", listaDone);
        }
                    
        RequestDispatcher rd = req.getRequestDispatcher(jspAmostrar);
        rd.forward(req, resp);
            
            
        /*
        String jspAmostrar = "";
        if(sesion.getAttribute("usuario") == null){
            //jspAmostrar = "form-login.jsp";
            resp.sendRedirect("form-login.jsp");
        }else{
            jspAmostrar = "lista-tareas.jsp";
            Usuario usuario = (Usuario)sesion.getAttribute("usuario");
            Collection<Tarea> listaTodo = TareasService.getTareasPorEstado(Estado.TODO.getValor(), usuario.getEmail());
            Collection<Tarea> listaInprogress = TareasService.getTareasPorEstado(Estado.INPROGRESS.getValor(), usuario.getEmail());
            Collection<Tarea> listaDone = TareasService.getTareasPorEstado(Estado.DONE.getValor(), usuario.getEmail());
            req.setAttribute("listaTodo", listaTodo);
            req.setAttribute("listaInprogress", listaInprogress);
            req.setAttribute("listaDone", listaDone);
            RequestDispatcher rd = req.getRequestDispatcher(jspAmostrar);
            rd.forward(req, resp);
        }
        */        
        
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
