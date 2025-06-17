/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import TDA.Fecha;

/**
 *
 * @author YUSTIN
 */
public class test {public static void main(String[] args) {
        Fecha f = new Fecha(1,12,12);
        Fecha f1 = new Fecha(2,12,12);
        
        Doc dc= new Doc("ga");
        Interesado inte = new Interesado(1,159,"juan","yus",dc);
        Expediente expe = new Expediente(inte,74,1,"hola",f);
       expe.mostrar();
        expe.setFfinal(f);
        expe.mostrar();
        expe.getInteresado().getDocumento().setDocumento("boo");
        expe.mostrar();
    }
    
}
