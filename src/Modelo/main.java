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
public class main {
    public static void main(String[] args) {
        // 1. Crear administrador
        Administrador admin = new Administrador("Admin", "1234");
        
        
        // 2. Crear un interesado
        Interesado interesado = new Interesado("12345678", "Ana Pérez", "987654321", "ULIMA");
        
        // 3. Crear un expediente
        Expediente exp = admin.crearExpediente("EXP-001", "ALTA", interesado, 
                                             "Solicitud de certificado", "DOC-123.pdf");
        
        // 4. Mostrar información del expediente
        System.out.println("=== Expediente creado ===");
        System.out.println("ID: " + exp.getId());
        System.out.println("Asunto: " + exp.getAsunto());
        System.out.println("Interesado: " + interesado.getNombre());
        System.out.println("Estado: " + (exp.isCompletado() ? "Completado" : "En trámite"));
        
        // 5. Completar el trámite
        admin.completarExpediente(exp, "fecha_finalizacion");
        
        // 6. Mostrar estado final
        System.out.println("\n=== Trámite completado ===");
        System.out.println("Estado: " + (exp.isCompletado() ? "Completado" : "En trámite"));
    }
}
