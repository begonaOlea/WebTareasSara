/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public class DB {
    
    
    private static Map<Integer,Tarea> tareas;
    
    static{
        tareas = new HashMap<Integer,Tarea>();
        tareas.put(1, new Tarea(1,"Tarea 1",Estado.TODO.getValor()));
        tareas.put(2, new Tarea(2,"Tarea 2",Estado.TODO.getValor()));
        tareas.put(3, new Tarea(3,"Tarea 3",Estado.INPROGRESS.getValor()));
        tareas.put(4, new Tarea(4,"Tarea 4",Estado.DONE.getValor()));
 
    }
    
    
    private DB(){
    }
        
    
    private static Collection<Tarea> getTareasTodo(){
        
        List<Tarea> tareasTodo = new ArrayList<Tarea>();
        
        Collection<Tarea> listaTareas = tareas.values();
        for(Tarea t: listaTareas){
            if(t.getEstado().equals(Estado.TODO.getValor())){
                tareasTodo.add(t);
            }
        }
        
        return tareasTodo;
        
    }
    
    private static Collection<Tarea> getTareasInprogress(){
        
        List<Tarea> tareasTodo = new ArrayList<Tarea>();
        
        Collection<Tarea> listaTareas = tareas.values();
        for(Tarea t: listaTareas){
            if(t.getEstado().equals(Estado.INPROGRESS.getValor())){
                tareasTodo.add(t);
            }
        }
        
        return tareasTodo;
        
    }
    
    private static Collection<Tarea> getTareasDone(){
        
        List<Tarea> tareasTodo = new ArrayList<Tarea>();
        
        Collection<Tarea> listaTareas = tareas.values();
        for(Tarea t: listaTareas){
            if(t.getEstado().equals(Estado.DONE.getValor())){
                tareasTodo.add(t);
            }
        }
        
        return tareasTodo;
        
    }
    
    
}
