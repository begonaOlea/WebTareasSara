/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.db.DB;
import com.tareas.exceptions.DBException;
import com.tareas.model.Estado;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import com.tareas.services.TareasService;
import com.tareas.services.UsuariosService;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AltaTareaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean valido = true;
        
        String msgErrorDescripcion = null;
        //Leer el parámetro descripcion.
        String descripcion = req.getParameter("descripcion");
        //Validar el parámetro descripcion.
        if(descripcion == null || descripcion.trim().length() == 0){
            msgErrorDescripcion = "Debe indicar la descripción de la tarea.";
            valido = false;
        }
        
        
        String msgErrorAlta = null;
        if(valido){// Si los parámetros son correctos creo la tarea y la añado al usuario de la sesion. Si hay error se recoge la excepción. 
            try{
                HttpSession sesion = req.getSession();
                if(sesion.getAttribute("usuario") == null){
                    msgErrorAlta = "El usuario no está en la sesión.";
                    valido = false;
                }else{
                    Usuario usuario = (Usuario)sesion.getAttribute("usuario");
                    TareasService ts = new TareasService();
                    ts.darAltaTarea(descripcion, usuario.getEmail());
                }
            }catch (DBException ex) {
                msgErrorAlta = ex.getMessage();
                valido = false;
            }
        }
        
                
        String jspAmostrar = "";//Si los parámetros y el alta son oorrectos se muestran las tareas.
        if (valido){
            //jspAmostrar = "lista-tareas.jsp";
            resp.sendRedirect("tareas");
        }else{//Si los parámetros y el alta no son correctos se muestran los errores correspondientes.
            jspAmostrar = "form-alta-tarea.jsp";
            req.setAttribute("msgErrorDescripcion", msgErrorDescripcion);
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
//            out.println("<title>Servlet AltaTareaServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AltaTareaServlet at " + request.getContextPath() + "</h1>");
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
