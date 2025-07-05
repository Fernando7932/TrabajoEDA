package Controlador;

import Modelo.Administrador;
import Modelo.Expediente;
import TDA.*;
import TDA.ListaDoble;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 * Gestiona las notificaciones automáticas sobre el estado de los expedientes.
 */
public class Notificador {
    private final Timer timer;

    /**
     * Constructor que inicializa el temporizador.
     */
    
    
    public Notificador() {
        this.timer = new Timer();
    }

    /**
     * Inicia la tarea de notificación para que se ejecute cada 10 minutos.
     */
    public void iniciar() {
        // Ejecuta la tarea cada 10 minutos (600,000 milisegundos)
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                contarYNotificarExpedientes();
            }
        }, 0, 10 * 60 * 1000);
    }

    /**
     * Cuenta y notifica expedientes en todas las colas (principal, admisión, alumnos/egresados, matrícula).
     */
    private void contarYNotificarExpedientes() {
        ListaDoble<Integer> Procesos=new ListaDoble<>();
        int sinDerivar = contarEstadoCola(Administrador.ExpedientesPrincipal, 1);
        int enProceso = contarEstadoCola(Administrador.ExpedientesPrincipal, 2)+
                contarEstadoCola(Modelo.Admision_Class.ExpedientesAdmision, 2)+
                contarEstadoCola(Modelo.Alumnos_Egresados_class.ExpedientesAlum_Egre, 2)+
                contarEstadoCola(Modelo.Matricula_Class.ExpedientesMatricula, 2);
        int finalizados = contarEstadoCola(Administrador.ExpedientesPrincipal, 3);
        Procesos.agregar(sinDerivar);
        Procesos.agregar(enProceso);
        Procesos.agregar(finalizados);
        
        String[] etiquetas = {"Sin derivar", "En proceso", "Finalizados"};
        NodoDoble<Integer> actual = Procesos.getCabeza();
        int i = 0;
        String mensaje = "";
        while (actual != null) {
            mensaje += etiquetas[i] + ": " + actual.getItem() + "\n";
            actual = actual.getSgteNodo();
            i++;
        }
        JOptionPane.showMessageDialog(null, mensaje, "Notificación de Expedientes", JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * Cuenta cuántos expedientes de un estado hay en una cola dada.
     */
    private int contarEstadoCola(TDA.Cola<Modelo.Expediente> cola, int estado) {
        int contador = 0;
        TDA.Cola<Modelo.Expediente> temp = new TDA.Cola<>();
        while (!cola.esVacia()) {
            Modelo.Expediente exp = cola.desencolar();
            if (exp.getEstado() == estado) contador++;
            temp.encolar(exp);
        }
        while (!temp.esVacia()) {
            cola.encolar(temp.desencolar());
        }
        return contador;
    }

    /**
     * Detiene el temporizador de notificaciones.
     */
    public void detener() {
        timer.cancel();
    }
   
}