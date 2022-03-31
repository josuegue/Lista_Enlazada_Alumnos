/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PkgLista;

import PkgAlumno.ClassAlumno;

/**
 *
 * @author Josue_Guevara
 */
public class Nodo {
    ClassAlumno dato;
    Nodo enlace;
    
    //Crea el contructor inicial 
    public Nodo(ClassAlumno alumno){
        dato = new ClassAlumno(alumno.getNombre(), alumno.getCarnet(), alumno.getPromedio());
        enlace = null;
    }
    
    //Segundo contructor para crear nodo y enlazar
    public Nodo(ClassAlumno otro, Nodo n){
        dato = new ClassAlumno(otro.getNombre(), otro.getCarnet(), otro.getPromedio());
        enlace = n; 
    }
    
    public ClassAlumno getDato(){
        return dato; 
    }
    
    public Nodo getEnlace(){
        return enlace; 
    }
    
    public void setEnlace(Nodo enlace){
        this.enlace = enlace; 
    }
    
}
