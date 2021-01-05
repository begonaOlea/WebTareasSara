/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.services;

import com.db.DB;
import com.tareas.exceptions.UsuariosException;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import java.util.HashSet;

/**
 *
 * @author Sara
 */
public class UsuariosService {
    
    /**
     * Añade el usuario. Si ya estaba no se añade y lanza excepcion. Si no estaba se añade y se crea una lista de tareas vacia para este usuario.
     * @param usuario
     * @throws UsuariosException 
     */
    public static synchronized void darAltaUsuario(Usuario usuario) throws UsuariosException{
        
        boolean added = DB.getUsuarios().add(usuario);
        if(!added){
            throw new UsuariosException("El usuario ya existe.");
        }else{
            DB.getTareasPorUsuario().put(usuario.getEmail(), new HashSet<Tarea>());
        }
        
    }
    
}
