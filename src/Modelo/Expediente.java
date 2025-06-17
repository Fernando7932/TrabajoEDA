/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import TDA.Fecha;
import java.util.Calendar;
/**
 *
 * @author YUSTIN
 */
public class Expediente {
    private String id;
    private String prioridad;
    private Interesado Interesado;
    private String Asunto;
    private String DocumentoReferencia;
    private String Finicio, Ffinal;
    private boolean Completado;

    public String getId() {
        return id;
    }

    public String getAsunto() {
        return Asunto;
    }

    public boolean isCompletado() {
        return Completado;
    }


    public Expediente() {
    }

    public Expediente(String id, String prioridad, Interesado Interesado, String Asunto, String DocumentoReferencia) {
        this.id = id;
        this.prioridad = prioridad;
        this.Interesado = Interesado;
        this.Asunto = Asunto;
        this.DocumentoReferencia = DocumentoReferencia;
        this.Finicio = "fecha_actual";
        this.Completado = false;
    }

    public void CompletarTramite(String Ffinal) {
        this.Ffinal = Ffinal;
        this.Completado = true;
    }
    
    
}
