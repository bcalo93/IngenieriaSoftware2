package dominio;

import java.util.ArrayList;

public class Padrino extends Persona {
    private String apellido;
    private String telefono;
    private String ciudad;
    private String pais;
    private ArrayList<Mascota> quiereApadrinar;
    
    public Padrino(String nombre, String mail, String apellido, String telefono,
            String ciudad, String pais) {
        super(nombre, mail);
        this.apellido = apellido;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.pais = pais;
        this.quiereApadrinar = new ArrayList<>();
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ArrayList<Mascota> getQuiereApadrinar() {
        return quiereApadrinar;
    }
    
    public void agregarQuiereAdoptar(Mascota perro) {
        this.quiereApadrinar.add(perro);
    }
    
    public void quitarQuiereAdoptar(Mascota perro) {
        this.quiereApadrinar.remove(perro);
    }
    
}
