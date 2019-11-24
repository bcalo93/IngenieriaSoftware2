/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Adoptante;
import dominio.Mascota;
import dominio.Sistema;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import logicanegocio.LogicaMascota;

class PanelAdopcion extends javax.swing.JPanel {
    
    public PanelAdopcion() {
        initComponents(); 
        this.modeloComboMascotasParaAdoptar = new DefaultComboBoxModel<>();
        this.comboMascotasParaAdoptar.setModel(modeloComboMascotasParaAdoptar);        
    }

    PanelAdopcion(Sistema sistema, int width, int height) {
        this();        
        this.sistema = sistema;
        this.logicaMascota = new LogicaMascota(sistema); 
        this.setSize(width, height-100); 
        this.setListaMascotas();
        this.errorTxt.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboMascotasParaAdoptar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        lbTenefono = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        txApellido = new javax.swing.JTextField();
        txTelefono = new javax.swing.JTextField();
        btCancelar = new javax.swing.JButton();
        btAdoptar = new javax.swing.JButton();
        mascotaFoto = new javax.swing.JLabel();
        errorTxt = new javax.swing.JLabel();

        comboMascotasParaAdoptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMascotasParaAdoptarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Mascotas disponibles para adopción:");

        lbNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbNombre.setText("Nombre:");

        lbApellido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbApellido.setText("Apellido:");

        lbTenefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbTenefono.setText("Telefono:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Adopotante");

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btAdoptar.setText("Adoptar");
        btAdoptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdoptarActionPerformed(evt);
            }
        });

        errorTxt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        errorTxt.setText("Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboMascotasParaAdoptar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(mascotaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(140, 140, 140))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNombre)
                                    .addComponent(lbApellido)
                                    .addComponent(lbTenefono))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                    .addComponent(txApellido)
                                    .addComponent(txTelefono))
                                .addGap(40, 40, 40))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(errorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAdoptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mascotaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNombre, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(comboMascotasParaAdoptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbApellido, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTenefono, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(errorTxt)
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAdoptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btAdoptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdoptarActionPerformed
        if(this.txNombre.getText().equals("")){
            this.errorTxt.setText("El nombre del adoptante no puede estar vacío");
            this.errorTxt.setVisible(true);
        }
        else if(this.txApellido.getText().equals("")){
            this.errorTxt.setText("El apellido del adoptante no puede estar vacío");
             this.errorTxt.setVisible(true);
        }
        else if(this.txTelefono.getText().equals("")){
            this.errorTxt.setText("El telefono del adoptante no puede estar vacío");
             this.errorTxt.setVisible(true);
        }
        else if(this.comboMascotasParaAdoptar.getItemCount() == 0){
            this.errorTxt.setText("No hay mascotas para adoptar, ingrese una");
            this.errorTxt.setVisible(true);
        }
        else {
            Mascota mascota = this.logicaMascota.getMascotaPorNombre(this.comboMascotasParaAdoptar.getSelectedItem().toString());
            this.adoptante = new Adoptante(this.txNombre.toString(), this.txApellido.toString(), this.txTelefono.toString(), mascota);
            mascota.setEstado("adoptado");
            limpiarFormulario();
        }
        
    }//GEN-LAST:event_btAdoptarActionPerformed

    private void limpiarFormulario(){
        this.txNombre.setText("");
        this.txApellido.setText("");
        this.txTelefono.setText("");
        this.errorTxt.setText("");
        actualizarListaMascotas();
    }
    
    private void comboMascotasParaAdoptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMascotasParaAdoptarActionPerformed
        if(modeloComboMascotasParaAdoptar.getSize() >0){
            Mascota mascotaSeleccionada = logicaMascota.getMascotaPorNombre(comboMascotasParaAdoptar.getSelectedItem().toString());
            mascotaFoto.setIcon(mascotaSeleccionada.getFoto());
        }
    }//GEN-LAST:event_comboMascotasParaAdoptarActionPerformed

    private void setListaMascotas() {         
        this.modeloComboMascotasParaAdoptar.removeAllElements();
        this.logicaMascota.getMascotasParaAdoptar()
                .forEach(mascota -> {
                    this.modeloComboMascotasParaAdoptar.addElement(mascota.getNombre());
                });
    }
     
    public void actualizarListaMascotas(){
        setListaMascotas();
    }
    
    private Sistema sistema;
    private LogicaMascota logicaMascota;
    private DefaultComboBoxModel<String> modeloComboMascotasParaAdoptar;
    private Adoptante adoptante;
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdoptar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JComboBox<String> comboMascotasParaAdoptar;
    private javax.swing.JLabel errorTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbTenefono;
    private javax.swing.JLabel mascotaFoto;
    private javax.swing.JTextField txApellido;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txTelefono;
    // End of variables declaration//GEN-END:variables
}
