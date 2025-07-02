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
public class Admision_Class {
    
    public static Cola<Expediente> ExpedientesAdmision;
     static  {
        ExpedientesAdmision = new Cola<>();
    }

    public static void agregar(Expediente item) {
        ExpedientesAdmision.encolar(item);
    }

    public static void desencolarExpediente() {
        ExpedientesAdmision.desencolar();

    }
    
         public static void mostrar() {
        Cola<Expediente> temp = new Cola<>();

        while (!ExpedientesAdmision.esVacia()) {
            Expediente tmp = ExpedientesAdmision.desencolar();
            tmp.mostrar();
            temp.encolar(tmp);
        }

        while (!temp.esVacia()) {
            ExpedientesAdmision.encolar(temp.desencolar());
        }
    } 
    
    public static Expediente BuscarExpediente(String dni){
        Cola<Expediente> temp = new Cola<>();
        Expediente EAux= new Expediente();
        Interesado IAux= new Interesado();
        while (!ExpedientesAdmision.esVacia()) {
            Expediente tmp = ExpedientesAdmision.desencolar();
            IAux=tmp.getInteresado();
            String Saux=IAux.getDni();
            if(Saux.equals(dni)){
                EAux=tmp;   
            }
            temp.encolar(tmp);
        }
        while (!temp.esVacia()) {
            ExpedientesAdmision.encolar(temp.desencolar());
        }
        return EAux;
    }
     // funcion que cambia de estado al expediente
        
        
        
        
}
