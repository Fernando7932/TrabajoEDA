/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author YUSTIN
 */
public class Doc {
    private String Documento;

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public Doc() {
    }

    public Doc(String Documento) {
        this.Documento = Documento;
    }

    public void mostrar() {
        System.out.println("Tipo de documento: "+ Documento);
    }
    
    
    
}
