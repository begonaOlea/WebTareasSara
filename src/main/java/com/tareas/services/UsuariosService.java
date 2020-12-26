/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.services;

import com.db.DB;
import com.tareas.exceptions.DBException;
import com.tareas.model.Usuario;

/**
 *
 * @author user
 */
public class UsuariosService {
    
    public static synchronized void altaUsuario(Usuario usuario) throws DBException{
        boolean existe = DB.getListaUsuarios().add(usuario);
        if(!existe){
            throw new DBException("El usuario ya existe.");
        }
    }
    
}
