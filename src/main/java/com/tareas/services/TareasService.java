/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.services;

import com.db.DB;
import com.tareas.exceptions.DBException;
import com.tareas.model.Tarea;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sara
 */
public class TareasService {
    
    /**
     * Obtiene las tareas del usuario indicado en el email y devuelve las que corresponden al estado indicado.
     * @param estado
     * @param email
     * @return listaTareasUsuarioEstado
     */
    public static Collection<Tarea> getListaTareasPorEstado(String estado, String email){
                
        Collection<Tarea> listaTareasUsuario = DB.getListaTareasPorUsuario().get(email);
        
        Set<Tarea> listaTareasUsuarioEstado = new HashSet<Tarea>();
        for(Tarea t: listaTareasUsuario){
            if(t.getEstado().equals(estado)){
                listaTareasUsuarioEstado.add(t);
            }
        }
        
        return listaTareasUsuarioEstado;
    
    }
    
    /**
     * Obtiene las tareas del usuario indicado en el email, busca la tarea con idTarea y sustituye el estado por nuevoEstado.
     * @param idTarea
     * @param nuevoEstado
     * @param email 
     */
    public static void modificarEstadoTarea(int idTarea, String nuevoEstado, String email){
        
        Collection<Tarea> listaTareasUsuario = DB.getListaTareasPorUsuario().get(email);
        
        Tarea tarea = null;
        for(Tarea t: listaTareasUsuario){
            if(t.getIdTarea() == idTarea){
                tarea=t;
                break;
            }
        }
        
        tarea.setEstado(nuevoEstado);
        
    }
    
    /**
     * Obtiene las tareas del usuario indicado en el email y la añade. Si ya estaba no se añade y lanza excepcion. Si no estaba se añade y se incrementa el numero de tareas.
     * @param tarea
     * @param email
     * @throws DBException 
     */
    public static void darAltaTarea(Tarea tarea, String email) throws DBException{
        
        Collection<Tarea> listaTareasUsuario = DB.getListaTareasPorUsuario().get(email);

        boolean added = listaTareasUsuario.add(tarea);
        if(!added){
            throw new DBException("La tarea ya existe.");
        }else{
            DB.incrementarNumeroTareas();
        }
        
    }
    
}
