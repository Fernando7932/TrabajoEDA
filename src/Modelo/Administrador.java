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
public class Administrador {
    public static String usuario;
    public static  String contraseña;

    public static String getUsuario() {
        return usuario;
    }

    public static String getContraseña() {
        return contraseña;
    }


    
    //Un Administrador puede crear un Expediente y Completar un Expediente
    public static Expediente crearExpediente(String prioridad, Interesado interesado, 
                                    String asunto, String documento) {
        return new Expediente(prioridad, interesado, asunto, documento);
    }

    public static void completarExpediente(Expediente exp, String fechaFin) {
        exp.CompletarTramite(fechaFin);
    }
    
    
}
