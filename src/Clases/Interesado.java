/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author YUSTIN
 */
public class Interesado {
    private int Dni,Telf;
    private String nombre,email;    
    private Doc Documento;  

    public int getDni() {
        return Dni;
    }

    public void setDni(int Dni) {
        this.Dni = Dni;
    }

    public int getTelf() {
        return Telf;
    }

    public void setTelf(int Telf) {
        this.Telf = Telf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Doc getDocumento() {
        return Documento;
    }

    public void setDocumento(Doc Documento) {
        this.Documento = Documento;
    }

    public Interesado() {
    }

    public Interesado(int Dni, int Telf, String nombre, String email, Doc Documento) {
        this.Dni = Dni;
        this.Telf = Telf;
        this.nombre = nombre;
        this.email = email;
        this.Documento = Documento; // Este doc lo puse por seaca , pero creo q es el q va en expediente, pero podemos hacer lo q ya hice de get noma :v
    }

    public void mostrar() {
        System.out.println("Dni: "+this.Dni);
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Telefono: "+this.Telf);
        System.out.println("Email: "+this.email);
        this.Documento.mostrar();   
    }
    
    
    
    
}
