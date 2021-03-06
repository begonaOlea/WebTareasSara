/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.exceptions.TareasException;
import com.tareas.model.Usuario;
import com.tareas.services.TareasService;
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
public class ModificarEstadoTareaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean valido = true;
        
        String msgErrorId = null;
        //Leer el parámetro id.
        String idS = req.getParameter("id");
        int id =0;
        //Validar el parámetro id.
        if(idS == null || idS.trim().length() == 0){
            msgErrorId = "Debe indicar el id de la tarea.";
            valido = false;
        }else{
            try{
                id = Integer.parseInt(idS);
            }catch(NumberFormatException e){
                msgErrorId = "Debe indicar un id de tarea con fomato número entero.";   
            }
        }
               
        String msgErrorEstado = null;
        //Leer el parámetro estado.
        String estado = req.getParameter("estado");
        //Validar el parámetro estado.
        if(estado == null || estado.trim().length() == 0){
            msgErrorEstado = "Debe indicar el nuevo estado de la tarea.";
            valido = false;
        }
      
        String msgErrorUsuario = null;
        String msgErrorModificar = null;
        if(valido){// Si los parámetros son correctos... Si hay error (la tarea no existe) se recoge la excepción. 
            try{
                HttpSession sesion = req.getSession();
                if(sesion.getAttribute("usuario") == null){//Si el usuario no ha iniciado la sesión se crea mensaje de error.
                    msgErrorUsuario = "El usuario no ha iniciado sesión.";
                    valido = false;
                }else{//Si el usuario ha iniciado sesión se modifica la tarea para ese usuario.
                    Usuario usuario = (Usuario)sesion.getAttribute("usuario");
                    TareasService ts = new TareasService();
                    ts.modificarEstadoTarea(id, estado, usuario.getEmail());
                }
            }catch (TareasException ex) {
                msgErrorModificar = ex.getMessage();
                valido = false;
            }
        }

        
        String jspAmostrar = "";//Si los parámetros y el alta son oorrectos se muestran las tareas.
        if (valido){
            //jspAmostrar = "lista-tareas.jsp";
            resp.sendRedirect("tareas");
        }else{//Si los parámetros y el alta no son correctos se muestran los errores correspondientes.
            //jspAmostrar = "lista-tareas.jsp";
            req.setAttribute("msgErrorId", msgErrorId);
            req.setAttribute("msgErrorEstado", msgErrorEstado);
            req.setAttribute("msgErrorUsuario", msgErrorUsuario);
            req.setAttribute("msgErrorModificar", msgErrorModificar);
            //RequestDispatcher rd = req.getRequestDispatcher(jspAmostrar);
            RequestDispatcher rd = req.getRequestDispatcher("tareas");
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
//            out.println("<title>Servlet ModificarEstadoTareaServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ModificarEstadoTareaServlet at " + request.getContextPath() + "</h1>");
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
