/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import com.tareas.exceptions.TareasException;
import com.tareas.exceptions.UsuariosException;
import com.tareas.model.Estado;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import com.tareas.services.TareasService;
import com.tareas.services.UsuariosService;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Sara
 */
public class DB {
    
    //ATRIBUTOS
    private static Set<Usuario> usuarios; // Uso Set<Usuario> y no List<Usuario> para que no haya duplicados.
    private static Map<String,Set<Tarea>> tareasPorUsuario; // Uso Set<Tarea> y no List<Tarea> para que no haya duplicados.
    private static int ultimaTarea = 0; // Parar ir incrementando el idTarea automáticamente.
    
        
    //BLOQUE ESTÁTICO
    static{
        
        usuarios = new HashSet<Usuario>();
        usuarios.add(new Usuario("usuario1@email.com","111111","Nombre1","Apellido1"));
        usuarios.add(new Usuario("usuario2@email.com","222222","Nombre2","Apellido2"));
        usuarios.add(new Usuario("usuario3@email.com","333333","Nombre3","Apellido3"));
        usuarios.add(new Usuario("usuario4@email.com","444444","Nombre4","Apellido4"));

        
        Set<Tarea> lt1 = new HashSet<Tarea>();
        lt1.add(new Tarea(1,"Tarea A",Estado.TODO.getValor()));
        lt1.add(new Tarea(2,"Tarea B",Estado.INPROGRESS.getValor()));
        lt1.add(new Tarea(3,"Tarea C",Estado.DONE.getValor()));

        Set<Tarea> lt2 = new HashSet<Tarea>();
        lt2.add(new Tarea(4,"Tarea D",Estado.TODO.getValor()));
        lt2.add(new Tarea(5,"Tarea E",Estado.TODO.getValor()));
        lt2.add(new Tarea(6,"Tarea F",Estado.INPROGRESS.getValor()));
        lt2.add(new Tarea(7,"Tarea G",Estado.DONE.getValor()));
        lt2.add(new Tarea(8,"Tarea H",Estado.DONE.getValor()));

        Set<Tarea> lt3 = new HashSet<Tarea>();
        lt3.add(new Tarea(9,"Tarea I",Estado.TODO.getValor()));
        lt3.add(new Tarea(10,"Tarea J",Estado.INPROGRESS.getValor()));
        lt3.add(new Tarea(11,"Tarea K",Estado.INPROGRESS.getValor()));
        lt3.add(new Tarea(12,"Tarea L",Estado.DONE.getValor()));
        
        Set<Tarea> lt4 = new HashSet<Tarea>();
        lt4.add(new Tarea(13,"Tarea M",Estado.TODO.getValor()));
        lt4.add(new Tarea(14,"Tarea N",Estado.TODO.getValor()));
        lt4.add(new Tarea(15,"Tarea O",Estado.INPROGRESS.getValor()));
        lt4.add(new Tarea(16,"Tarea P",Estado.INPROGRESS.getValor()));
        lt4.add(new Tarea(17,"Tarea Q",Estado.DONE.getValor()));
        lt4.add(new Tarea(18,"Tarea R",Estado.DONE.getValor()));
        
        
        tareasPorUsuario = new HashMap<String,Set<Tarea>>();
        tareasPorUsuario.put("usuario1@email.com", lt1);
        tareasPorUsuario.put("usuario2@email.com", lt2);
        tareasPorUsuario.put("usuario3@email.com", lt3);
        tareasPorUsuario.put("usuario4@email.com", lt4);
        
        
        ultimaTarea = 19;
        
    }
    
    
    //CONSTRUCTORA
    private DB(){
    }
    
    
    //MÉTODOS
    
    /**
     * Obtiene la lista de tareas agrupadas por usuario.
     * @return listaTareasPorUsuario
     */
    public static Map<String,Set<Tarea>> getTareasPorUsuario(){
        return tareasPorUsuario;
    }
    
    /**
     * Obtiene la lista de usuarios.
     * @return listaUsuarios
     */
    public static Collection<Usuario> getUsuarios(){
        return usuarios;
    }

    /**
     * Crea una tarea con el id de la última tarea.
     * @param descripcion
     * @param estado
     * @return tarea
     */
    public static Tarea crearTarea(String descripcion,String estado){
        Tarea tarea = new Tarea(ultimaTarea,descripcion,estado);
        return tarea;
    }
    
    /**
     * Incrementa el numero de tareas para usarlo como id.
     */
    public static void incrementarNumeroTareas(){
        ultimaTarea++;
    }
    
    
    
    /*
    PRUEBAS
    */
    public static void main(String[] args) {
        
        System.out.println("*** PRUEBA TAREAS ***");
        TareasService ts = new TareasService();
        
        System.out.println("-------------------------------");
        
        System.out.println("* PRUEBA getListaTareasPorEstado *");
        for(Usuario u: usuarios){
            System.out.println("USUARIO: " + u.getEmail());
            System.out.println("Tareas TO DO");
            System.out.println(ts.getTareasPorEstado(Estado.TODO.getValor(), u.getEmail()));
            System.out.println("Tareas IN PROGRESS");
            System.out.println(ts.getTareasPorEstado(Estado.INPROGRESS.getValor(), u.getEmail()));
            System.out.println("Tareas DONE");
            System.out.println(ts.getTareasPorEstado(Estado.DONE.getValor(), u.getEmail()));
        }
        
        System.out.println("-------------------------------");
        
        System.out.println("* PRUEBA modificarEstadoTarea *");
        for(Usuario u: usuarios){
            System.out.println("USUARIO: " + u.getEmail());
            Set<Tarea> lt = tareasPorUsuario.get(u.getEmail()); 
            Tarea t = lt.iterator().next();
            try { 
                System.out.println(t.toString());
                System.out.println("TO DO > IN PROGRESS");    
                ts.modificarEstadoTarea(t.getIdTarea(), Estado.INPROGRESS.getValor(), u.getEmail());    
                System.out.println(t.toString());
                System.out.println("IN PROGRESS > DONE");    
                ts.modificarEstadoTarea(t.getIdTarea(), Estado.DONE.getValor(), u.getEmail());   
                System.out.println(t.toString());
                System.out.println("DONE > IN PROGRESS");    
                ts.modificarEstadoTarea(t.getIdTarea(), Estado.INPROGRESS.getValor(), u.getEmail());   
                System.out.println(t.toString());
                System.out.println("IN PROGRESS > TO DO");    
                ts.modificarEstadoTarea(t.getIdTarea(), Estado.TODO.getValor(), u.getEmail());
                System.out.println(t.toString());
            } catch (TareasException ex) {
                System.out.println(ex.getMessage());
            }
        }
 
        System.out.println("-------------------------------");

        System.out.println("* PRUEBA darAltaTarea *");
        for(Usuario u: usuarios){
            System.out.println("USUARIO: " + u.getEmail());
            try {
                System.out.println("Añado tarea TareaAA");
                ts.darAltaTarea("TareaAA", u.getEmail());
                System.out.println("Añado tarea TareaBB");
                ts.darAltaTarea("TareaBB", u.getEmail());
                System.out.println("Añado tarea TareaBB que ya existe (pero el id va a ser diferente)");
                ts.darAltaTarea("TareaBB", u.getEmail());
            } catch (TareasException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Tareas TO DO: " + ts.getTareasPorEstado(Estado.TODO.getValor(), u.getEmail()));
            
        }
        
        System.out.println("-------------------------------");

        System.out.println("*** PRUEBA USUARIOS ***");
        UsuariosService us = new UsuariosService();
        
        System.out.println("-------------------------------");
        
        System.out.println("* PRUEBA darAltaUsuario *");
        try {
        System.out.println("Añado usuario usuario5@email.com");
        us.darAltaUsuario(new Usuario("usuario5@email.com","555555","Nombre5","Apellido5"));
        System.out.println("Añado usuario usuario6@email.com");
        us.darAltaUsuario(new Usuario("usuario6@email.com","666666","Nombre6","Apellido6"));
        System.out.println("Añado usuario usuario6@email.com que ya existe");
        us.darAltaUsuario(new Usuario("usuario6@email.com","666666","Nombre6","Apellido6"));
        } catch (UsuariosException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("LISTA USUARIOS: " + usuarios);
        System.out.println("LISTA TAREAS POR USUARIO: " + tareasPorUsuario);

    }
    
}
