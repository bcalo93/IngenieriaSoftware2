package dominio;

public abstract class Persona {
    private String nombre;
    private String mail;
    
    public Persona(String nombre, String mail) {
        this.nombre = nombre;
        this.mail = mail;
    }
    
    public Persona() {
        this.nombre = "Sin-Nombre";
        this.mail = "Sin-Mail";
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.equals("")) {
            this.nombre = "Sin-Nombre";
        } else {
            this.nombre = nombre;
        }
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        if (mail.equals("")) {
            this.mail = "Sin-Mail";
        } else {
            this.mail = mail;
        }
    }
    
    @Override
    public String toString() {
        return "Nombre=" + nombre + ", mail=" + mail + '}';
    }
}
