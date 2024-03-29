package interfaz;

import dominio.Donacion;
import dominio.FrecuenciaDonacion;
import dominio.Mascota;
import dominio.MedioDonacion;
import dominio.Padrino;
import dominio.Sistema;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import logicanegocio.LogicaMascota;
import logicanegocio.LogicaPadrino;
import logicanegocio.excepciones.LogicaNegocioException;

public class PanelEditarPadrino extends javax.swing.JPanel implements Observer {
    
    public PanelEditarPadrino() {
        initComponents();
        this.lblError.setVisible(false);
        this.modeloComboMascotas = new DefaultComboBoxModel<>();
        this.comboMascotas.setModel(modeloComboMascotas);
        this.modeloListaMascotas = new DefaultListModel<>();
        this.listAnimalesAgregados.setModel(this.modeloListaMascotas);
    }
    
    public PanelEditarPadrino(Sistema sistema) {
        this();
        this.sistema = sistema;
        this.logicaMascota = new LogicaMascota(sistema);
        this.logicaPadrino = new LogicaPadrino(sistema);
        this.sistema.addObserver(this);
    }
    
    public PanelEditarPadrino(Sistema sistema, PanelPadrino panelPadrino) {
        this(sistema);
        this.contenedor = panelPadrino;
        this.setSize(this.contenedor.getWidth(), this.contenedor.getHeight());
        this.padrino = new Padrino();
        this.setComboAnimales();
        this.setListaAnimalesAgregados();
    }
    
    public void mostrar() {
        this.padrino = new Padrino();
        this.limpiarFormulario();
        this.setVisible(true);
    }
    
    public void mostrar(Padrino padrino) {
        this.padrino = new Padrino(padrino);
        this.txNombre.setText(this.padrino.getNombre());
        this.txApellido.setText(this.padrino.getApellido());
        this.txMail.setText(this.padrino.getMail());
        this.txCiudad.setText(this.padrino.getCiudad());
        this.txPais.setText(this.padrino.getPais());
        this.txTelefono.setText(this.padrino.getTelefono());
        
        Donacion donacion = this.padrino.getDonacion();
        this.spMontoDonacion.setValue(donacion.getMontoDonacion());
        this.comboMonedaDonacion.setSelectedItem(donacion.getMoneda());
        this.comboFrecuenciaDonacion.setSelectedItem(donacion.getFrecuencia().toString());
        this.comboMedioDonacion.setSelectedItem(donacion.getMedio().toString());
        this.setVisible(true);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        this.setComboAnimales();
    }
    
    private void limpiarFormulario() {
        this.txNombre.setText("");
        this.txApellido.setText("");
        this.txMail.setText("");
        this.txCiudad.setText("");
        this.txPais.setText("");
        this.txTelefono.setText("");
        
        this.spMontoDonacion.setValue(0);
        this.comboMonedaDonacion.setSelectedItem("");
        this.comboFrecuenciaDonacion.setSelectedIndex(0);
        this.comboMedioDonacion.setSelectedIndex(0);
        this.modeloListaMascotas.removeAllElements();
        this.setComboAnimales();
    }
    
    private void setComboAnimales() {
        this.modeloComboMascotas.removeAllElements();
        this.logicaMascota.getMascotasExcluyendo(this.padrino.getQuiereApadrinar())
                .forEach(mascota -> {
                    this.modeloComboMascotas.addElement(mascota);
                });
    }
    
    private void setListaAnimalesAgregados() {
        this.modeloListaMascotas.removeAllElements();
        this.padrino.getQuiereApadrinar().forEach(
                mascota -> this.modeloListaMascotas.addElement(mascota)
        );
    }
    
    private FrecuenciaDonacion getComoFrecuenciaDonacion() {
        String frecuencia = (String)this.comboFrecuenciaDonacion.getSelectedItem();
        if (frecuencia == null || frecuencia.equals("Una vez")) {
            return FrecuenciaDonacion.UNA_VEZ;
        } else if (frecuencia.equals("Mensual")) {
            return FrecuenciaDonacion.MENSUAL;
        } else if (frecuencia.equals("Trimestral")) {
            return FrecuenciaDonacion.TRIMESTRAL;
        } else {
            return FrecuenciaDonacion.ANUAL;
        }
    }
    
    private MedioDonacion getComoMedioDonacion() {
        String medio = (String)this.comboMedioDonacion.getSelectedItem();
        if(medio == null || medio.equals("Tarjeta de Credito")) {
            return MedioDonacion.TARJETA_CREDITO;
        } else {
            return MedioDonacion.TRANSFERENCIA_BANCARIA;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDonaciones = new javax.swing.JPanel();
        lblDonacion = new javax.swing.JLabel();
        lbMonto = new javax.swing.JLabel();
        spMontoDonacion = new javax.swing.JSpinner();
        lbMonedaDonacion = new javax.swing.JLabel();
        comboMonedaDonacion = new javax.swing.JComboBox<>();
        lbFrecuenciaDonacion = new javax.swing.JLabel();
        comboFrecuenciaDonacion = new javax.swing.JComboBox<>();
        comboMedioDonacion = new javax.swing.JComboBox<>();
        lbMedioDonacion = new javax.swing.JLabel();
        pnInfoBasicaPadrino = new javax.swing.JPanel();
        lbInfoBasicaPadrino = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        lbNombre = new javax.swing.JLabel();
        txApellido = new javax.swing.JTextField();
        lbApellido = new javax.swing.JLabel();
        txTelefono = new javax.swing.JTextField();
        lbTelefono = new javax.swing.JLabel();
        txMail = new javax.swing.JTextField();
        lbMail = new javax.swing.JLabel();
        txCiudad = new javax.swing.JTextField();
        lbCiudad = new javax.swing.JLabel();
        txPais = new javax.swing.JTextField();
        lbPais = new javax.swing.JLabel();
        comboMascotas = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        lbAnimales = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAnimalesAgregados = new javax.swing.JList<>();
        btnSacarMascota = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        lblDonacion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDonacion.setText("Donacion");

        lbMonto.setText("Monto:");

        lbMonedaDonacion.setText("Moneda:");

        comboMonedaDonacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "U$", "US$" }));

        lbFrecuenciaDonacion.setText("Frecuencia:");

        comboFrecuenciaDonacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Una vez", "Mensual", "Trimestral", "Anual" }));

        comboMedioDonacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarjeta de Credito", "Transferencia Bancaria" }));

        lbMedioDonacion.setText("Medio Donacion:");

        javax.swing.GroupLayout panelDonacionesLayout = new javax.swing.GroupLayout(panelDonaciones);
        panelDonaciones.setLayout(panelDonacionesLayout);
        panelDonacionesLayout.setHorizontalGroup(
            panelDonacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDonacionesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelDonacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDonacionesLayout.createSequentialGroup()
                        .addGroup(panelDonacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbFrecuenciaDonacion)
                            .addComponent(lbMedioDonacion)
                            .addComponent(lbMonedaDonacion)
                            .addComponent(lbMonto))
                        .addGap(18, 18, 18)
                        .addGroup(panelDonacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spMontoDonacion)
                            .addComponent(comboMonedaDonacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboFrecuenciaDonacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboMedioDonacion, 0, 217, Short.MAX_VALUE)))
                    .addComponent(lblDonacion))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        panelDonacionesLayout.setVerticalGroup(
            panelDonacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDonacionesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblDonacion)
                .addGap(18, 18, 18)
                .addGroup(panelDonacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMonto)
                    .addComponent(spMontoDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDonacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMonedaDonacion)
                    .addComponent(comboMonedaDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDonacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboFrecuenciaDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFrecuenciaDonacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDonacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMedioDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMedioDonacion))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        lbInfoBasicaPadrino.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbInfoBasicaPadrino.setText("Informacion Basica");

        lbNombre.setText("Nombre:");

        lbApellido.setText("Apellido:");

        lbTelefono.setText("Telefono:");

        lbMail.setText("Correo:");

        lbCiudad.setText("Ciudad:");

        lbPais.setText("Pais:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lbAnimales.setText("Animales:");

        jScrollPane1.setViewportView(listAnimalesAgregados);

        btnSacarMascota.setText("Quitar");
        btnSacarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacarMascotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnInfoBasicaPadrinoLayout = new javax.swing.GroupLayout(pnInfoBasicaPadrino);
        pnInfoBasicaPadrino.setLayout(pnInfoBasicaPadrinoLayout);
        pnInfoBasicaPadrinoLayout.setHorizontalGroup(
            pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoBasicaPadrinoLayout.createSequentialGroup()
                .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInfoBasicaPadrinoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbInfoBasicaPadrino)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnInfoBasicaPadrinoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbNombre)
                            .addComponent(lbApellido)
                            .addComponent(lbTelefono)
                            .addComponent(lbMail)
                            .addComponent(lbCiudad)
                            .addComponent(lbPais)
                            .addComponent(lbAnimales))
                        .addGap(18, 18, 18)
                        .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txNombre)
                            .addComponent(txApellido)
                            .addComponent(txTelefono)
                            .addComponent(txMail)
                            .addComponent(txCiudad)
                            .addComponent(txPais)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInfoBasicaPadrinoLayout.createSequentialGroup()
                                .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(comboMascotas, 0, 170, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSacarMascota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        pnInfoBasicaPadrinoLayout.setVerticalGroup(
            pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoBasicaPadrinoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbInfoBasicaPadrino)
                .addGap(18, 18, 18)
                .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCiudad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar)
                    .addComponent(lbAnimales))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSacarMascota))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblError.setText("Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnInfoBasicaPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelDonaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(lblError)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelDonaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(31, 31, 31)
                .addComponent(lblError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnInfoBasicaPadrino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.lblError.setVisible(false);
        this.padrino.setNombre(this.txNombre.getText());
        this.padrino.setApellido(this.txApellido.getText());
        this.padrino.setMail(this.txMail.getText());
        this.padrino.setCiudad(this.txCiudad.getText());
        this.padrino.setPais(this.txPais.getText());
        this.padrino.setTelefono(this.txTelefono.getText());
        this.padrino.setDonacion(new Donacion(Integer.parseInt
                (this.spMontoDonacion.getValue().toString()), 
                (String)this.comboMonedaDonacion.getSelectedItem(), 
                this.getComoFrecuenciaDonacion(), this.getComoMedioDonacion()
        ));
        try {
            this.logicaPadrino.guardarPadrino(padrino);
            this.contenedor.cambiarAInfoPadrino();
        } catch (LogicaNegocioException ex) {
            this.lblError.setVisible(true);
            this.lblError.setText(ex.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Mascota mascota = (Mascota)comboMascotas.getSelectedItem();
        if(mascota != null) {
            this.padrino.agregarMascota(mascota);
            this.modeloComboMascotas.removeElement(mascota);
            this.modeloListaMascotas.addElement(mascota);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.contenedor.cambiarAInfoPadrino();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSacarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacarMascotaActionPerformed
        List<Mascota> mascotas = this.listAnimalesAgregados.getSelectedValuesList();
        this.padrino.getQuiereApadrinar().removeAll(mascotas);
        this.setComboAnimales();
        this.setListaAnimalesAgregados();
    }//GEN-LAST:event_btnSacarMascotaActionPerformed

    private Sistema sistema;
    private Padrino padrino;
    private LogicaMascota logicaMascota;
    private LogicaPadrino logicaPadrino;
    private PanelPadrino contenedor;
    private DefaultComboBoxModel<Mascota> modeloComboMascotas;
    private DefaultListModel<Mascota> modeloListaMascotas;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSacarMascota;
    private javax.swing.JComboBox<String> comboFrecuenciaDonacion;
    private javax.swing.JComboBox<Mascota> comboMascotas;
    private javax.swing.JComboBox<String> comboMedioDonacion;
    private javax.swing.JComboBox<String> comboMonedaDonacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAnimales;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbCiudad;
    private javax.swing.JLabel lbFrecuenciaDonacion;
    private javax.swing.JLabel lbInfoBasicaPadrino;
    private javax.swing.JLabel lbMail;
    private javax.swing.JLabel lbMedioDonacion;
    private javax.swing.JLabel lbMonedaDonacion;
    private javax.swing.JLabel lbMonto;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPais;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lblDonacion;
    private javax.swing.JLabel lblError;
    private javax.swing.JList<Mascota> listAnimalesAgregados;
    private javax.swing.JPanel panelDonaciones;
    private javax.swing.JPanel pnInfoBasicaPadrino;
    private javax.swing.JSpinner spMontoDonacion;
    private javax.swing.JTextField txApellido;
    private javax.swing.JTextField txCiudad;
    private javax.swing.JTextField txMail;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txPais;
    private javax.swing.JTextField txTelefono;
    // End of variables declaration//GEN-END:variables

}
