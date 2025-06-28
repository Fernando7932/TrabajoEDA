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
    private ListaDoble<Interesado> Interesados;
    
    public int ubicacion (Interesado pos) //verificar
    {
    return Interesados.ubicacion(pos); //verificar
    }
    
    public void agregar(Interesado item)
    {
        Interesados.agregar(item);
    }
    
    
    public void eliminarInteresado(int pos)
    {
        Interesados.eliminar(pos);
    }
    
    public void mostrarInteresados() {
    Interesados.mostrar();
    }
}
    
    
   
