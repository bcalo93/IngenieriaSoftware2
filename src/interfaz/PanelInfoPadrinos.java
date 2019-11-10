package interfaz;

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
        panelInfoBasica = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        lbValorNombre = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        lblValorApellido = new javax.swing.JLabel();
        lbTenefono = new javax.swing.JLabel();
        lbValorTelefono = new javax.swing.JLabel();
        lbCorreo = new javax.swing.JLabel();
        lbValorCorreo = new javax.swing.JLabel();
        lbCiudad = new javax.swing.JLabel();
        lbValorCiudad = new javax.swing.JLabel();
        lbPais = new javax.swing.JLabel();
        lbValorPais = new javax.swing.JLabel();
        lbApadrinados = new javax.swing.JLabel();
        scrollAnimales = new javax.swing.JScrollPane();
        listAnimalesApadrinados = new javax.swing.JList<>();
        lbInformacionBasica = new javax.swing.JLabel();
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

        scrollPadrinos.setViewportView(listPadrinos);

        lbPadrinos.setText("Padrinos");

        javax.swing.GroupLayout panelListaPadrinosLayout = new javax.swing.GroupLayout(panelListaPadrinos);
        panelListaPadrinos.setLayout(panelListaPadrinosLayout);
        panelListaPadrinosLayout.setHorizontalGroup(
            panelListaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaPadrinosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelListaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPadrinos)
                    .addComponent(scrollPadrinos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelListaPadrinosLayout.setVerticalGroup(
            panelListaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaPadrinosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbPadrinos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPadrinos, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        panelInfoBasica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbNombre.setText("Nombre:");

        lbValorNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorNombre.setText("Nombre");

        lbApellido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbApellido.setText("Apellido:");

        lblValorApellido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblValorApellido.setText("Apellido");

        lbTenefono.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbTenefono.setText("Telefono:");

        lbValorTelefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorTelefono.setText("Telefono");

        lbCorreo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbCorreo.setText("Correo:");

        lbValorCorreo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorCorreo.setText("Correo");

        lbCiudad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbCiudad.setText("Ciudad:");

        lbValorCiudad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorCiudad.setText("Ciudad");

        lbPais.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbPais.setText("Pais:");

        lbValorPais.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorPais.setText("Pais");

        lbApadrinados.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbApadrinados.setText("Animales apadrinados");

        scrollAnimales.setViewportView(listAnimalesApadrinados);

        lbInformacionBasica.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbInformacionBasica.setText("Informacion Basica");

        javax.swing.GroupLayout panelInfoBasicaLayout = new javax.swing.GroupLayout(panelInfoBasica);
        panelInfoBasica.setLayout(panelInfoBasicaLayout);
        panelInfoBasicaLayout.setHorizontalGroup(
            panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoBasicaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbInformacionBasica)
                    .addGroup(panelInfoBasicaLayout.createSequentialGroup()
                        .addGroup(panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbPais)
                            .addComponent(lbCiudad)
                            .addComponent(lbCorreo)
                            .addComponent(lbTenefono)
                            .addComponent(lbApellido)
                            .addComponent(lbNombre))
                        .addGap(35, 35, 35)
                        .addGroup(panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbValorNombre)
                            .addComponent(lblValorApellido)
                            .addComponent(lbValorTelefono)
                            .addComponent(lbValorCorreo)
                            .addComponent(lbValorCiudad)
                            .addComponent(lbValorPais))
                        .addGap(74, 74, 74)
                        .addGroup(panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbApadrinados, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInfoBasicaLayout.setVerticalGroup(
            panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoBasicaLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lbInformacionBasica)
                .addGap(18, 18, 18)
                .addGroup(panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombre)
                    .addComponent(lbValorNombre)
                    .addComponent(lbApadrinados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoBasicaLayout.createSequentialGroup()
                        .addGroup(panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbApellido)
                            .addComponent(lblValorApellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTenefono)
                            .addComponent(lbValorTelefono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCorreo)
                            .addComponent(lbValorCorreo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCiudad)
                            .addComponent(lbValorCiudad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelInfoBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPais)
                            .addComponent(lbValorPais)))
                    .addComponent(scrollAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        panelDonacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbDonaciones.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbDonaciones.setText("Donacion");

        lbMonto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbMonto.setText("Monto:");

        lbValorMonto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorMonto.setText("Monto");

        lbMoneda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbMoneda.setText("Moneda:");

        lbValorMoneda.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorMoneda.setText("Moneda");

        lbFrecuencia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbFrecuencia.setText("Frecuencia:");

        lbValorFrecuencia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorFrecuencia.setText("Frecuencia");

        lbMedio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbMedio.setText("Medio:");

        lbValorMedio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbValorMedio.setText("Medio");

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
                    .addComponent(lbValorMonto)
                    .addComponent(lbValorMoneda)
                    .addComponent(lbValorFrecuencia)
                    .addComponent(lbValorMedio))
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
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInfoPadrinos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelListaPadrinos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDonacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInfoBasica, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblInfoPadrinos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelListaPadrinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelInfoBasica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private Sistema sistema;
    private PanelPadrino contenedor;
    private DefaultListModel<Padrino> modeloPadrinos;
    private DefaultListModel<Mascota> modeloMascota;
    private LogicaPadrino logicaPadrino;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel panelDonacion;
    private javax.swing.JPanel panelInfoBasica;
    private javax.swing.JPanel panelListaPadrinos;
    private javax.swing.JScrollPane scrollAnimales;
    private javax.swing.JScrollPane scrollPadrinos;
    // End of variables declaration//GEN-END:variables

}
