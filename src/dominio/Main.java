package dominio;


import interfaz.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        new VentanaPrincipal(new Sistema()).setVisible(true);
    } 
}
