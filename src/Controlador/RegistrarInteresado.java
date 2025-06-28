/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import TDA.*;
import Modelo.*;

/**
 *
 * @author IAN
 */
public class RegistrarInteresado
{   //cambiar a statico
    public static ListaDoble<Interesado> Interesados;
    
    static  {
        Interesados = new ListaDoble<>();
    }
    
    public static void agregar(Interesado item){
        Interesados.agregar(item);
    }
    public static void mostrar(){
        Interesados.mostrar();
    }
    
    public static Interesado Busquedad(Interesado item){
        Interesado aux= new Interesado();
        aux=Interesados.iesimo(Interesados.ubicacion(item));
        return aux;
    }

}
    
    
   
