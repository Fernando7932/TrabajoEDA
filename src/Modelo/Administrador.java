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
    private String usuario;
    private String contraseña;
    
    
    public Administrador() {
        
    }
    
    public Administrador(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    
    //Un Administrador puede crear un Expediente y Completar un Expediente
    public Expediente crearExpediente(int id, String prioridad, Interesado interesado, 
                                    String asunto, String documento) {
        return new Expediente(id, prioridad, interesado, asunto, documento);
    }

    public void completarExpediente(Expediente exp, String fechaFin) {
        exp.CompletarTramite(fechaFin);
    }
    
    
}
