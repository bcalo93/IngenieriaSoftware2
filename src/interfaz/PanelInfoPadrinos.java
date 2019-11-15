package interfaz;

import dominio.Donacion;
import dominio.Mascota;
import dominio.Padrino;
import dominio.Sistema;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import logicanegocio.LogicaPadrino;

public class PanelInfoPadrinos extends javax.swing.JPanel implements Observer {

    public PanelInfoPadrinos() {
        initComponents();
        this.modeloPadrinos = new DefaultListModel<>();
        this.listPadrinos.setModel(this.modeloPadrinos);
        this.modeloMascota = new DefaultListModel<>();
        this.listAnimalesApadrinados.setModel(modeloMascota);
        
    }
    
    public PanelInfoPadrinos(Sistema sistema, PanelPadrino contenedor) {
        this();
        this.sistema = sistema;
        this.contenedor = contenedor;
        this.logicaPadrino = new LogicaPadrino(sistema);
        this.setSize(contenedor.getWidth(), contenedor.getHeight());
        this.sistema.addObserver(this);
        this.setListaPadrinos();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        this.setListaPadrinos();
        this.asignarCampos();
    }
    
    public void mostrar() {
        this.setVisible(true);
        this.asignarCampos();
    }
    
    private void setListaPadrinos() {
        this.modeloPadrinos.removeAllElements();
        this.logicaPadrino.getPadrinos().forEach(
                padrino -> this.modeloPadrinos.addElement(padrino)
        );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInfoPadrinos = new javax.swing.JLabel();
        panelListaPadrinos = new javax.swing.JPanel();
        scrollPadrinos = new javax.swing.JScrollPane();
        listPadrinos = new javax.swing.JList<>();
        lbPadrinos = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        panelInfoBasica = new javax.swing.JPanel();
        lbApadrinados = new javax.swing.JLabel();
        scrollAnimales = new javax.swing.JScrollPane();
        listAnimalesApadrinados = new javax.swing.JList<>();
        lbInformacionBasica = new javax.swing.JLabel();
        panelCamposInfoBasica = new javax.swing.JPanel();
        lbTenefono = new javax.swing.JLabel();
        lbValorCorreo = new javax.swing.JLabel();
        lbValorCiudad = new javax.swing.JLabel();
        lbPais = new javax.swing.JLabel();
        lblValorApellido = new javax.swing.JLabel();
        lbCiudad = new javax.swing.JLabel();
        lbCorreo = new javax.swing.JLabel();
        lbValorPais = new javax.swing.JLabel();
        lbValorTelefono = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbValorNombre = new javax.swing.JLabel();
        panelDonacion = new javax.swing.JPanel();
        lbDonaciones = new javax.swing.JLabel();
        lbMonto = new javax.swing.JLabel();
        lbValorMonto = new javax.swing.JLabel();
        lbMoneda = new javax.swing.JLabel();
        lbValorMoneda = new javax.swing.JLabel();
        lbFrecuencia = new javax.swing.JLabel();
        lbValorFrecuencia = new javax.swing.JLabel();
        lbMedio = new javax.swing.JLabel();
        lbValorMedio = new javax.swing.JLabel();

        lblInfoPadrinos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblInfoPadrinos.setText("Informacion Padrinos");

        listPadrinos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPadrinosMouseClicked(evt);
            }
        });
        scrollPadrinos.setViewportView(listPadrinos);

        lbPadrinos.setText("Padrinos");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelListaPadrinosLayout = new javax.swing.GroupLayout(panelListaPadrinos);
        panelListaPadrinos.setLayout(panelListaPadrinosLayout);
        panelListaPadrinosLayout.setHorizontalGroup(
            panelListaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaPadrinosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPadrinos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaPadrinosLayout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(scrollPadrinos, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaPadrinosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelListaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );
        panelListaPadrinosLayout.setVerticalGroup(
            panelListaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaPadrinosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbPadrinos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPadrinos, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrar)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panelInfoBasica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbApadrinados.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbApadrinados.setText("Animales apadrinados");

        scrollAnimales.setViewportView(listAnimalesApadrinados);

        lbInformacionBasica.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbInformacionBasica.setText("Informacion Basica");

        panelCamposInfoBasica.setMaximumSize(new java.awt.Dimension(273, 230));

        lbTenefono.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbTenefono.setText("Telefono:");

        lbValorCorreo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorCorreo.setText(" ");

        lbValorCiudad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorCiudad.setText(" ");

        lbPais.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbPais.setText("Pais:");

        lblValorApellido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblValorApellido.setText(" ");

        lbCiudad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbCiudad.setText("Ciudad:");

        lbCorreo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbCorreo.setText("Correo:");

        lbValorPais.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorPais.setText(" ");

        lbValorTelefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorTelefono.setText(" ");

        lbApellido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbApellido.setText("Apellido:");

        lbNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbNombre.setText("Nombre:");

        lbValorNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorNombre.setText(" ");

        javax.swing.GroupLayout panelCamposInfoBasicaLayout = new javax.swing.GroupLayout(panelCamposInfoBasica);
        panelCamposInfoBasica.setLayout(panelCamposInfoBasicaLayout);
        panelCamposInfoBasicaLayout.setHorizontalGroup(
            panelCamposInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposInfoBasicaLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(panelCamposInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbApellido)
                    .addComponent(lbNombre)
                    .addComponent(lbCorreo)
                    .addComponent(lbTenefono)
                    .addComponent(lbCiudad)
                    .addComponent(lbPais))
                .addGap(34, 34, 34)
                .addGroup(panelCamposInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbValorNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblValorApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbValorCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbValorTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbValorCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbValorPais, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelCamposInfoBasicaLayout.setVerticalGroup(
            panelCamposInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposInfoBasicaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCamposInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombre)
                    .addComponent(lbValorNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCamposInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbApellido)
                    .addComponent(lblValorApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCamposInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCorreo)
                    .addComponent(lbValorCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCamposInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenefono)
                    .addComponent(lbValorTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCamposInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCiudad)
                    .addComponent(lbValorCiudad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCamposInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPais)
                    .addComponent(lbValorPais))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout panelInfoBasicaLayout = new javax.swing.GroupLayout(panelInfoBasica);
        panelInfoBasica.setLayout(panelInfoBasicaLayout);
        panelInfoBasicaLayout.setHorizontalGroup(
            panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoBasicaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoBasicaLayout.createSequentialGroup()
                        .addComponent(panelCamposInfoBasica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbApadrinados, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbInformacionBasica))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panelInfoBasicaLayout.setVerticalGroup(
            panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoBasicaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbInformacionBasica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelInfoBasicaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbApadrinados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelCamposInfoBasica, javax.swing.GroupLayout.PREFERRED_SIZE, 194, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );

        panelDonacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbDonaciones.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbDonaciones.setText("Donacion");

        lbMonto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbMonto.setText("Monto:");

        lbValorMonto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorMonto.setText(" ");

        lbMoneda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbMoneda.setText("Moneda:");

        lbValorMoneda.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorMoneda.setText(" ");

        lbFrecuencia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbFrecuencia.setText("Frecuencia:");

        lbValorFrecuencia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorFrecuencia.setText(" ");

        lbMedio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbMedio.setText("Medio:");

        lbValorMedio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorMedio.setText(" ");

        javax.swing.GroupLayout panelDonacionLayout = new javax.swing.GroupLayout(panelDonacion);
        panelDonacion.setLayout(panelDonacionLayout);
        panelDonacionLayout.setHorizontalGroup(
            panelDonacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDonacionLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelDonacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbMonto)
                    .addComponent(lbMoneda)
                    .addGroup(panelDonacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbFrecuencia)
                        .addComponent(lbDonaciones))
                    .addComponent(lbMedio))
                .addGap(30, 30, 30)
                .addGroup(panelDonacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbValorMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbValorMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbValorFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbValorMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDonacionLayout.setVerticalGroup(
            panelDonacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDonacionLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbDonaciones)
                .addGap(18, 18, 18)
                .addGroup(panelDonacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMonto)
                    .addComponent(lbValorMonto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDonacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMoneda)
                    .addComponent(lbValorMoneda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDonacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFrecuencia)
                    .addComponent(lbValorFrecuencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDonacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMedio)
                    .addComponent(lbValorMedio))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfoPadrinos)
                    .addComponent(panelListaPadrinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDonacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInfoBasica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblInfoPadrinos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelInfoBasica, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelListaPadrinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.contenedor.cambiarAEditarPadrino();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void listPadrinosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPadrinosMouseClicked
        this.asignarCampos();
    }//GEN-LAST:event_listPadrinosMouseClicked

    private void asignarCampos() {
        Padrino seleccionado = this.listPadrinos.getSelectedValue();
        if (seleccionado != null) {
            this.lbValorNombre.setText(seleccionado.getNombre());
            this.lblValorApellido.setText(seleccionado.getApellido());
            this.lbValorCorreo.setText(seleccionado.getMail());
            this.lbValorTelefono.setText(seleccionado.getTelefono());
            this.lbValorCiudad.setText(seleccionado.getCiudad());
            this.lbValorPais.setText(seleccionado.getPais());
            this.setListaMascotas(seleccionado);

            Donacion donacion = seleccionado.getDonacion();
            this.lbValorMonto.setText(String.valueOf(donacion.getMontoDonacion()));
            this.lbValorMoneda.setText(donacion.getMoneda());
            this.lbValorFrecuencia.setText(donacion.getFrecuencia().toString());
            this.lbValorMedio.setText(donacion.getMedio().toString());
        } else {
            this.lbValorNombre.setText("");
            this.lblValorApellido.setText("");
            this.lbValorCorreo.setText("");
            this.lbValorTelefono.setText("");
            this.lbValorCiudad.setText("");
            this.lbValorPais.setText("");
            this.modeloMascota.removeAllElements();

            this.lbValorMonto.setText("");
            this.lbValorMoneda.setText("");
            this.lbValorFrecuencia.setText("");
            this.lbValorMedio.setText("");
        }
    }
    
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Padrino seleccionado = this.listPadrinos.getSelectedValue();
        if(seleccionado != null) {
            this.contenedor.cambiarAEditarPadrino(seleccionado);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        this.logicaPadrino.borrarPadrino(this.listPadrinos.getSelectedValue());        
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void setListaMascotas(Padrino padrino) {
        this.modeloMascota.removeAllElements();
        padrino.getQuiereApadrinar().forEach(
                mascota -> this.modeloMascota.addElement(mascota)
        );   
    }

    private Sistema sistema;
    private PanelPadrino contenedor;
    private DefaultListModel<Padrino> modeloPadrinos;
    private DefaultListModel<Mascota> modeloMascota;
    private LogicaPadrino logicaPadrino;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel lbApadrinados;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbCiudad;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbDonaciones;
    private javax.swing.JLabel lbFrecuencia;
    private javax.swing.JLabel lbInformacionBasica;
    private javax.swing.JLabel lbMedio;
    private javax.swing.JLabel lbMoneda;
    private javax.swing.JLabel lbMonto;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPadrinos;
    private javax.swing.JLabel lbPais;
    private javax.swing.JLabel lbTenefono;
    private javax.swing.JLabel lbValorCiudad;
    private javax.swing.JLabel lbValorCorreo;
    private javax.swing.JLabel lbValorFrecuencia;
    private javax.swing.JLabel lbValorMedio;
    private javax.swing.JLabel lbValorMoneda;
    private javax.swing.JLabel lbValorMonto;
    private javax.swing.JLabel lbValorNombre;
    private javax.swing.JLabel lbValorPais;
    private javax.swing.JLabel lbValorTelefono;
    private javax.swing.JLabel lblInfoPadrinos;
    private javax.swing.JLabel lblValorApellido;
    private javax.swing.JList<Mascota> listAnimalesApadrinados;
    private javax.swing.JList<Padrino> listPadrinos;
    private javax.swing.JPanel panelCamposInfoBasica;
    private javax.swing.JPanel panelDonacion;
    private javax.swing.JPanel panelInfoBasica;
    private javax.swing.JPanel panelListaPadrinos;
    private javax.swing.JScrollPane scrollAnimales;
    private javax.swing.JScrollPane scrollPadrinos;
    // End of variables declaration//GEN-END:variables

}
