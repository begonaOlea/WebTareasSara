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
public class Tarea {
    
    //ATRIBUTOS
    private int idTarea; //PK
    private String descripcion;
    private String estado;

    
    //CONSTRUCTORES
    public Tarea() {
    }

    public Tarea(int idTarea, String descripcion, String estado) {
        this.idTarea = idTarea;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Tarea(String descripcion, String estado) {
        this.descripcion = descripcion;
        this.estado = estado;
    }
    
    

    
    //GETTERS AND SETTES
    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    // TO STRING

    @Override
    public String toString() {
        return "Tarea{" + "idTarea=" + idTarea + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }

    
    //EQUALS AND HASCODE
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idTarea;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarea other = (Tarea) obj;
        if (this.idTarea != other.idTarea) {
            return false;
        }
        return true;
    }

    
    
    
    
}
