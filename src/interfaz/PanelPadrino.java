/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Sistema;

/**
 *
 * @author Brahian
 */
public class PanelPadrino extends javax.swing.JPanel {
    private PanelEditarPadrino editarPadrino;
    private PanelInfoPadrinos infoPadrinos;
    private Sistema sistema;
    
    public PanelPadrino(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
    }
    
    public PanelPadrino(Sistema sistema, int ancho, int altura) {
        this(sistema);
        this.setSize(ancho - 150, altura);
        this.editarPadrino = new PanelEditarPadrino(this.sistema, this);
        this.infoPadrinos = new PanelInfoPadrinos(this.sistema, this);
        this.add(this.infoPadrinos);
        this.add(this.editarPadrino);
        this.editarPadrino.setVisible(false);
    }
    
    protected void cambiarAEditarPadrino() {
        this.editarPadrino.setVisible(true);
        this.infoPadrinos.setVisible(false);
    }
    
    protected void cambiarAInfoPadrino() {
        this.editarPadrino.setVisible(false);
        this.infoPadrinos.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
