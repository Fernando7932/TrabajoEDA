package Vista;

import Controlador.RegistrarExpediente;
import Modelo.Expediente;
import Modelo.Interesado;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Panel para consultar expedientes por DNI y ver sus detalles.
 *
 * @author fernando
 */
public class Consultar extends javax.swing.JPanel {

    private final DefaultTableModel model;

    /**
     * Crea un nuevo panel de consulta.
     */
    public Consultar() {
        initComponents();
        String[] columnas = {"ID", "DNI", "Nombre", "Prioridad", "Asunto"};
        model = new DefaultTableModel(columnas, 0);
        jTable1.setModel(model);
        
        
        //Para que funcione presionando enter
        txtBúsuqeda.addActionListener((ActionEvent e) -> {
            buscarExpedientePorDNI();
        });
    }

    /**
     * Busca un expediente por el DNI ingresado y lo muestra en la tabla.
     */
    private void buscarExpedientePorDNI() {
        String dni = txtBúsuqeda.getText().trim();
        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un DNI para buscar.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
         if(!dni.matches("\\d{8}")){
             JOptionPane.showMessageDialog(this, "Por favor, El DNI debe tener 8 digitos", "DNI invalido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Expediente expediente = RegistrarExpediente.BuscarExpediente(dni);
        model.setRowCount(0);

        if (expediente != null && expediente.getInteresado() != null) {
            Interesado interesado = expediente.getInteresado();
            model.addRow(new Object[]{
                expediente.getId(),
                interesado.getDni(),
                interesado.getNombre(),
                expediente.getPrioridad(),
                expediente.getAsunto()
            });
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún expediente con el DNI proporcionado.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBúsuqeda = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        bttnDetalles = new javax.swing.JButton();
        buscar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 410, 190));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Búsqueda por DNI");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, -1));
        jPanel1.add(txtBúsuqeda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 36, 130, 30));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 10, 70));

        bttnDetalles.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        bttnDetalles.setText("VER DETALLES");
        bttnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnDetallesActionPerformed(evt);
            }
        });
        jPanel1.add(bttnDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 10, 150, 60));

        buscar.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 40, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnDetallesActionPerformed
        // Obtener la fila seleccionada en la tabla (jTable1)
        int selectedRow = jTable1.getSelectedRow();

        // Verificar si no se ha seleccionado ninguna fila
        if (selectedRow == -1) {
            // Mostrar mensaje de advertencia si no hay selección
            JOptionPane.showMessageDialog(this,
                    "Por favor, seleccione un expediente de la tabla.",
                    "Sin selección",
                    JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si no hay fila seleccionada
        }

        // Obtener el DNI de la fila seleccionada (columna 1 del modelo)
        String dni = (String) model.getValueAt(selectedRow, 1);

        // Buscar el expediente correspondiente al DNI obtenido
        Expediente expediente = RegistrarExpediente.BuscarExpediente(dni);

        // Verificar si se encontró el expediente
        if (expediente != null) {
            // Obtener los datos del interesado asociado al expediente
            Interesado interesado = expediente.getInteresado();

            // Crear formateador de fecha (día/mes/año)
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            // Formatear fecha final (si existe) o mostrar "N/A" si es null
            String fechaFinal = (expediente.getFfinal() != null)
                    ? sdf.format(expediente.getFfinal())
                    : "N/A";

            // Obtener nombre del documento resultante o mensaje si no existe
            String docResultante = (expediente.getDocumentoResultante() != null)
                    ? expediente.getDocumentoResultante()
                    : "No generado aún.";

            // Convertir el código numérico del estado a texto legible
            String estado;
            estado = switch (expediente.getEstado()) {
                case 1 -> "Sin derivar";
                case 2 -> "En proceso";
                case 3 -> "Finalizado";
                default -> "Desconocido";
            };

            // Construir el mensaje con todos los detalles
            String detalles = "--- Detalles del Interesado ---\n"
                    + "DNI: " + interesado.getDni() + "\n"
                    + "Nombre: " + interesado.getNombre() + "\n"
                    + "Teléfono: " + interesado.getTelefono() + "\n"
                    + "Email: " + interesado.getEmail() + "\n"
                    + "Tipo: " + interesado.getTipo() + "\n\n"
                    + "--- Detalles del Expediente ---\n"
                    + "ID: " + expediente.getId() + "\n"
                    + "Asunto: " + expediente.getAsunto() + "\n"
                    + "Prioridad: " + expediente.getPrioridad() + "\n"
                    + "Estado: " + estado + "\n"
                    + "Fecha de Finalización: " + fechaFinal + "\n"
                    + "Documento de Referencia: " + expediente.getDocumentoReferencia() + "\n"
                    + "Documento Resultante: " + docResultante + "\n";

            // Mostrar el mensaje con todos los detalles en un cuadro de diálogo
            JOptionPane.showMessageDialog(this,
                    detalles,
                    "Detalles Completos del Expediente",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_bttnDetallesActionPerformed

    private void bttnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnBuscarActionPerformed
    }//GEN-LAST:event_bttnBuscarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        buscarExpedientePorDNI();
    }//GEN-LAST:event_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnDetalles;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBúsuqeda;
    // End of variables declaration//GEN-END:variables
}
