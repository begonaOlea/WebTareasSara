/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.db;

import com.tareas.exceptions.DBException;
import com.tareas.model.Estado;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import com.tareas.services.TareasService;
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
    
    private static List<Usuario> listaUsuarios;
    private static Map<String,List<Tarea>> listaTareasPorUsuario;
    //private static int ultimaTarea = 0;
    
        
    static{
        
        listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.add(new Usuario("usuario1@email.com","111111","Nombre1","Apellido1"));
        listaUsuarios.add(new Usuario("usuario2@email.com","222222","Nombre2","Apellido2"));
        listaUsuarios.add(new Usuario("usuario3@email.com","333333","Nombre3","Apellido3"));
        listaUsuarios.add( new Usuario("usuario4@email.com","444444","Nombre4","Apellido4"));

        
        List<Tarea> lt1 = new ArrayList<Tarea>();
        lt1.add(new Tarea(1,"Tarea A",Estado.TODO.getValor()));
        lt1.add(new Tarea(2,"Tarea B",Estado.INPROGRESS.getValor()));
        lt1.add(new Tarea(3,"Tarea C",Estado.DONE.getValor()));

        List<Tarea> lt2 = new ArrayList<Tarea>();
        lt2.add(new Tarea(4,"Tarea D",Estado.TODO.getValor()));
        lt2.add(new Tarea(5,"Tarea E",Estado.TODO.getValor()));
        lt2.add(new Tarea(6,"Tarea F",Estado.INPROGRESS.getValor()));
        lt2.add(new Tarea(7,"Tarea G",Estado.DONE.getValor()));
        lt2.add(new Tarea(8,"Tarea H",Estado.DONE.getValor()));

        List<Tarea> lt3 = new ArrayList<Tarea>();
        lt3.add(new Tarea(9,"Tarea I",Estado.TODO.getValor()));
        lt3.add(new Tarea(10,"Tarea J",Estado.INPROGRESS.getValor()));
        lt3.add(new Tarea(11,"Tarea K",Estado.INPROGRESS.getValor()));
        lt3.add(new Tarea(12,"Tarea L",Estado.DONE.getValor()));
        
        List<Tarea> lt4 = new ArrayList<Tarea>();
        lt4.add(new Tarea(13,"Tarea M",Estado.TODO.getValor()));
        lt4.add(new Tarea(14,"Tarea N",Estado.TODO.getValor()));
        lt4.add(new Tarea(15,"Tarea O",Estado.INPROGRESS.getValor()));
        lt4.add(new Tarea(16,"Tarea P",Estado.INPROGRESS.getValor()));
        lt4.add(new Tarea(17,"Tarea Q",Estado.DONE.getValor()));
        lt4.add(new Tarea(18,"Tarea R",Estado.DONE.getValor()));
        
        
        listaTareasPorUsuario = new HashMap<String,List<Tarea>>();
        listaTareasPorUsuario.put("usuario1@email.com", lt1);
        listaTareasPorUsuario.put("usuario2@email.com", lt2);
        listaTareasPorUsuario.put("usuario3@email.com", lt3);
        listaTareasPorUsuario.put("usuario4@email.com", lt4);
        
    }
    
    
    private DB(){
    }
    
    
    public static Map<String,List<Tarea>> getListaTareasPorUsuario(){
        return listaTareasPorUsuario;
    }
    
    public static Collection<Usuario> getListaUsuarios(){
        return listaUsuarios;
    }

    
    
    
    
    //PRUEBAS
    public static void main(String[] args) {
        
        TareasService ts = new TareasService();
        
        System.out.println(ts.getListaTareasPorEstado(Estado.TODO.getValor(), "usuario4@email.com"));
        System.out.println(ts.getListaTareasPorEstado(Estado.INPROGRESS.getValor(), "usuario4@email.com"));
        System.out.println(ts.getListaTareasPorEstado(Estado.DONE.getValor(), "usuario4@email.com"));

        System.out.println("-------------------------------");
        
        ts.modificarEstadoTarea(1, Estado.INPROGRESS.getValor(), "usuario4@email.com");
        System.out.println(listaTareasPorUsuario.get("usuario4@email.com"));
        System.out.println(listaTareasPorUsuario.get("usuario1@email.com"));

        System.out.println("-------------------------------");

        System.out.println(ts.getListaTareasPorEstado(Estado.TODO.getValor(), "usuario4@email.com"));
        System.out.println(ts.getListaTareasPorEstado(Estado.INPROGRESS.getValor(), "usuario4@email.com"));
        System.out.println(ts.getListaTareasPorEstado(Estado.DONE.getValor(), "usuario4@email.com"));
        
        System.out.println("-------------------------------");

        try {
            ts.darAltaTarea(new Tarea("TareaS",Estado.TODO.getValor()), "usuario4@email.com");
        } catch (DBException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("-------------------------------");

        System.out.println(ts.getListaTareasPorEstado(Estado.TODO.getValor(), "usuario4@email.com"));
        System.out.println(ts.getListaTareasPorEstado(Estado.INPROGRESS.getValor(), "usuario4@email.com"));
        System.out.println(ts.getListaTareasPorEstado(Estado.DONE.getValor(), "usuario4@email.com"));
        
    }
    
}
