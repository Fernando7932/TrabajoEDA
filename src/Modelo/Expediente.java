/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import TDA.Lista;
/**
 *
 * @author YUSTIN
 */
public class Expediente {
    private int id;
    private String prioridad;
    private Interesado Interesado;
    private String Asunto;
    private String DocumentoReferencia;
    private String Finicio, Ffinal;
    private boolean Completado;
    private Lista<Documento> DocumentoResultante;

    public int getId() {
        return id;
    }

    public String getAsunto() {
        return Asunto;
    }

    public boolean isCompletado() {
        return Completado;
    }

    public Lista<Documento> getDocumentoResultante() {
        return DocumentoResultante;
    }

    public String getFinicio() {
        return Finicio;
    }

    public String getFfinal() {
        return Ffinal;
    }
    
    


    public Expediente() {
    }

    public Expediente(int id, String prioridad, Interesado Interesado, String Asunto, String DocumentoReferencia) {
        this.id = id;
        this.prioridad = prioridad;
        this.Interesado = Interesado;
        this.Asunto = Asunto;
        this.DocumentoReferencia = DocumentoReferencia;
        this.Finicio = "fecha_actual";
        this.Completado = false;
        this.DocumentoResultante = new Lista<>();
    }

    public void CompletarTramite(String Ffinal) {
        this.Ffinal = Ffinal;
        this.Completado = true;
    }
    
    
}
