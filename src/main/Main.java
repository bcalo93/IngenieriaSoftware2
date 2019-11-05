package main;


import dominio.Sistema;
import interfaz.VentanaLogin;
import interfaz.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        //TODO generar clase login con credenciales y acá validar usuario  harcoded y luego hacer new de ventanaPrincipal. Previo crear ventanaLogin
        
        new VentanaLogin().setVisible(true);            
        
        new VentanaPrincipal(new Sistema()).setVisible(false);
        
    } 
}
