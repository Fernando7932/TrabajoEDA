package Controlador;

import TDA.*;
import Modelo.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author IAN
 */
public class RegistrarExpediente {

    public static Cola<Expediente> Expedientes;

    

    static  {
        Expedientes = new Cola<>();
    }

    public static void agregar(Expediente item) {
        Expedientes.encolar(item);
    }

    public static void desencolarExpediente() {
        Expedientes.desencolar();

    }
    
         public static void mostrar() {
        Cola<Expediente> temp = new Cola<>();

        while (!Expedientes.esVacia()) {
            Expediente tmp = Expedientes.desencolar();
            tmp.mostrar();
            temp.encolar(tmp);
        }

        while (!temp.esVacia()) {
            Expedientes.encolar(temp.desencolar());
        }
    } 
    
    public static void BuscarExpediente(String dni){
        Cola<Expediente> temp = new Cola<>();
        Expediente EAux= new Expediente();
        Interesado IAux= new Interesado();
        while (!Expedientes.esVacia()) {
            Expediente tmp = Expedientes.desencolar();
            IAux=tmp.getInteresado();
            String Saux=IAux.getDni();
            if(Saux.equals(dni)){
                tmp.mostrar();
            }
            temp.encolar(tmp);
        }
        
        while (!temp.esVacia()) {
            Expedientes.encolar(temp.desencolar());
        }
    }
    
        public static <T>void CountQueue(Cola<T> cola){
        Cola <T> aux= new Cola<>();
        int count=0;
        while(!cola.esVacia()){
            T item=cola.desencolar();
            count++;
            aux.encolar(item);
        }
        System.out.println("lenght: " + count);
        while(!aux.esVacia()){
            cola.encolar(aux.desencolar());
        }
    }
   
}
