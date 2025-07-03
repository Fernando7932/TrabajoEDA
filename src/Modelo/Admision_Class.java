/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import TDA.Cola;

/**
 * Clase que representa la dependencia de Admisión.
 * Administra su propia cola de expedientes y permite derivar, agregar, eliminar y buscar expedientes.
 */
public class Admision_Class {
    
    // Cola de expedientes asignados a la dependencia de Admisión
    public static Cola<Expediente> ExpedientesAdmision;
    
    /**
     * Inicializa la cola de expedientes de Admisión.
     */
    static  {
        ExpedientesAdmision = new Cola<>();
    }

    /**
     * Agrega un expediente a la cola de Admisión.
     * @param item Expediente a agregar
     */
    public static void agregar(Expediente item) {
        ExpedientesAdmision.encolar(item);
    }

    /**
     * Elimina el primer expediente de la cola de Admisión.
     */
    public static void desencolarExpediente() {
        ExpedientesAdmision.desencolar();

    }
    /**
     * Verifica si es vacia
     */
    public static boolean esVacio(){
       return ExpedientesAdmision.esVacia();
    }
    /**
     * Deriva un expediente desde Admisión hacia otra dependencia o al administrador.
     * @param destino Nombre de la dependencia destino ("Administrador", "Alumnos_Egresados", "Matricula")
     * @param expediente Expediente a derivar
     */
    public static void derivarA(String destino, Expediente expediente) {
        // Utiliza un switch para determinar la dependencia destino
        switch (destino) {
            case "Cola Principal":
                // Deriva el expediente al administrador
                expediente.Dependencia = "Administrador";
                break;
            case "Alumnos y Egresados":
                // Deriva el expediente a Alumnos y Egresados
                Modelo.Alumnos_Egresados_class.agregar(expediente);
                expediente.Dependencia = "Alumnos_Egresados";
                break;
            case "Matricula":
                // Deriva el expediente a Matricula
                Modelo.Matricula_Class.agregar(expediente);
                expediente.Dependencia = "Matricula";
                break;
            default:
                // No realiza ninguna acción si el destino no es válido
                break;
        }
        // Elimina el expediente de la cola de Admisión después de derivarlo
        EliminarDeCola(expediente);
    }

    /**
     * Elimina un expediente específico de la cola de Admisión.
     * @param expediente Expediente a eliminar
     */
    public static void EliminarDeCola(Expediente expediente) {
        // Crea una cola temporal para almacenar los expedientes que no se eliminarán
        Cola<Expediente> temp = new Cola<>();
        // Recorre la cola de Admisión y elimina el expediente especificado
        while (!ExpedientesAdmision.esVacia()) {
            Expediente tmp = ExpedientesAdmision.desencolar();
            if (tmp.getId() != expediente.getId()) {
                // Agrega el expediente a la cola temporal si no es el que se busca eliminar
                temp.encolar(tmp);
            }
        }
        // Vuelve a agregar los expedientes de la cola temporal a la cola de Admisión
        while (!temp.esVacia()) {
            ExpedientesAdmision.encolar(temp.desencolar());
        }
    }

    /**
     * Muestra todos los expedientes en la cola de Admisión.
     */
    public static void mostrar() {
        // Crea una cola temporal para almacenar los expedientes mientras se muestran
        Cola<Expediente> temp = new Cola<>();

        // Recorre la cola de Admisión y muestra cada expediente
        while (!ExpedientesAdmision.esVacia()) {
            Expediente tmp = ExpedientesAdmision.desencolar();
            tmp.mostrar();
            // Agrega el expediente a la cola temporal después de mostrarlo
            temp.encolar(tmp);
        }

        // Vuelve a agregar los expedientes de la cola temporal a la cola de Admisión
        while (!temp.esVacia()) {
            ExpedientesAdmision.encolar(temp.desencolar());
        }
    } 
    
    /**
     * Busca un expediente en la cola de Admisión por el DNI del interesado.
     * @param dni DNI a buscar
     * @return El expediente encontrado, o null si no existe
     */
    public static Expediente buscarPorDNI(String dni) {
        // Crea una cola temporal para almacenar los expedientes mientras se buscan
        Cola<Expediente> temp = new Cola<>();
        Expediente EAux= new Expediente();
        Interesado IAux= new Interesado();
        // Recorre la cola de Admisión y busca el expediente con el DNI especificado
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
        
        
}
