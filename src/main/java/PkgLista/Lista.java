/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PkgLista;

import PkgAlumno.ClassAlumno;
import java.util.Scanner;

/**
 *
 * @author Josue_Guevara
 */
public class Lista {
    private static final Scanner sn = new Scanner(System.in);
    public Nodo primero; //Sera la cabeza 
    
    public Lista(){
        primero = null;
    }
    
    /*
    Agrega alumnos a  mi lista enlazada, pero el metodo no lo utilizo por que se agregan todos en la funcion
    principal, dejango obsoleto por el momento el metodo
    */
    public ClassAlumno ingresarAlumno(){
        ClassAlumno alumno;
        
        System.out.println("Ingresa el nombre del alumno: ");
        String nombre = sn.nextLine();
        System.out.println("Ingresa el carnet del alumno: ");
        int carnet = Integer.parseInt(sn.nextLine());
        System.out.println("Ingresa el promedio del alumno: ");
        double promedio = Double.parseDouble(sn.nextLine());
        
        return alumno = new ClassAlumno(nombre, carnet, promedio);
    }
    
    //Agrega un alumno de forma statica
    public Lista agregar(ClassAlumno alumno){
        primero = new Nodo(alumno, primero);
        return this;
    }
    
    //Inserta un nuevo alumno 
    public Lista insertarCabezaList(){
        Nodo nuevo;
        ClassAlumno alumno = ingresarAlumno();
        nuevo = new Nodo(alumno);
        
        nuevo.enlace = primero;
        primero = nuevo;
        System.out.println("Alumno insertado");
        return this;
    }
    
    //Visualiza mi lista
    public void verListaEnlazada(){
        Nodo n;
        int k = 0;
        n = primero;
        while(n != null){
            System.out.println(n.dato.getNombre()+" -- "+n.dato.getCarnet()+" -- "+n.dato.getPromedio());
            n = n.enlace;
            k++;
        }
    }
    
    //Inserta un ultimo elemento, pero antes de eso se debe buscar el elemento ultimo
    public Lista insertarUltimo(){
        Nodo n = primero;
        while (n != null) {
            if (n.enlace == null) {
                ClassAlumno nuevoAlumno = ingresarAlumno();
                n.enlace = new Nodo(nuevoAlumno);
                n = n.enlace;
                System.out.println("Alumno insertado");
            }
            n = n.enlace;
        }
        return this;
    }
    
    //Busca al elemento ingresado
    public Nodo buscarAlumno(ClassAlumno alumno){
        Nodo indice = null;
        
        for(indice = primero; indice != null; indice = indice.enlace){
            if((alumno.getNombre().equals(indice.dato.getNombre()))
                    &&(alumno.getCarnet() == indice.dato.getCarnet())&&
                    (alumno.getPromedio() == indice.dato.getPromedio())){
                System.out.println("Alumno encontrado");
                System.out.println("Nombre -- "+indice.dato.getNombre());
                System.out.println("Carnet -- "+indice.dato.getCarnet());
                System.out.println("Promedio -- "+indice.dato.getPromedio());
                return indice;
            }
        }
        
        return indice;
    }
    
    /*
    Busca el nodo y lo agraga de la siguiente manera
    se crea un nuevo nodo, con datos y enlace null,
    nuevo.enlace es asignado con el dato anterior.enlace
    ese espacio que queda es rellenado con el nuevo dato o alumno
    */
    public Lista insertarAlumnoLista(ClassAlumno testigo){
        ClassAlumno nuevoAlumno = ingresarAlumno();
        Nodo nuevo, anterior;
        anterior = buscarAlumno(testigo);
        if(anterior != null){
            nuevo = new Nodo(nuevoAlumno);
            nuevo.enlace = anterior.enlace;
            anterior.enlace = nuevo;
            System.out.println("Alumno insertado");
        }
        
        return this;
    }
    
    
    //Busca la posicion de un alumno, i sirve para ver en el nodo en que se encuentra
    public Nodo buscarPosicionAlumno(ClassAlumno alumno){
        int i = 0;
        Nodo n = primero;
        
        while(n != null){
            if(alumno.getNombre().equals(n.dato.getNombre()) &&
                    alumno.getCarnet() == n.dato.getCarnet()){
                return n;
            }
            
            n = n.enlace;
            i++;
            
        }
        return n;
    }
    
    /*
    Elimina un nodo 
    */
    public Lista eliminar(ClassAlumno eliminarAlumno){
        Nodo actual = primero, anterior = null;
        boolean encontrado = false;
        while((actual != null)&&(!encontrado)){
            encontrado = (actual.dato.getNombre().equals(eliminarAlumno.getNombre()) 
                    && (actual.dato.getCarnet() == eliminarAlumno.getCarnet()));
            if(!encontrado){
                anterior = actual;
                actual = actual.enlace;
            }
            
            
        }
        
        if(actual != null){
            if(actual.dato.getNombre().equals(primero.dato.getNombre()) && (actual.dato.getCarnet() == primero.dato.getCarnet())){
                primero = actual;
            }
            else{
                anterior.enlace = actual.enlace;
                
            }
            actual = null;
        }
        System.out.println("Alumno eliminado");
        return this;
        
    }   
}
