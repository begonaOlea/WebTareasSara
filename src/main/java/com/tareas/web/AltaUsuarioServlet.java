/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.exceptions.DBException;
import com.tareas.model.Usuario;
import com.tareas.services.UsuariosService;
import java.io.IOException;
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
public class AltaUsuarioServlet extends HttpServlet {
    
   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        boolean valido = true;
        
        String msgErrorEmail = null;
        //Leer el parámetro email.
        String email = req.getParameter("email");
        //Validar el parámetro email.
        if(email == null || email.trim().length() == 0){
            msgErrorEmail = "Debe indicar el email del usuario.";
            valido = false;
        }
        
        String msgErrorPassword = null;
        //Leer el parámetro password.
        String password = req.getParameter("password");
        //Validar el parámetro password.
        if(password == null || password.trim().length() == 0){
            msgErrorPassword = "Debe indicar el password del usuario.";
            valido = false;
        }
        
        String msgErrorNombre = null;
        //Leer el parámetro nombre.                
        String nombre = req.getParameter("nombre");
        //Validar el parámetro nombre.
        if(nombre == null || nombre.trim().length() == 0){
            msgErrorNombre = "Debe indicar el nombre del usuario.";
            valido = false;
        }
        
        String msgErrorApellido = null;
        //Leer el parámetro apellido.                
        String apellido = req.getParameter("apellido");
        //Validar el parámetro apellido.
        if(apellido == null || apellido.trim().length() == 0){
            msgErrorApellido = "Debe indicar el apellido del usuario.";
            valido = false;
        }
        
        
        String msgErrorAlta = null;
        if(valido){// Si los parámetros son correctos creo el usuario, le doy de alta y añado el usuario a la sesion. Si hay error (el usuario ya existe) se recoge la excepción. 
            Usuario usuario = new Usuario(email,password,nombre,apellido);
            try {
                UsuariosService us = new UsuariosService();
                us.darAltaUsuario(usuario);

                HttpSession session = req.getSession();
                session.setAttribute("usuario", usuario);
            } catch (DBException ex) {
                msgErrorAlta = ex.getMessage();
                valido = false;
            }
        }
        
        
        String jspAmostrar = "";//Si los parámetros y el alta son oorrectos se muestran las tareas.
        if (valido){
            //jspAmostrar = "lista-tareas.jsp";
            resp.sendRedirect("tareas");
        }else{//Si los parámetros y el alta no son correctos se muestran los errores correspondientes.
            jspAmostrar = "form-alta-usuario.jsp";
            req.setAttribute("msgErrorEmail", msgErrorEmail);
            req.setAttribute("msgErrorPassword", msgErrorPassword);
            req.setAttribute("msgErrorNombre", msgErrorNombre);
            req.setAttribute("msgErrorApellido", msgErrorApellido);
            req.setAttribute("msgErrorAlta", msgErrorAlta);
            RequestDispatcher rd = req.getRequestDispatcher(jspAmostrar);
            rd.forward(req, resp);
        }

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
//            out.println("<title>Servlet AltaUsuarioServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AltaUsuarioServlet at " + request.getContextPath() + "</h1>");
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
