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
    private String descripcion;  // Ej: "Certificado de estudios completos 2023"
    private String fecha;        // Formato simple: "dd/mm/aaaa"

    public Documento(String tipo, String descripcion, String fecha) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }


    public String mostrar() {
        return tipo + ": " + descripcion + " (" + fecha + ")";
    }
}