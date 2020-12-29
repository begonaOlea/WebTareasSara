/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.services;

import com.db.DB;
import com.tareas.exceptions.LoginException;
import com.tareas.model.Usuario;
import java.util.Collection;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sara
 */
public class LoginService {
    
    /**
     * Comprueba si existe el usuario con el email y password indicado para añadirlo a la sesion.
     * @param email
     * @param password
     * @param sesion
     * @throws LoginException 
     */
    public void login(String email, String password, HttpSession sesion) throws LoginException{
    
        //Comprobar si el usuario existe, si hay otro usuario con el mismo email.
        Collection<Usuario> usuarios = DB.getUsuarios();
        Usuario usuarioEncontrado = null;
        for(Usuario u: usuarios){
            if(u.getEmail().equals(email)){
                usuarioEncontrado = u;
                break;
            }
        }
        
        if(usuarioEncontrado == null){//Si el usuario no existe se lanza excepción.
            throw new LoginException("El usuario no existe. Debe registrarse.");
        }else{//Si el usuario existe...
            if(usuarioEncontrado.getPassword().equals(password)){//Si tiene la misma contraseña se añade el usuario a la sesión.
                sesion.setAttribute("usuario", usuarioEncontrado);
            }else{//Si no tiene la misma contraseña se lanza excepción.
                throw new LoginException("Password no valida.");
            }
        }
        
    }
    
    /**
     * Invalida la sesión.
     * @param sesion 
     */
    public void logout(HttpSession sesion){
        sesion.invalidate();
    }
    
}
