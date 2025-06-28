/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author YUSTIN
 */
public class Interesado {
    private String dni,nombres,telefono,tipo,email;

    
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombres;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public String getTipo() {
        return tipo;
    }

    public String getEmail(){
        return email;
    }
    public Interesado() {
    }

    public Interesado(String dni, String nombre, String telefono, String tipo, String email) {
        this.dni = dni;
        this.nombres = nombre;
        this.telefono = telefono;
        this.tipo = tipo;
        this.email = email;
    }

   
    public void mostrar() {
        System.out.println( "Interesado{" + "dni=" + dni + ", nombres=" + nombres + ", telefono=" + telefono + ", tipo=" + tipo + ", email=" + email + '}');
    }
    
    @Override
    public String toString() {
        return "Interesado{" + "dni=" + dni + ", nombres=" + nombres + ", telefono=" + telefono + ", tipo=" + tipo + ", email=" + email + '}';
    }
    
}
