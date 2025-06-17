/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import TDA.Fecha;
import java.util.Calendar;
/**
 *
 * @author YUSTIN
 */
public class Expediente {
    private Interesado Interesado;
    private int Id,Prioridad;
    private String Asunto;
    private Fecha Finicio,Ffinal;
    private Doc Documento;

    public Interesado getInteresado() {
        return Interesado;
    }

    public Doc getDocumento() {
        return Documento;
    }

    public void setDocumento(Doc Documento) {
        this.Documento = Documento;
    }

    public void setInteresado(Interesado Interesado) {
        this.Interesado = Interesado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getPrioridad() {
        return Prioridad;
    }

    public void setPrioridad(int Prioridad) {
        this.Prioridad = Prioridad;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    public Fecha getFinicio() {
        return Finicio;
    }

    public void setFinicio(Fecha Finicio) {
        this.Finicio = Finicio;
    }

    public Fecha getFfinal() {
        return Ffinal;
    }

    public void setFfinal(Fecha Ffinal) {
        this.Ffinal = Ffinal;
    }

    public Expediente() {
    }

    public Expediente(Interesado Interesado, int Id, int Prioridad, String Asunto, Fecha Finicio) {
        this.Interesado = Interesado;
        this.Id = Id;
        this.Prioridad = Prioridad;
        this.Asunto = Asunto;
        this.Finicio = Finicio;
        this.Ffinal=null;
        this.Documento=this.Interesado.getDocumento(); // me olvide q doc iba aca
    }
public void mostrar(){
    this.Interesado.mostrar();
    System.out.println("Id: "+this.Id);
    System.out.println("Prioridad: "+this.Prioridad);
    System.out.println("Asunto: "+this.Asunto);
    System.out.println("Fecha de Inicio: "+this.Finicio);
    System.out.println("Fecha de Finalizacion: "+this.Ffinal);
}    
    
    
}
