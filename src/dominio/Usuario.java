package dominio;

import java.util.ArrayList;

public class Usuario extends Persona {

    private final ArrayList<Actividad> actividades;

    public Usuario(String nombre, String mail) {
        super(nombre, mail);
        this.actividades = new ArrayList<>();
    }
    
    public Usuario() {
        super();
        this.actividades = new ArrayList<>();
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }
    
    public void agregarActividad(Actividad act){
        actividades.add(act);
    }
}