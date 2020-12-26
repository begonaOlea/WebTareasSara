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
 * @author user
 */
public class LoginService {
    
    public void login(String email, String password, HttpSession sesion) throws LoginException{
    
        //DB ver si existe y coincide email y password
        Collection<Usuario> usuarios = DB.getListaUsuarios();
        Usuario usuarioEncontrado = null;
        for(Usuario u: usuarios){
            if(u.getEmail().equals(email)){
                usuarioEncontrado = u;
                break;
            }
        }
        
        if(usuarioEncontrado == null){//sino existe lanzo excepcion
            throw new LoginException("El usuario no existe. Debe registrarse.");
        }else{
            if(usuarioEncontrado.getPassword().equals(password)){//ver si clave ok
                //si existe añadir a sesion
                sesion.setAttribute("usuario", usuarioEncontrado);
            }else{
                throw new LoginException("Password no valida.");
            }
        }
    }
    
    public void logout(HttpSession sesion){
        sesion.invalidate();
    }
    
}
