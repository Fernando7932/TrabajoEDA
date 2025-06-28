/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author fernando
 */
public class Documento {
    private String tipo;         // Ej: "Certificado", "Resolución", "Constancia"
    private String nombreDoc;  // Ej: "Certificado de estudios completos 2023"
    private String fecha;        // Formato simple: "dd/mm/aaaa"

    public Documento() {
    }
    
    
    public Documento(String tipo, String nombreDoc, String fecha) {
        this.tipo = tipo;
        this.nombreDoc = nombreDoc;
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return tipo  + nombreDoc  + fecha ;
    }
}