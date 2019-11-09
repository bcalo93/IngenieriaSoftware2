package interfaz;

import dominio.Padrino;
import dominio.Sistema;
import java.util.Observable;
import java.util.Observer;
import logicanegocio.LogicaMascota;

public class PanelEditarPadrino extends javax.swing.JPanel implements Observer {
    
    public PanelEditarPadrino(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        this.logicaMascota = new LogicaMascota(sistema);
        this.sistema.addObserver(this);
    }
    
    public PanelEditarPadrino(Sistema sistema, PanelPadrino panelPadrino) {
        this(sistema);
        this.panelPadrino = panelPadrino;
        this.setSize(this.panelPadrino.getWidth(), this.panelPadrino.getHeight());
        this.padrino = new Padrino();
        this.setComboAnimales();
    }
    
    private void setComboAnimales() {
        this.comboMascotas.removeAllItems();
        this.logicaMascota.getMascotasExcluyendo(this.padrino.getQuiereApadrinar())
                .forEach(mascota -> {
                    this.comboMascotas.addItem(mascota.getNombre());
                });
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
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

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

        lbAnimales.setText("Animales:");

        jScrollPane1.setViewportView(listAnimalesAgregados);

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
                                .addComponent(btnAgregar)))))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        btnCancelar.setText("Cancelar");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnInfoBasicaPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addComponent(panelDonaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelDonaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnInfoBasicaPadrino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(this.padrino == null) {
            this.padrino = new Padrino();
        }
        this.padrino.setNombre(this.txNombre.getText());
        this.padrino.setApellido(this.txApellido.getText());
        this.padrino.setMail(this.txMail.getText());
        this.padrino.setCiudad(this.txCiudad.getText());
        this.padrino.setPais(this.txPais.getText());
        this.padrino.setTelefono(this.txTelefono.getText());
    }//GEN-LAST:event_btnGuardarActionPerformed

    private Sistema sistema;
    private Padrino padrino;
    private LogicaMascota logicaMascota;
    private PanelPadrino panelPadrino;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboFrecuenciaDonacion;
    private javax.swing.JComboBox<String> comboMascotas;
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
    private javax.swing.JList<String> listAnimalesAgregados;
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

    @Override
    public void update(Observable o, Object arg) {
        this.setComboAnimales();
    }
}
