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
public class Alumnos_Egresados_class {
    
    public static Cola<Expediente> ExpedientesAlum_Egre;
     static  {
        ExpedientesAlum_Egre = new Cola<>();
    }

    public static void agregar(Expediente item) {
        ExpedientesAlum_Egre.encolar(item);
    }

    public static void desencolarExpediente() {
        ExpedientesAlum_Egre.desencolar();

    }
    
         public static void mostrar() {
        Cola<Expediente> temp = new Cola<>();

        while (!ExpedientesAlum_Egre.esVacia()) {
            Expediente tmp = ExpedientesAlum_Egre.desencolar();
            tmp.mostrar();
            temp.encolar(tmp);
        }

        while (!temp.esVacia()) {
            ExpedientesAlum_Egre.encolar(temp.desencolar());
        }
    } 
    
    public static Expediente BuscarExpediente(String dni){
        Cola<Expediente> temp = new Cola<>();
        Expediente EAux= new Expediente();
        Interesado IAux= new Interesado();
        while (!ExpedientesAlum_Egre.esVacia()) {
            Expediente tmp = ExpedientesAlum_Egre.desencolar();
            IAux=tmp.getInteresado();
            String Saux=IAux.getDni();
            if(Saux.equals(dni)){
                EAux=tmp;   
            }
            temp.encolar(tmp);
        }
        while (!temp.esVacia()) {
            ExpedientesAlum_Egre.encolar(temp.desencolar());
        }
        return EAux;
    }
        
}
