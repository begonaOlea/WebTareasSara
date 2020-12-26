/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.services;

import com.db.DB;
import com.tareas.exceptions.DBException;
import com.tareas.model.Estado;
import com.tareas.model.Tarea;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author user
 */
public class TareasService {
    
    public static List<Tarea> getListaTareasPorEstado(String estado, String email){
                
        List<Tarea> listaTareasUsuario = DB.getListaTareasPorUsuario().get(email);
        
        List<Tarea> listaTareasUsuarioEstado = new ArrayList<Tarea>();
        for(Tarea t: listaTareasUsuario){
            if(t.getEstado().equals(estado)){
                listaTareasUsuarioEstado.add(t);
            }
        }
        
        return listaTareasUsuarioEstado;
    
    }
    
    public static void modificarEstadoTarea(int idTarea, String nuevoEstado, String email){
        
        List<Tarea> listaTareasUsuario = DB.getListaTareasPorUsuario().get(email);
        
        Tarea tarea = null;
        for(Tarea t: listaTareasUsuario){
            if(t.getIdTarea() == idTarea){
                tarea=t;
                break;
            }
        }
        tarea.setEstado(nuevoEstado);
        
    }
    
    public static void darAltaTarea(Tarea tarea, String email) throws DBException{
        
        List<Tarea> listaTareasUsuario = DB.getListaTareasPorUsuario().get(email);

        boolean existe = listaTareasUsuario.add(tarea);
        if(!existe){
            throw new DBException("La tarea ya existe.");
        }else{
            DB.incrementarTarea();
        }
        
    }
    
}
