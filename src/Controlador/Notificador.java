package Controlador;

import Modelo.Expediente;
import TDA.Cola;
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
     * Realiza el conteo de expedientes y muestra una notificación.
     * Utiliza una ListaDoble para procesar los datos sin alterar la cola original.
     */
    private void contarYNotificarExpedientes() {
        int sinDerivar = 0;
        int enProceso = 0;

        // Copiamos la cola a una lista doble para no modificar la original
        ListaDoble<Expediente> listaExpedientes = new ListaDoble<>();
        Cola<Expediente> expedientesOriginal = RegistrarExpediente.Expedientes;
        Cola<Expediente> tempCola = new Cola<>();

        while (!expedientesOriginal.esVacia()) {
            Expediente exp = expedientesOriginal.desencolar();
            listaExpedientes.agregar(exp);
            tempCola.encolar(exp);
        }
        // Restauramos la cola original
        while(!tempCola.esVacia()){
            expedientesOriginal.encolar(tempCola.desencolar());
        }

        // Contamos los expedientes desde la lista doble
        for (int i = 1; i <= listaExpedientes.longitud(); i++) {
            Expediente exp = listaExpedientes.iesimo(i);
            if (exp.getEstado() == 1) { // Sin derivar
                sinDerivar++;
            } else if (exp.getEstado() == 2) { // En proceso
                enProceso++;
            }
        }

        String mensaje = "Resumen de Expedientes:\n\n"
                + "Sin derivar: " + sinDerivar + "\n"
                + "En proceso: " + enProceso;

        JOptionPane.showMessageDialog(null, mensaje, "Notificación de Expedientes", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Detiene el temporizador de notificaciones.
     */
    public void detener() {
        timer.cancel();
    }
}