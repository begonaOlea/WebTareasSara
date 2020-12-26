/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.services;

import com.db.DB;
import com.tareas.exceptions.DBException;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class UsuariosService {
    
    public static void darAltaUsuario(Usuario usuario) throws DBException{
        boolean added = DB.getListaUsuarios().add(usuario);
        if(!added){
            throw new DBException("El usuario ya existe.");
        }else{
            DB.getListaTareasPorUsuario().put(usuario.getEmail(), new ArrayList<Tarea>());
        }
    }
    
}
