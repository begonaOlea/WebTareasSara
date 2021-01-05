/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.services;

import com.tareas.exceptions.TareasException;
import com.tareas.model.Tarea;
import java.util.Collection;

/**
 *
 * @author Sara
 */
public interface TareasInterface {
        
    public Collection<Tarea> getTareasPorEstado(String estado, String email);
    
    public void modificarEstadoTarea(int idTarea, String nuevoEstado, String email) throws TareasException;
    
    public void darAltaTarea(String descripcion, String email) throws TareasException;

}
