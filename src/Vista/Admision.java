/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;
import Controlador.RegistrarExpediente;
import Modelo.Administrador;
import Modelo.Admision_Class;
import Modelo.Expediente;
import Modelo.Interesado;
import TDA.Cola;
import static Vista.MenuPrincipal.content;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fazef
 */
public class Admision extends javax.swing.JPanel {

    Border default_border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(153, 153, 153));
    Border red_border = BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED);
    JButton[] buttons;
    
    private final DefaultTableModel model;

    public Admision() {
        initComponents();
        String[] columnas = {"ID", "DNI", "Nombre", "Prioridad", "Asunto", "F. Final"};
        model = new DefaultTableModel(columnas, 0);
        jTableAdmin.setModel(model);
        mostrarPorPrioridad(true);
        
        buttons = new JButton[3];
        buttons[0] = bttnAdmision;
        buttons[1] = bttnAlumEgre;
        buttons[2] = bttnMatricula;
        


        //Aplicar el mismo formato de borde a todos los botones
        for (JButton button : buttons) {
            button.setBorder(default_border);
        }

        addAction(); //Cargar el metodo para la interacción con los botones.
    }
    public void mostrarPorPrioridad(boolean enProceso) {
        DefaultTableModel modelo = (DefaultTableModel) jTableAdmin.getModel();
        modelo.setRowCount(0);

        Cola<Expediente> original = Admision_Class.ExpedientesAdmision;
        Cola<Expediente> temp = new Cola<>();
        Cola<Expediente> alta = new Cola<>();
        Cola<Expediente> media = new Cola<>();
        Cola<Expediente> baja = new Cola<>();

        int estadoFiltrar = enProceso ? 2 : 1;

        while (!original.esVacia()) {
            Expediente e = original.desencolar();
            if (e.getEstado() == estadoFiltrar) {
                switch (e.getPrioridad()) {
                    case "Alta":
                        alta.encolar(e);
                        break;
                    case "Media":
                        media.encolar(e);
                        break;
                    case "Baja":
                        baja.encolar(e);
                        break;
                }
            }
            temp.encolar(e);
        }

        while (!temp.esVacia()) {
            original.encolar(temp.desencolar());
        }

        agregarColaATabla(alta, modelo);
        agregarColaATabla(media, modelo);
        agregarColaATabla(baja, modelo);
    }

    private void agregarColaATabla(Cola<Expediente> cola, DefaultTableModel modelo) {
        Cola<Expediente> temp = new Cola<>();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        while (!cola.esVacia()) {
            Expediente e = cola.desencolar();
            Interesado i = e.getInteresado();
            String fechaFinal = (e.getFfinal() != null) ? sdf.format(e.getFfinal()) : "N/A";

            modelo.addRow(new Object[]{
                e.getId(),
                i.getDni(),
                i.getNombre(),
                e.getPrioridad(),
                e.getAsunto(),
                fechaFinal
            });
            temp.encolar(e);
        }
        // Restaurar la cola original
        while (!temp.esVacia()) {
            cola.encolar(temp.desencolar());
        }
    }
        private void buscarExpedientePorDNI() {
        String dni = txtBuscar.getText().trim();
        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un DNI para buscar.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
         if(!dni.matches("\\d{8}")){
             JOptionPane.showMessageDialog(this, "Por favor, El DNI debe tener 8 digitos", "DNI invalido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Expediente expediente = Admision_Class.BuscarExpediente(dni);
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

    public void setButtonBorder(JButton button) {
        for (JButton btn : buttons) {
            //Volver todos los botones al color y formato inicial
            btn.setBorder(default_border);
            btn.setForeground(new Color(153, 153, 153));

        }

        // Borde rojo para el boton seleccionado
        button.setBorder(red_border);
        button.setForeground(Color.black);
    }

    public void addAction() {
        for (JButton button : buttons) {
            button.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    //Cuando el puntero presiona el botton el borde se pone rojo nuevamente.
                    setButtonBorder(button);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    //Cuando el mouse pase encima del boton se pondra el borde rojo
                    button.setBorder(red_border);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    //Cuando el puntero salga del rango del boton el borde se pondrá normal.
                    button.setBorder(default_border);
                }
            });
        }
    }

    private void ShowJPanel(JPanel p) {
        /* Muestra el contenido del Jpanel p para que se muestre en content. */
        p.setSize(430, 280);
        p.setLocation(0, 0);

        content.removeAll();
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAD = new javax.swing.JPanel();
        bttnMatricula = new javax.swing.JButton();
        bttnAlumEgre = new javax.swing.JButton();
        bttnAdmision = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAdmin = new javax.swing.JTable();
        bttnDerivar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bttnBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        jPanelAD.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bttnMatricula.setText("Matricula");
        bttnMatricula.setBorder(null);
        bttnMatricula.setContentAreaFilled(false);
        bttnMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnMatriculaActionPerformed(evt);
            }
        });
        jPanelAD.add(bttnMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 100, 30));

        bttnAlumEgre.setText("Alumnos / Egresados");
        bttnAlumEgre.setBorder(null);
        bttnAlumEgre.setContentAreaFilled(false);
        bttnAlumEgre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAlumEgreActionPerformed(evt);
            }
        });
        jPanelAD.add(bttnAlumEgre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 130, 30));

        bttnAdmision.setText("Admision");
        bttnAdmision.setBorder(null);
        bttnAdmision.setContentAreaFilled(false);
        bttnAdmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAdmisionActionPerformed(evt);
            }
        });
        jPanelAD.add(bttnAdmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 100, 30));

        jTableAdmin.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableAdmin.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTableAdmin);

        jPanelAD.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 410, 170));

        bttnDerivar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bttnDerivar.setText("DERIVAR");
        bttnDerivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnDerivarActionPerformed(evt);
            }
        });
        jPanelAD.add(bttnDerivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 160, 30));
        jPanelAD.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 30));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel2.setText("Búsqueda por DNI");
        jPanelAD.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, -1));

        bttnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bttnBuscar.setText("BUSCAR");
        bttnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnBuscarActionPerformed(evt);
            }
        });
        jPanelAD.add(bttnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanelAD.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 20, 40));

        jLabel1.setText("Prueba - ad");
        jPanelAD.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAD, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAD, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnMatriculaActionPerformed
        // TODO add your handling code here:
        ShowJPanel(new Matricula());
    }//GEN-LAST:event_bttnMatriculaActionPerformed

    private void bttnAlumEgreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAlumEgreActionPerformed
        // TODO add your handling code here:
        ShowJPanel(new Alumnos_Egresados());
        
    }//GEN-LAST:event_bttnAlumEgreActionPerformed

    private void bttnAdmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAdmisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bttnAdmisionActionPerformed

    private void bttnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnBuscarActionPerformed
buscarExpedientePorDNI();        // TODO add your handling code here:
    }//GEN-LAST:event_bttnBuscarActionPerformed

    private void bttnDerivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnDerivarActionPerformed
 int filaSeleccionada = jTableAdmin.getSelectedRow();
  int columnaselecionada= 2;
        if (filaSeleccionada == -1) {
            // No hay fila seleccionada
            JOptionPane.showMessageDialog(this, "Seleccione una fila antes de derivar.");
            return;
        }
                String[] opciones = {"Alumnos y Egresados", "Matricula","Cola Principal"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        int opcion = JOptionPane.showConfirmDialog(
                this,
                comboBox,
                "¿A dónde deseas derivar?",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (opcion == JOptionPane.OK_OPTION) {
            String dependencia = (String) comboBox.getSelectedItem();
            String obj=(String) jTableAdmin.getValueAt(filaSeleccionada, columnaselecionada);
            Expediente exp=Admision_Class.BuscarExpediente(obj);
            Administrador.derivarExpediente(exp,dependencia);
            System.out.println("Destino seleccionado: " + dependencia);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_bttnDerivarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnAdmision;
    private javax.swing.JButton bttnAlumEgre;
    private javax.swing.JButton bttnBuscar;
    private javax.swing.JButton bttnDerivar;
    private javax.swing.JButton bttnMatricula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelAD;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableAdmin;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
