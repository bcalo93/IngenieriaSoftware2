package dominio;

public class Adoptante {
    private String nombre;
    private String apellido;
    private String telefono;
    private Mascota animalAdoptado;

    public Adoptante(String nombre, String apellido, String telefono, Mascota animalAdoptado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.animalAdoptado = animalAdoptado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Mascota getAnimalAdoptado() {
        return animalAdoptado;
    }

    public void setAnimalAdoptado(Mascota animalAdoptado) {
        this.animalAdoptado = animalAdoptado;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", this.nombre, this.apellido);
    }
}
