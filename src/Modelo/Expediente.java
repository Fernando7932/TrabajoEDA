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
    private static int contadorID = 1;
    private int id;
    private String prioridad;
    private Interesado Interesado;
    private String Asunto;
    private String DocumentoReferencia;
    private String Finicio, Ffinal;
    private boolean Completado;
    private Documento DocumentoResultante;

    public int getId() {
        return id;
    }

    public Interesado getInteresado() {
        return Interesado;
    }

    public String getAsunto() {
        return Asunto;
    }

    public boolean isCompletado() {
        return Completado;
    }

    public Documento getDocumentoResultante() {
        return DocumentoResultante;
    }

    public String getFinicio() {
        return Finicio;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getFfinal() {
        return Ffinal;
    }

    public int getContadorID() {
        return contadorID;
    }


    public Expediente() {
    }

    public Expediente(String prioridad, Interesado Interesado, String Asunto, String DocumentoReferencia) {
        this.id = contadorID++;
        this.prioridad = prioridad;
        this.Interesado = Interesado;
        this.Asunto = Asunto;
        this.DocumentoReferencia = DocumentoReferencia;
        this.Finicio = "fecha_actual";
        this.Completado = false;
        this.DocumentoResultante = new Documento(this.Asunto,"a",this.Ffinal);
    }
    //nombre doc 1era letra ultima mas id
// ponwe fecha doc == fecha final
    //
    public void CompletarTramite(String Ffinal) {
        this.Ffinal = Ffinal;
        this.Completado = true;
    }

 
    public void mostrar() {
        System.out.println("Expediente{" + "id=" + id + ", prioridad=" + prioridad + ", Interesado=" + Interesado.toString() + ", Asunto=" + Asunto + ", DocumentoReferencia=" + DocumentoReferencia + ", Finicio=" + Finicio + ", Ffinal=" + Ffinal + ", Completado=" + Completado + ", DocumentoResultante=" + DocumentoResultante.toString() + '}');
    }
    
    
    
    
}
