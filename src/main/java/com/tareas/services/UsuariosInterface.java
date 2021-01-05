/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.services;

import com.tareas.exceptions.UsuariosException;
import com.tareas.model.Usuario;

/**
 *
 * @author Sara
 */
public interface UsuariosInterface {
    
    public void darAltaUsuario(Usuario usuario) throws UsuariosException;

}
