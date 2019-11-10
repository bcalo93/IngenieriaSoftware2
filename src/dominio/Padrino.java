package dominio;

import java.util.ArrayList;

public class Padrino extends Persona {
    private Integer id;
    private String apellido;
    private String telefono;
    private String ciudad;
    private String pais;
    private ArrayList<Mascota> quiereApadrinar;
    private Donacion donacion;
    
    public Padrino() {
        super();
        this.apellido = "Sin-Apellido";
        this.telefono = "Sin-Telefono";
        this.ciudad = "Sin-Ciudad";
        this.pais = "Sin-Pais";
        this.quiereApadrinar = new ArrayList<>();
        this.donacion = new Donacion();
    }
    
    public Padrino(String nombre, String mail, String apellido, String telefono,
            String ciudad, String pais, Donacion donacion) {
        super(nombre, mail);
        this.apellido = apellido;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.pais = pais;
        this.donacion = donacion;
        this.quiereApadrinar = new ArrayList<>();
    }

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
    
    public Donacion getDonacion() {
        return donacion;
    }

    public void setDonacion(Donacion donacion) {
        this.donacion = donacion;
    }
    
    public ArrayList<Mascota> getQuiereApadrinar() {
        return quiereApadrinar;
    }
    
    public void agregarMascota(Mascota mascota) {
        if(mascota != null) {
            this.quiereApadrinar.add(mascota);
        }
    }
    
    public void borrarMascota(Mascota perro) {
        this.quiereApadrinar.remove(perro);
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", this.getNombre(), this.apellido);
    }
    
}
