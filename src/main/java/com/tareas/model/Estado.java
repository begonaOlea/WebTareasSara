/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.model;

/**
 *
 * @author user
 */
public enum Estado {
    
    TODO("TO DO"), INPROGRESS("IN PROGRESS"), DONE("DONE");
    
    
    private String valor;

    private Estado(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
    
}
