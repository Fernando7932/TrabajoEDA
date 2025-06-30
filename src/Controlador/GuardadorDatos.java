package Controlador;

import Modelo.Expediente;
import TDA.Cola;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 * Clase de utilidad para guardar datos en archivos de texto.
 */
public class GuardadorDatos {

    /**
     * Guarda todos los expedientes activos (no finalizados) en un archivo de
     * texto. Guarda todos los expedientes (incluidos los finalizados) en un
     * archivo de texto. Sobrescribe el archivo si ya existe. El formato de
     * guardado es:
     * dni;nombres;telefono;tipo;email;prioridad;asunto;documentoReferencia;estado;fechaInicio;fechaFinal;documentoResultante
     *
     * @param rutaArchivo La ruta del archivo .txt donde se guardarán los datos.
     */
    public static void guardarExpedientesEnTxt(String rutaArchivo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // El 'false' en FileWriter indica que se debe sobrescribir el archivo.
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, false))) {
            Cola<Expediente> expedientes = RegistrarExpediente.Expedientes;
            Cola<Expediente> temp = new Cola<>();

            // Iterar sobre la cola para guardarla y luego restaurarla
            while (!expedientes.esVacia()) {
                Expediente exp = expedientes.desencolar();

                String fechaInicioStr = (exp.getFechaInicio() != null) ? sdf.format(exp.getFechaInicio()) : "null";
                String fechaFinalStr = (exp.getFechaFinal() != null) ? sdf.format(exp.getFechaFinal()) : "null";
                String docResultanteStr = (exp.getDocumentoResultante() != null && !exp.getDocumentoResultante().isEmpty()) ? exp.getDocumentoResultante() : "null";

                String linea = String.join(";",
                        exp.getInteresado().getDni(),
                        exp.getInteresado().getNombre(),
                        exp.getInteresado().getTelefono(),
                        exp.getInteresado().getTipo(),
                        exp.getInteresado().getEmail(),
                        exp.getPrioridad(),
                        exp.getAsunto(),
                        exp.getDocumentoReferencia(),
                        String.valueOf(exp.getEstado()),
                        fechaInicioStr,
                        fechaFinalStr,
                        docResultanteStr);
                bw.write(linea);
                bw.newLine();
                temp.encolar(exp);
            }
            // Restaurar la cola original
            while (!temp.esVacia()) {
                expedientes.encolar(temp.desencolar());
            }
            System.out.println("Datos de expedientes guardados correctamente en " + rutaArchivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar los datos en 'expedientes.txt'.", "Error de Guardado", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    
}
