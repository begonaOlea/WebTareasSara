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
import java.util.Set;

/**
 *
 * @author user
 */
public class DB {
    
    
    //private static Map<String,Map<String,Set<Tarea>>> lista;
        
    private static Map<String,List<Tarea>> lista;

        
    static{
        
        Usuario u1 = new Usuario("usuario1@email.com","111111","Nombre1","Apellido1");
        Usuario u2 = new Usuario("usuario2@email.com","222222","Nombre2","Apellido2");
        Usuario u3 = new Usuario("usuario3@email.com","333333","Nombre3","Apellido3");
        Usuario u4 = new Usuario("usuario4@email.com","444444","Nombre4","Apellido4");

        
        Tarea t1 = new Tarea(1,"Tarea 1",Estado.TODO.getValor());
        Tarea t2 = new Tarea(2,"Tarea 2",Estado.TODO.getValor());
        Tarea t3 = new Tarea(3,"Tarea 3",Estado.INPROGRESS.getValor());
        Tarea t4 = new Tarea(4,"Tarea 4",Estado.INPROGRESS.getValor());
        Tarea t5 = new Tarea(5,"Tarea 5",Estado.DONE.getValor());
        Tarea t6 = new Tarea(6,"Tarea 6",Estado.DONE.getValor());
        
        
        List<Tarea> lt1 = new ArrayList<Tarea>();
        lt1.add(t1);
        lt1.add(t3);
        lt1.add(t5);

        List<Tarea> lt2 = new ArrayList<Tarea>();
        lt2.add(t1);
        lt2.add(t2);
        lt2.add(t4);
        lt2.add(t5);
        lt2.add(t6);

        List<Tarea> lt3 = new ArrayList<Tarea>();
        lt3.add(t1);
        lt3.add(t3);
        lt3.add(t4);
        lt3.add(t5);
        
        List<Tarea> lt4 = new ArrayList<Tarea>();
        lt4.add(t1);
        lt4.add(t2);
        lt4.add(t3);
        lt4.add(t4);
        lt4.add(t5);
        lt4.add(t6);
        
 
    }
    
    
    private DB(){
    }
    
    
    
//        
//    
//    public static Collection<Tarea> getTareasTodo(){
//        
//        List<Tarea> tareasTodo = new ArrayList<Tarea>();
//        
//        Collection<Tarea> listaTareas = tareas.values();
//        for(Tarea t: listaTareas){
//            if(t.getEstado().equals(Estado.TODO.getValor())){
//                tareasTodo.add(t);
//            }
//        }
//        
//        return tareasTodo;
//        
//    }
//    
//    public static Collection<Tarea> getTareasInprogress(){
//        
//        List<Tarea> tareasTodo = new ArrayList<Tarea>();
//        
//        Collection<Tarea> listaTareas = tareas.values();
//        for(Tarea t: listaTareas){
//            if(t.getEstado().equals(Estado.INPROGRESS.getValor())){
//                tareasTodo.add(t);
//            }
//        }
//        
//        return tareasTodo;
//        
//    }
//    
//    public static Collection<Tarea> getTareasDone(){
//        
//        List<Tarea> tareasTodo = new ArrayList<Tarea>();
//        
//        Collection<Tarea> listaTareas = tareas.values();
//        for(Tarea t: listaTareas){
//            if(t.getEstado().equals(Estado.DONE.getValor())){
//                tareasTodo.add(t);
//            }
//        }
//        
//        return tareasTodo;
//        
//    }
//    
    
}
