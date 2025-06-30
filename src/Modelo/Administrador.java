 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Clase de utilidad para las acciones que puede realizar un administrador.
 * @author fernando
 */
public class Administrador {
    public static String usuario;
    public static String contraseña;

    public static String getUsuario() {
        return usuario;
    }

    public static String getContraseña() {
        return contraseña;
    }

    /**
     * Crea una nueva instancia de Expediente.
     * @param prioridad La prioridad del expediente.
     * @param interesado El interesado que inicia el trámite.
     * @param asunto El asunto del expediente.
     * @param documento El documento de referencia.
     * @return Un nuevo objeto Expediente.
     */
    public static Expediente crearExpediente(String prioridad, Interesado interesado,
                                    String asunto, String documento) {
        return new Expediente(prioridad, interesado, asunto, documento);
    }
    
    /**
     * Deriva un expediente, cambiando su estado a "En proceso".
     * @param exp El expediente a derivar.
     */
    public static void derivarExpediente(Expediente exp) {
        exp.derivarTramite();
    }

    /**
     * Completa un expediente, cambiando su estado a "Finalizado".
     * @param exp El expediente a completar.
     */
    public static void completarExpediente(Expediente exp) {
        exp.completarTramite();
    }
    
    
}
