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
 * Permite leer y distribuir los expedientes en las colas correspondientes según su dependencia y estado.
 */
public class CargadorDatos {

    /**
     * Carga expedientes desde un archivo de texto y los distribuye en las colas correspondientes.
     * El archivo debe tener el siguiente formato por línea:
     * dni;nombres;telefono;tipo;email;prioridad;asunto;documentoReferencia;estado;fechaInicio;fechaFinal;documentoResultante;dependencia
     * @param rutaArchivo Ruta absoluta o relativa del archivo .txt de entrada
     * @throws IOException Si ocurre un error al leer el archivo
     */
    public static void cargarExpedientesDesdeTxt(String rutaArchivo) {
        // Formato de fecha para interpretar las fechas del archivo
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        // Lee el archivo línea por línea
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Omitir líneas vacías
                if (linea.trim().isEmpty()) {
                    // Si la línea está vacía, saltar a la siguiente iteración
                    continue; 
                }

                // Divide la línea en campos usando el punto y coma como separador
                String[] datos = linea.split(";");
                // Si la línea tiene 13 campos, incluye la dependencia
                if (datos.length == 13) { // Incluye dependencia como campo 13
                    // Crea el objeto Interesado y el objeto Expediente usando los datos del archivo
                    Interesado interesado = new Interesado(datos[0].trim(), datos[1].trim(), datos[2].trim(), datos[3].trim(), datos[4].trim());
                    Expediente expediente = new Expediente(datos[5].trim(), interesado, datos[6].trim(), datos[7].trim());

                    // Cargar los datos adicionales usando setters
                    // Asigna el estado del expediente (1, 2 o 3)
                    expediente.setEstado(Integer.parseInt(datos[8].trim()));
                    // Intenta asignar las fechas de inicio y finalización si existen
                    try {
                        if (!datos[9].trim().equals("null")) expediente.setFechaInicio(sdf.parse(datos[9].trim()));
                        if (!datos[10].trim().equals("null")) expediente.setFechaFinal(sdf.parse(datos[10].trim()));
                    } catch (ParseException e) {
                        System.err.println("Error al parsear la fecha para la línea: " + linea);
                    }
                    // Asigna el documento resultante si existe
                    String docResultante = datos[11].trim();
                    if (!docResultante.equals("null")) {
                        expediente.setDocumentoResultante(docResultante);
                    }
                    // Asigna la dependencia leída del archivo
                    String dependencia = datos[12].trim();
                    expediente.Dependencia = dependencia;

                    // Distribuye el expediente en la cola correspondiente según la dependencia
                    if (dependencia.equalsIgnoreCase("Administrador") || dependencia.equalsIgnoreCase("En proceso de derivacion")) {
                        Modelo.Administrador.agregar(expediente);
                    } else if (dependencia.equalsIgnoreCase("Admision")) {
                        Modelo.Admision_Class.agregar(expediente);
                    } else if (dependencia.equalsIgnoreCase("Alumnos_Egresados")) {
                        Modelo.Alumnos_Egresados_class.agregar(expediente);
                    } else if (dependencia.equalsIgnoreCase("Matricula")) {
                        Modelo.Matricula_Class.agregar(expediente);
                    } else {
                        // Si la dependencia no es reconocida, agregar a la cola principal por defecto
                        Modelo.Administrador.agregar(expediente);
                    }
                } else {
                    // Si la línea no tiene el formato esperado, mostrar error en consola
                    System.err.println("Línea con formato incorrecto en el archivo: " + linea);
                }
            }
            System.out.println("Datos de expedientes cargados correctamente desde " + rutaArchivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo 'expedientes.txt' o ocurrió un error al leerlo.\nEl programa iniciará sin datos precargados.", "Advertencia de Carga", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}



