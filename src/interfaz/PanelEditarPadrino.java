package interfaz;

import dominio.Padrino;
import dominio.Sistema;
import logicanegocio.LogicaMascota;

public class PanelEditarPadrino extends javax.swing.JPanel {
    public PanelEditarPadrino() {
        initComponents();
        this.logicaMascota = new LogicaMascota(sistema);
    }
    
    public PanelEditarPadrino(Sistema sistema) {
        this();
        this.sistema = sistema;
        this.logicaMascota = new LogicaMascota(sistema);
    }
    
    public PanelEditarPadrino(int width, int height, Sistema sistema) {
        this(sistema);
        this.setSize(width, height);
        this.padrino = new Padrino();
        this.setComboAnimales();
    }
    
    private void setComboAnimales() {
        this.comboAnimales.removeAllItems();

        this.logicaMascota.getMascotasExcluyendo(this.padrino.getQuiereApadrinar())
                .forEach(mascota -> {
                    this.comboAnimales.addItem(mascota.getNombre());
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
        lbNombrePadrino = new javax.swing.JLabel();
        txNombrePadrino = new javax.swing.JTextField();
        lbApellidoPadrino = new javax.swing.JLabel();
        txApellidoPadrino = new javax.swing.JTextField();
        lbMailPadrino = new javax.swing.JLabel();
        txMailPadrino = new javax.swing.JTextField();
        lbCiudadPadrino = new javax.swing.JLabel();
        txCiudadPadrino = new javax.swing.JTextField();
        lblPaisPadrino = new javax.swing.JLabel();
        txPaisPadrino = new javax.swing.JTextField();
        comboAnimales = new javax.swing.JComboBox<>();
        btnAgregarAnimalPadrino = new javax.swing.JButton();
        lbAnimalesPadrino = new javax.swing.JLabel();
        slListaAnimalesPadrino = new javax.swing.JScrollPane();
        lstAnimalesPadrino = new javax.swing.JList<>();
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
                        .addGroup(panelDonacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboMonedaDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spMontoDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboFrecuenciaDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboMedioDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblDonacion))
                .addContainerGap(49, Short.MAX_VALUE))
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

        lbNombrePadrino.setText("Nombre:");

        lbApellidoPadrino.setText("Apellido:");

        lbMailPadrino.setText("Mail:");

        lbCiudadPadrino.setText("Ciudad:");

        lblPaisPadrino.setText("Pais:");

        comboAnimales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAgregarAnimalPadrino.setText("Agregar");

        lbAnimalesPadrino.setText("Animales:");

        lstAnimalesPadrino.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        slListaAnimalesPadrino.setViewportView(lstAnimalesPadrino);

        javax.swing.GroupLayout pnInfoBasicaPadrinoLayout = new javax.swing.GroupLayout(pnInfoBasicaPadrino);
        pnInfoBasicaPadrino.setLayout(pnInfoBasicaPadrinoLayout);
        pnInfoBasicaPadrinoLayout.setHorizontalGroup(
            pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoBasicaPadrinoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbInfoBasicaPadrino)
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnInfoBasicaPadrinoLayout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbApellidoPadrino)
                        .addComponent(lbNombrePadrino)
                        .addComponent(lbMailPadrino)
                        .addComponent(lbCiudadPadrino)
                        .addComponent(lblPaisPadrino)
                        .addComponent(lbAnimalesPadrino))
                    .addGap(18, 18, 18)
                    .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(slListaAnimalesPadrino)
                        .addGroup(pnInfoBasicaPadrinoLayout.createSequentialGroup()
                            .addComponent(comboAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAgregarAnimalPadrino))
                        .addComponent(txMailPadrino)
                        .addComponent(txApellidoPadrino)
                        .addComponent(txNombrePadrino)
                        .addComponent(txPaisPadrino)
                        .addComponent(txCiudadPadrino))
                    .addContainerGap(20, Short.MAX_VALUE)))
        );
        pnInfoBasicaPadrinoLayout.setVerticalGroup(
            pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoBasicaPadrinoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbInfoBasicaPadrino)
                .addContainerGap(355, Short.MAX_VALUE))
            .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnInfoBasicaPadrinoLayout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbNombrePadrino)
                        .addComponent(txNombrePadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(13, 13, 13)
                    .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txApellidoPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbApellidoPadrino))
                    .addGap(10, 10, 10)
                    .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbMailPadrino)
                        .addComponent(txMailPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCiudadPadrino)
                        .addComponent(txCiudadPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txPaisPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPaisPadrino))
                    .addGap(18, 18, 18)
                    .addGroup(pnInfoBasicaPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbAnimalesPadrino)
                        .addComponent(btnAgregarAnimalPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(slListaAnimalesPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btnCancelar.setText("Cancelar");

        btnGuardar.setText("Guardar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnInfoBasicaPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(panelDonaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnInfoBasicaPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelDonaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private Sistema sistema;
    private Padrino padrino;
    private LogicaMascota logicaMascota;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAnimalPadrino;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboAnimales;
    private javax.swing.JComboBox<String> comboFrecuenciaDonacion;
    private javax.swing.JComboBox<String> comboMedioDonacion;
    private javax.swing.JComboBox<String> comboMonedaDonacion;
    private javax.swing.JLabel lbAnimalesPadrino;
    private javax.swing.JLabel lbApellidoPadrino;
    private javax.swing.JLabel lbCiudadPadrino;
    private javax.swing.JLabel lbFrecuenciaDonacion;
    private javax.swing.JLabel lbInfoBasicaPadrino;
    private javax.swing.JLabel lbMailPadrino;
    private javax.swing.JLabel lbMedioDonacion;
    private javax.swing.JLabel lbMonedaDonacion;
    private javax.swing.JLabel lbMonto;
    private javax.swing.JLabel lbNombrePadrino;
    private javax.swing.JLabel lblDonacion;
    private javax.swing.JLabel lblPaisPadrino;
    private javax.swing.JList<String> lstAnimalesPadrino;
    private javax.swing.JPanel panelDonaciones;
    private javax.swing.JPanel pnInfoBasicaPadrino;
    private javax.swing.JScrollPane slListaAnimalesPadrino;
    private javax.swing.JSpinner spMontoDonacion;
    private javax.swing.JTextField txApellidoPadrino;
    private javax.swing.JTextField txCiudadPadrino;
    private javax.swing.JTextField txMailPadrino;
    private javax.swing.JTextField txNombrePadrino;
    private javax.swing.JTextField txPaisPadrino;
    // End of variables declaration//GEN-END:variables
}
