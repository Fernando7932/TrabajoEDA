/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author YUSTIN
 */
public class Dependencia {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dependencia() {
    }

    public Dependencia(String nombre) {
        this.nombre = nombre;
    }
    public void mostrar(){
        System.out.println("Nombre de la dependencia a derivar: "+nombre);
    }
    
}
