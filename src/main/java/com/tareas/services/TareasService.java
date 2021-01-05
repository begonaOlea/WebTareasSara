/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.services;

import com.db.DB;
import com.tareas.exceptions.TareasException;
import com.tareas.model.Estado;
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
     * Obtiene todas las tareas del usuario indicado en el email y devuelve las que corresponden al estado indicado.
     * @param estado
     * @param email
     * @return tareasUsuarioEstado
     */
    public static synchronized Collection<Tarea> getTareasPorEstado(String estado, String email){
                
        Collection<Tarea> tareasUsuario = DB.getTareasPorUsuario().get(email);
        
        Set<Tarea> tareasUsuarioEstado = new HashSet<Tarea>();
        for(Tarea t: tareasUsuario){
            if(t.getEstado().equals(estado)){
                tareasUsuarioEstado.add(t);
            }
        }
        
        return tareasUsuarioEstado;
    
    }
    
    /**
     * Obtiene todas las tareas del usuario indicado en el email, busca la tarea con idTarea y sustituye el estado por nuevoEstado. Si no encuentra la tarea con ese id no la modifica y lanza excepción.
     * @param idTarea
     * @param nuevoEstado
     * @param email 
     */
    public static synchronized void modificarEstadoTarea(int idTarea, String nuevoEstado, String email) throws TareasException{
        
        Collection<Tarea> tareasUsuario = DB.getTareasPorUsuario().get(email);
        
        Tarea tarea = null;
        for(Tarea t: tareasUsuario){
            if(t.getIdTarea() == idTarea){
                tarea=t;
                break;
            }
        }
        
        if (tarea == null){
            throw new TareasException("La tarea con id " + idTarea + " no existe.");
        }else{
            tarea.setEstado(nuevoEstado);
        }
        
    }
    
    /**
     * Obtiene las tareas del usuario indicado en el email y la añade.Si ya estaba no se añade y lanza excepcion. Si no estaba se añade y se incrementa el numero de tareas.
     * @param descripcion
     * @param email
     * @throws TareasException 
     */
    public static synchronized void darAltaTarea(String descripcion, String email) throws TareasException{
        
        Collection<Tarea> tareasUsuario = DB.getTareasPorUsuario().get(email);

        Tarea tarea = DB.crearTarea(descripcion, Estado.TODO.getValor());
        
        boolean added = tareasUsuario.add(tarea);
        if(!added){
            throw new TareasException("La tarea ya existe.");
        }else{
            DB.incrementarNumeroTareas();
        }
        
    }
    
}
