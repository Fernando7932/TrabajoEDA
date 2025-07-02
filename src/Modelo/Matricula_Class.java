/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import TDA.Cola;

/**
 *
 * @author YUSTIN
 */
public class Matricula_Class {
    
    public static Cola<Expediente> ExpedientesMatricula;
     static  {
        ExpedientesMatricula = new Cola<>();
    }

    public static void agregar(Expediente item) {
        ExpedientesMatricula.encolar(item);
    }

    public static void desencolarExpediente() {
        ExpedientesMatricula.desencolar();

    }
    
         public static void mostrar() {
        Cola<Expediente> temp = new Cola<>();

        while (!ExpedientesMatricula.esVacia()) {
            Expediente tmp = ExpedientesMatricula.desencolar();
            tmp.mostrar();
            temp.encolar(tmp);
        }

        while (!temp.esVacia()) {
            ExpedientesMatricula.encolar(temp.desencolar());
        }
    } 
    
    public static Expediente BuscarExpediente(String dni){
        Cola<Expediente> temp = new Cola<>();
        Expediente EAux= new Expediente();
        Interesado IAux= new Interesado();
        while (!ExpedientesMatricula.esVacia()) {
            Expediente tmp = ExpedientesMatricula.desencolar();
            IAux=tmp.getInteresado();
            String Saux=IAux.getDni();
            if(Saux.equals(dni)){
                EAux=tmp;   
            }
            temp.encolar(tmp);
        }
        while (!temp.esVacia()) {
            ExpedientesMatricula.encolar(temp.desencolar());
        }
        return EAux;
    }
}
