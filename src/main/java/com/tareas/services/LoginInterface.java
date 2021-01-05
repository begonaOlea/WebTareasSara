/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.services;

import com.tareas.exceptions.LoginException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sara
 */
public interface LoginInterface {
    
    public void login(String email, String password, HttpSession sesion) throws LoginException;

}
