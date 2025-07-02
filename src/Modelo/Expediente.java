/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Representa un expediente dentro del sistema de trámite documentario. Contiene
 * información sobre el interesado, asunto, fechas y estado del trámite.
 *
 * @author YUSTIN
 */
public class Expediente {

    private static int contadorID = 1;
    private int id;
    private String prioridad;
    private Interesado interesado;
    private String asunto;
    private String documentoReferencia;
    private Date fechaInicio, fechaFinal;
    private int estado; // 1: Sin derivar, 2: En proceso, 3: Finalizado
    private String documentoResultante;
    public String Dependencia;

    /**
     * Constructor por defecto.
     */
    public Expediente() {
    }

    /**
     * Constructor para crear un nuevo expediente.
     *
     * @param prioridad La prioridad del expediente (Alta, Media, Baja).
     * @param interesado El interesado que registra el expediente.
     * @param asunto El motivo del trámite.
     * @param documentoReferencia Documento adjunto como referencia.
     */
    public Expediente(String prioridad, Interesado interesado, String asunto, String documentoReferencia) {
        this.id = contadorID++;
        this.prioridad = prioridad;
        this.interesado = interesado;
        this.asunto = asunto;
        this.documentoReferencia = documentoReferencia;
        this.fechaInicio = new Date();
        this.fechaFinal = calcularFechaFinal(this.fechaInicio, this.asunto);
        this.estado = 1;
        this.documentoResultante = null; // Se genera al finalizar
        this.Dependencia="En proceso de derivacion";
    }

    // --- Getters y Setters ---
    public int getId() {
        return id;
    }

    public String getDependencia() {
        return Dependencia;
    }

    public void setDependencia(String Dependencia) {
        this.Dependencia = Dependencia;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public String getAsunto() {
        return asunto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDocumentoResultante() {
        return documentoResultante;
    }

    public Date getFinicio() {
        return fechaInicio;
    }

    public void setDocumentoResultante(String documentoResultante) {
        this.documentoResultante = documentoResultante;
    }

    public void setFinicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public Date getFfinal() {
        return fechaFinal;
    }

    public void setFfinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getDocumentoReferencia() {
        return documentoReferencia;
    }

    /**
     * Calcula la fecha de finalización estimada del expediente.
     *
     * @param fechaInicio La fecha en que se inicia el trámite.
     * @param asunto El tipo de asunto para determinar los días de plazo.
     * @return La fecha de finalización calculada.
     */
    private Date calcularFechaFinal(Date fechaInicio, String asunto) {
        // 1. Crear un objeto Calendar (para manipular fechas fácilmente)
        Calendar calendar = Calendar.getInstance();

        // 2. Establecer la fecha de inicio en el Calendar
        calendar.setTime(fechaInicio);

        // 3. Establecer un plazo por defecto de 2 días
        int diasASumar = 2;

        // 4. Verificar el tipo de asunto para ajustar el plazo
        if (asunto.equalsIgnoreCase("Constancia de Rendimiento Academico")) {
            diasASumar = 3; // Si es una constancia de rendimiento, se dan 3 días
        } else if (asunto.equalsIgnoreCase("Constacia de Egresados")) {
            diasASumar = 4; // Si es una constancia de egresados, se dan 4 días
        }

        // 5. Sumar los días calculados a la fecha inicial
        calendar.add(Calendar.DAY_OF_YEAR, diasASumar);

        // 6. Devolver la nueva fecha calculada
        return calendar.getTime();
    }

    /**
     * Genera el nombre del documento resultante.
     *
     * @return El nombre del documento con formato: (primer caracter
     * asunto)(último caracter asunto)(últimos 2 dígitos DNI).pdf
     */
    private String generarNombreDocumentoResultante() {
        char primerCaracter = this.asunto.charAt(0);
        char ultimoCaracter = this.asunto.charAt(this.asunto.length() - 1);
        String dni = this.interesado.getDni();
        String ultimosDosDigitosDNI = dni.substring(dni.length() - 2);
        return "" + primerCaracter + ultimoCaracter + ultimosDosDigitosDNI + Expediente.contadorID + ".pdf";
    }

    /**
     * Cambia el estado del expediente a "En proceso".
     */
    public void derivarTramite() {
        this.estado = 2;
    }

    /**
     * Cambia el estado del expediente a "Finalizado" y genera el documento
     * resultante.
     */
    public void completarTramite() {
        this.estado = 3;
        this.documentoResultante = generarNombreDocumentoResultante();
    }

    /**
     * Muestra la información del expediente en la consola.
     */
    public void mostrar() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaInicioStr = (fechaInicio != null) ? sdf.format(fechaInicio) : "N/A";
        String fechaFinalStr = (fechaFinal != null) ? sdf.format(fechaFinal) : "N/A";
        String docResultanteStr = (documentoResultante != null) ? documentoResultante.toString() : "No generado";
        System.out.println("Expediente{" + "id=" + id + ", prioridad=" + prioridad + ", Interesado=" + interesado.toString() + ", Asunto=" + asunto + ", DocumentoReferencia=" + documentoReferencia + ", Finicio=" + fechaInicioStr + ", Ffinal=" + fechaFinalStr + ", Estado=" + estado + ", DocumentoResultante=" + docResultanteStr + '}');
    }
}
