package Controlador;

import TDA.*;
import Modelo.*;
import java.util.Date;
import javax.swing.JOptionPane;
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
    public static Cola<Expediente> alta;
    public static Cola<Expediente> media;
    public static Cola<Expediente> baja;
    public static boolean cambiado;

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
    
    public static Expediente BuscarExpediente(String dni){
        Cola<Expediente> temp = new Cola<>();
        Expediente EAux= new Expediente();
        Interesado IAux= new Interesado();
        while (!Expedientes.esVacia()) {
            Expediente tmp = Expedientes.desencolar();
            IAux=tmp.getInteresado();
            String Saux=IAux.getDni();
            if(Saux.equals(dni)){
                EAux=tmp;   
            }
            temp.encolar(tmp);
        }
        while (!temp.esVacia()) {
            Expedientes.encolar(temp.desencolar());
        }
        return EAux;
    }
        // funcion que cambia de estado al expediente
        public static void CambiarEstado(int idSeleccionado)
        { 
            Cola<Expediente> temporal = new Cola<>();
            boolean cambiado = false;
            while (!Expedientes.esVacia()) {
                Expediente e = Expedientes.desencolar();

                if (e.getId() == idSeleccionado) {
                    e.setEstado(2); // Cambiar estado a "En proceso"
                    cambiado = true;
                }

                temporal.encolar(e);
            }

            // Restaurar la cola original
            while (!temporal.esVacia()) {
                Expedientes.encolar(temporal.desencolar());
            }
        }
        //misma funcion pero con return para poder utilizar funciones
        public static boolean CambiarEstadoCR(int idSeleccionado)
        { 
            Cola<Expediente> temporal = new Cola<>();
            boolean cambiado = false;
            while (!Expedientes.esVacia()) {
                Expediente e = Expedientes.desencolar();

                if (e.getId() == idSeleccionado) {
                    e.setEstado(2); // Cambiar estado a "En proceso"
                    cambiado = true;
                }

                temporal.encolar(e);
            }

            // Restaurar la cola original
            while (!temporal.esVacia()) {
                Expedientes.encolar(temporal.desencolar());
            }return cambiado;
        }
        public static boolean CompletarExpedienteCR(Date fechaActual ,int idSeleccionado){
            Cola<Expediente> temporal = new Cola();
            boolean cambiado = false;

            while (!Expedientes.esVacia()) {
                Expediente e = Expedientes.desencolar();

                if (e.getId() == idSeleccionado) {
                    if (e.getEstado() == 1) {
                        javax.swing.JOptionPane.showMessageDialog(null, "Se debe de  Primero se tiene que derivar un Expediente.");
                    } else {
                        e.setEstado(3); // Cambiar estado a "Finalizado"
                        cambiado = true;
                        e.setFfinal(fechaActual); // Asignar fecha actual como fecha de finalización
                        Administrador.completarExpediente(e);
                    }

                }

                temporal.encolar(e);
            }

            // Restaurar la cola original
            while (!temporal.esVacia()) {
                Expedientes.encolar(temporal.desencolar());
            }return cambiado;                                                                                                                                                                               
        }
        public static void CompletarExpediente(Date fechaActual ,int idSeleccionado){
            Cola<Expediente> temporal = new Cola();
            boolean cambiado = false;

            while (!Expedientes.esVacia()) {
                Expediente e = Expedientes.desencolar();

                if (e.getId() == idSeleccionado) {
                    if (e.getEstado() == 1) {
                        javax.swing.JOptionPane.showMessageDialog(null, "ERROR: Primero se tiene que derivar un Expediente.");
                    } else {
                        e.setEstado(3); // Cambiar estado a "Finalizado"
                        cambiado = true;
                        e.setFfinal(fechaActual); // Asignar fecha actual como fecha de finalización
                        Administrador.completarExpediente(e);
                    }

                }

                temporal.encolar(e);
            }

            // Restaurar la cola original
            while (!temporal.esVacia()) {
                Expedientes.encolar(temporal.desencolar());
            }                                                                                                                                                                              
        }
//        public static void OrdenarPorPrioridad(boolean enProceso){
//        Cola<Expediente> temp = new Cola<>();
//
//        int estadoFiltrar = enProceso ? 2 : 1;
//
//        while (!Expedientes.esVacia()) {
//            Expediente e = Expedientes.desencolar();
//            if (e.getEstado() == estadoFiltrar) {
//                switch (e.getPrioridad()) {
//                    case "Alta" -> RegistrarExpediente.alta.encolar(e);
//                    case "Media" -> RegistrarExpediente.media.encolar(e);
//                    case "Baja" -> RegistrarExpediente.baja.encolar(e);
//                }
//            }
//            temp.encolar(e);
//        }
//
//        while (!temp.esVacia()) {
//            Expedientes.encolar(temp.desencolar());
//        }
//        }
    }
  

