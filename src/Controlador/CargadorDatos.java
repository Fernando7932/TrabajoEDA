package Controlador;

import Modelo.Expediente;
import Modelo.Interesado;
import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Clase de utilidad para cargar datos desde archivos de texto.
 */
public class CargadorDatos {

    /**
     * Carga los expedientes desde un archivo de texto y los agrega a la cola principal.
     * El formato esperado en cada línea es:
     * dni;nombres;telefono;tipo;email;prioridad;asunto;documentoReferencia;estado;fechaInicio;fechaFinal;documentoResultante
     * @param rutaArchivo La ruta del archivo .txt a cargar.
     */
    public static void cargarExpedientesDesdeTxt(String rutaArchivo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue; // Omitir líneas vacías

                String[] datos = linea.split(";");
                if (datos.length == 12) {
                    Interesado interesado = new Interesado(datos[0].trim(), datos[1].trim(), datos[2].trim(), datos[3].trim(), datos[4].trim());
                    Expediente expediente = new Expediente(datos[5].trim(), interesado, datos[6].trim(), datos[7].trim());

                    // Cargar los datos adicionales usando setters
                    expediente.setEstado(Integer.parseInt(datos[8].trim()));
                    try {
                        if (!datos[9].trim().equals("null")) expediente.setFechaInicio(sdf.parse(datos[9].trim()));
                        if (!datos[10].trim().equals("null")) expediente.setFechaFinal(sdf.parse(datos[10].trim()));
                    } catch (ParseException e) {
                        System.err.println("Error al parsear la fecha para la línea: " + linea);
                    }
                    String docResultante = datos[11].trim();
                    if (!docResultante.equals("null")) {
                        expediente.setDocumentoResultante(docResultante);
                    }

                    RegistrarExpediente.agregar(expediente);
                } else {
                    System.err.println("Línea con formato incorrecto en el archivo: " + linea);
                }
            }
            System.out.println("Datos de expedientes cargados correctamente desde " + rutaArchivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo 'expedientes.txt' o ocurrió un error al leerlo.\nEl programa iniciará sin datos precargados.", "Advertencia de Carga", JOptionPane.WARNING_MESSAGE);
        }
    }
}



