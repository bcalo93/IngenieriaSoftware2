package logicanegocio;

public class GeneradorId {
    private static GeneradorId generador;
    private int idActual;
    
    private GeneradorId() {
        this.idActual = 0;
    }
    
    public static GeneradorId getInstancia() {
        if(generador == null) {
            generador = new GeneradorId();
        }
        return generador;
    }
    
    public int generarId() {
        this.idActual++;
        return this.idActual;
    }
    
    public int getIdActual() {
        return this.idActual;
    }
}
