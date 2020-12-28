/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.exceptions.LoginException;
import com.tareas.services.LoginService;
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
public class LoginServlet extends HttpServlet {
    

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
        
        
        String msgErrorLogin = null;
        if(valido){//Si los parámetros son correctos obtengo la sesión y hago el login. Si hay error se recoge la excepción.
            try{
                HttpSession sesion = req.getSession();
                LoginService ls = new LoginService();
                ls.login(email,password,sesion);
            }catch (LoginException ex) {
                msgErrorLogin = ex.getMessage();
                valido = false;
            }
        }
        
        String jspAmostrar = "";
        if (valido){//Si los parámetros y el login son oorrectos se muestran las tareas.
            //jspAmostrar = "lista-tareas.jsp";
            resp.sendRedirect("tareas");
        }else{//Si los parámetros y el login no son correctos se muestran los errores correspondientes.
            jspAmostrar = "form-login.jsp";
            req.setAttribute("msgErrorEmail", msgErrorEmail);
            req.setAttribute("msgErrorPassword", msgErrorPassword);
            req.setAttribute("msgErrorLogin", msgErrorLogin);
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
//            out.println("<title>Servlet LoginServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
