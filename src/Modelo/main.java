/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
//PRUEBA
/**
 *
 * @author fernando
 */
public class main {
    public static void main(String[] args) {
        // 1. Crear administrador
        Administrador admin = new Administrador("admin", "admin123");
        
        // 2. Crear un interesado
        Interesado interesado = new Interesado("87654321", "María López", "987654321", "externo");
        
        // 3. Crear un expediente
        Expediente expediente = admin.crearExpediente(6, "Alta", interesado, 
                                                   "Solicitud de constancia de estudios", 
                                                   "DOC-SOL-2023-001");
        
        // 4. Mostrar información del expediente
        System.out.println("=== NUEVO EXPEDIENTE CREADO ===");
        System.out.println("ID: " + expediente.getId());
        System.out.println("Asunto: " + expediente.getAsunto());
        System.out.println("Interesado: " + interesado.getNombre() + " (DNI: " + interesado.getDni() + ")");
        System.out.println("Estado: " + (expediente.isCompletado() ? "COMPLETADO" : "EN TRÁMITE"));
        
        // 5. Proceso de trámite: agregar documentos resultantes
        System.out.println("\n=== PROCESO DE TRÁMITE ===");
        
        // Crear documentos
        Documento doc1 = new Documento("Constancia", "Constancia de estudios regulares 2023", "15/05/2023");
        Documento doc2 = new Documento("Resolución", "Resolución de aprobación de solicitud", "16/05/2023");
        
        // Agregar documentos al expediente usando tu Lista<T>
        expediente.getDocumentoResultante().agregar(doc1);
        expediente.getDocumentoResultante().agregar(doc2);
        
        // Mostrar documentos agregados
        System.out.println("Documentos generados:");
        expediente.getDocumentoResultante().mostrar();
        
        // 6. Completar el trámite
        admin.completarExpediente(expediente, "17/05/2023");
        
        // 7. Mostrar estado final
        System.out.println("\n=== TRÁMITE FINALIZADO ===");
        System.out.println("Fecha de finalización: " + expediente.getFfinal());
        System.out.println("Documentos resultantes:");
        
        // Mostrar cada documento con su información completa
        for (int i = 1; i <= expediente.getDocumentoResultante().longitud(); i++) {
            Documento doc = (Documento) expediente.getDocumentoResultante().iesimo(i);
            System.out.println((i) + ". " + doc.toString());
        }
        
        System.out.println("Total documentos: " + expediente.getDocumentoResultante().longitud());
    }
}