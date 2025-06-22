/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import TDA.*;
import Modelo.*;
/**
 *
 * @author YUSTIN
 */
public class Registro_Interesado<T> {
    private ListaDoble<Interesado> Interesados;
//lista doble//
    public Registro_Interesado() {
       Interesados= new ListaDoble<>();
    }
     public void agregar(Interesado objPersona){
        // agregar a la lista
       Interesados.agregar(objPersona);
    }
    public void Ubicacion(Interesado item){
        Interesados.ubicacion(item);
    }
}
