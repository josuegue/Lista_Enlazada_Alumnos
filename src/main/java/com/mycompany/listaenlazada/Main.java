/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.listaenlazada;

import PkgAlumno.ClassAlumno;
import PkgLista.Lista;
import PkgLista.Nodo;
import java.util.Scanner;



/**
 *
 * @author Josue_Guevara
 */
public class Main {
    private static final Scanner sn = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        funcionPrincipal();
    }
    
    private static void funcionPrincipal(){
        ClassAlumno alumno1 = new ClassAlumno("raul",29474,99.9);
        ClassAlumno alumno2 = new ClassAlumno("josue",48575, 61.9);
        ClassAlumno alumno3 = new ClassAlumno("jesus",23345,75.6);
        ClassAlumno alumno4 = new ClassAlumno("karla",25653,89.4);
        ClassAlumno alumno5 = new ClassAlumno("emanuel",1234,98.5);
        ClassAlumno alumno6 = new ClassAlumno("estuardo",6764,67.5);
        ClassAlumno alumno7 = new ClassAlumno("elizabeth",0667,96.5);
        
        ClassAlumno alumno11 = new ClassAlumno("luna",1234,98.9);
        
        Lista lista = new Lista();
        lista.agregar(alumno1);
        lista.agregar(alumno2);
        lista.agregar(alumno3);
        lista.agregar(alumno4);
        lista.agregar(alumno5);
        lista.agregar(alumno6);
        lista.agregar(alumno7);
        lista.agregar(alumno11);
        int op = 0;
        do{
            System.out.println(" SALIR 0"
                    + "\n1. Ver datos de lista enlazada"
                    + "\n2. Insertar datos por la cabeza de la lista"
                    + "\n3. Insertar datos por la cola de la lista"
                    + "\n4. Insertar datos en cualquier parte de la lista"
                    + "\n5. Buscar alumno en los nodos, por sus datos"
                    + "\n6. Eliminar alumno (nodo donde se encuentra) "
                    + "\nIngresa la opcion: ");
            op = Integer.parseInt(sn.nextLine());
            switch(op){
                case 0:
                    System.out.println("Gracias por usar la aplicacion");
                    break;
                case 1:
                    System.out.println("Datos de la lista enlazada");
                    lista.verListaEnlazada();
                    System.out.println("----------------- FINAL ----------------");
                    break;
                case 2:
                    System.out.println("Insertar datos por la cabeza");
                    lista.insertarCabezaList();
                    System.out.println("----------------- FINAL ----------------");
                    break;
                case 3:
                    System.out.println("Insertar datos por la cola");
                    lista.insertarUltimo();
                    System.out.println("----------------- FINAL ----------------");
                    break;
                case 4:
                    System.out.println("Insertar datos por cualquier parte");
                    System.out.println("Ingresa al alumno que sera antes que el nuevo ingresado");
                    ClassAlumno alumnoTestigo = ingresarCamposLista();
                    lista.insertarAlumnoLista(alumnoTestigo);
                    
                    System.out.println("----------------- FINAL ----------------");
                    break;
                case 5:
                    System.out.println("Buscar alumnos en los nodos");
                    ClassAlumno alumnoBuscar = ingresarCamposLista();
                    Nodo alumno = lista.buscarAlumno(alumnoBuscar);
                    if(alumno == null){
                        System.out.println("Lo siento, alumno no encontrado");
                    }
                    
                    System.out.println("----------------- FINAL ----------------");
                    break;
                case 6:
                    System.out.println("Eliminar alumno");
                    ClassAlumno alumnoEliminar = ingresarCamposLista();
                    lista.eliminar(alumnoEliminar);
                    System.out.println("----------------- FINAL ----------------");
                    break;
                default:
                    System.out.println("\nIngresaste una opcion equivocada");
            }  
        } while(op !=0);
    }
    
    private static ClassAlumno ingresarCamposLista() {
        ClassAlumno datosAlumno = new ClassAlumno();
        System.out.println("Ingresa nombre del alumno");
        String nombre = sn.nextLine();
        datosAlumno.setNombre(nombre);
        System.out.println("Ingresa carnet del alumno");
        int carnet = Integer.parseInt(sn.nextLine());
        datosAlumno.setCarnet(carnet);
        System.out.println("Ingresa promedio del alumno");
        double promedio = Double.parseDouble(sn.nextLine());
        datosAlumno.setPromedio(promedio);
        
        return datosAlumno;
    }
    
}
