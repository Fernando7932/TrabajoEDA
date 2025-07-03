/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.Admision_Class.ExpedientesAdmision;
import TDA.*;
import java.util.Date;

/**
 * Clase de utilidad para las acciones que puede realizar un administrador.
 *
 * @author fernando
 */
public class Administrador {

    public static String usuario;
    public static String contraseña;
    public static Cola<Expediente> ExpedientesPrincipal;
    public static Lista<Expediente> ExpedientesFinalizados;

    public static String getUsuario() {
        return usuario;
    }

    public static String getContraseña() {
        return contraseña;
    }

    static {
        ExpedientesPrincipal = new Cola<>();
    }

    static {
        ExpedientesFinalizados = new Lista<>();
    }

    public static void agregar(Expediente item) {
        ExpedientesPrincipal.encolar(item);
    }

    public static void desencolarExpediente() {
        ExpedientesPrincipal.desencolar();

    }

    public static void mostrar() {
        Cola<Expediente> temp = new Cola<>();

        while (!ExpedientesPrincipal.esVacia()) {
            Expediente tmp = ExpedientesPrincipal.desencolar();
            tmp.mostrar();
            temp.encolar(tmp);
        }

        while (!temp.esVacia()) {
            ExpedientesPrincipal.encolar(temp.desencolar());
        }
    }

    public static void agregarFinalizado(Expediente item) {
        ExpedientesFinalizados.agregar(item);
    }

    public static void mostrarFinalizado() {
        int i = 1;
        int j = 1;
        Nodo<Expediente> aux = ExpedientesFinalizados.getCabeza();
        //Imgrese al bucle siempre que tenga elementos
        while (aux != null) { // La lista no esta vacia
            aux.getItem().mostrar();
            aux = aux.getSgteNodo();
        }
//    Lista<Expediente> temp = new Lista<>();
//
//        while (i<ExpedientesFinalizados.longitud()) {
//            Expediente tmp = ExpedientesFinalizados.iesimo(i);
//            tmp.mostrar();
//            ExpedientesFinalizados.eliminar(i);
//            temp.agregar(tmp);
//            i++;
//        }
//
//        while (j<temp.longitud()) {
//            ExpedientesFinalizados.agregar(temp.iesimo(j));
//            j++;
//        }

    }

    public static Expediente buscarPorDNI(String dni) {
        Cola<Expediente> temp = new Cola<>();
        Expediente EAux = new Expediente();
        Interesado IAux = new Interesado();
        while (!ExpedientesPrincipal.esVacia()) {
            Expediente tmp = ExpedientesPrincipal.desencolar();
            IAux = tmp.getInteresado();
            String Saux = IAux.getDni();
            if (Saux.equals(dni)) {
                EAux = tmp;
            }
            temp.encolar(tmp);
        }
        while (!temp.esVacia()) {
            ExpedientesPrincipal.encolar(temp.desencolar());
        }
        return EAux;
    }

    public static void ExpedienteFinalizados(int estado) {
        Cola<Expediente> temp = new Cola<>();
        Expediente EAux = new Expediente();
        while (!ExpedientesPrincipal.esVacia()) {
            Expediente tmp = ExpedientesPrincipal.desencolar();
            if (tmp.getEstado() == estado) {
                EAux = tmp;
                ExpedientesFinalizados.agregar(EAux);
            }
            temp.encolar(tmp);
        }
        while (!temp.esVacia()) {
            ExpedientesPrincipal.encolar(temp.desencolar());
        }

    }

    // funcion que cambia de estado al expediente
    public static void CambiarEstado(int idSeleccionado) {
        Cola<Expediente> temporal = new Cola<>();
        boolean cambiado = false;
        while (!ExpedientesPrincipal.esVacia()) {
            Expediente e = ExpedientesPrincipal.desencolar();

            if (e.getId() == idSeleccionado) {
                e.setEstado(2); // Cambiar estado a "En proceso"
                cambiado = true;
            }

            temporal.encolar(e);
        }

        // Restaurar la cola original
        while (!temporal.esVacia()) {
            ExpedientesPrincipal.encolar(temporal.desencolar());
        }
    }
    //misma funcion pero con return para poder utilizar funciones

    public static boolean CambiarEstadoCR(int idSeleccionado) {
        Cola<Expediente> temporal = new Cola<>();
        boolean cambiado = false;
        while (!ExpedientesPrincipal.esVacia()) {
            Expediente e = ExpedientesPrincipal.desencolar();

            if (e.getId() == idSeleccionado) {
                e.setEstado(2); // Cambiar estado a "En proceso"
                cambiado = true;
            }

            temporal.encolar(e);
        }

        // Restaurar la cola original
        while (!temporal.esVacia()) {
            ExpedientesPrincipal.encolar(temporal.desencolar());
        }
        return cambiado;
    }

    public static boolean CompletarExpedienteCR(Date fechaActual, int idSeleccionado) {
        Cola<Expediente> temporal = new Cola();
        boolean cambiado = false;

        while (!ExpedientesPrincipal.esVacia()) {
            Expediente e = ExpedientesPrincipal.desencolar();

            if (e.getId() == idSeleccionado) {
                if (e.getEstado() == 1) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Primero se tiene que derivar un Expediente.");
                } else {
                    e.setEstado(3); // Cambiar estado a "Finalizado"
                    cambiado = true;
                    e.setFfinal(fechaActual); // Asignar fecha actual como fecha de finalización
                    e.completarTramite();
                }

            }

            temporal.encolar(e);
        }

        // Restaurar la cola original
        while (!temporal.esVacia()) {
            ExpedientesPrincipal.encolar(temporal.desencolar());
        }
        return cambiado;
    }

    public static void CompletarExpediente(Date fechaActual, int idSeleccionado) {
        Cola<Expediente> temporal = new Cola();
        boolean cambiado = false;
        while (!ExpedientesPrincipal.esVacia()) {
            Expediente e = ExpedientesPrincipal.desencolar();

            if (e.getId() == idSeleccionado) {
                if (e.getEstado() == 1) {
                    javax.swing.JOptionPane.showMessageDialog(null, "ERROR");
                } else {
                    e.setEstado(3); // Cambiar estado a "Finalizado"
                    cambiado = true;
                    e.setFfinal(fechaActual); // Asignar fecha actual como fecha de finalización
                    e.completarTramite();
                }
            }
            temporal.encolar(e);
        }
        // Restaurar la cola original
        while (!temporal.esVacia()) {
            ExpedientesPrincipal.encolar(temporal.desencolar());
        }
    }

    public static Expediente crearExpediente(String prioridad, Interesado interesado,
            String asunto, String documento) {
        return new Expediente(prioridad, interesado, asunto, documento);
    }

    public static void derivarA(String Dependencia, Expediente exp) {
        exp.derivarTramite();
        if (Dependencia.equalsIgnoreCase("Admision")) {
            exp.setDependencia("Admision");
            Admision_Class.agregar(exp);
        }
        if (Dependencia.equalsIgnoreCase("Alumnos y Egresados")) {
            exp.setDependencia("Alumnos y Egresados");
            Alumnos_Egresados_class.agregar(exp);
        }
        if (Dependencia.equalsIgnoreCase("Matricula")) {
            exp.setDependencia("Matricula");
            Matricula_Class.agregar(exp);
        }
        if (Dependencia.equalsIgnoreCase("cola princiapal")) {
            String dni = exp.getInteresado().getDni();
            buscarPorDNI(dni).setDependencia("Vuelta a la cola principal");
        }
    }

    public static void eliminarDeCola(Expediente expediente) {
        // Crea una cola temporal para almacenar los expedientes que no se eliminarán
        Cola<Expediente> temp = new Cola<>();
        // Recorre la cola de Admisión y elimina el expediente especificado
        while (!ExpedientesPrincipal.esVacia()) {
            Expediente tmp = ExpedientesPrincipal.desencolar();
            if (tmp.getId() != expediente.getId()) {
                // Agrega el expediente a la cola temporal si no es el que se busca eliminar
                temp.encolar(tmp);
            }
        }
        // Vuelve a agregar los expedientes de la cola temporal a la cola de Admisión
        while (!temp.esVacia()) {
            ExpedientesPrincipal.encolar(temp.desencolar());
        }
    }

}
