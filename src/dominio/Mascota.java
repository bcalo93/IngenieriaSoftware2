package dominio;

import java.util.Objects;
import javax.swing.ImageIcon;

public class Mascota {
    
    public static final String TIPO_POR_DEFECTO = "Perro";

    private String nombre;
    private double altura;
    private double peso;
    private  String tipo;
    private String comentarios;
    private ImageIcon foto;
    private boolean fueAdoptado;

    public Mascota(String nombre, double altura, double peso, String comentarios, 
            String tipo) { //Sin foto
        setNombre(nombre);
        setAltura(altura);
        setPeso(peso);
        setComentarios(comentarios);
        setTipo(tipo);
        this.foto = null;
    }

    public Mascota() { //Sin foto
        this.nombre = "Sin-Nombre";
        this.altura = 0;
        this.peso = 0;
        this.comentarios = "Sin-Comentarios";
        this.tipo = TIPO_POR_DEFECTO;
        this.foto = null;
    }

    public String getNombre() {
        return nombre;
    }

    public final void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            this.nombre = "Sin-Nombre";
        } else {
            this.nombre = nombre;
        }

    }

    public double getAltura() {
        return altura;
    }

    public final void setAltura(double altura) {
        if (altura < 0) {
            this.altura = 0.0;
        } else {
            this.altura = altura;
        }

    }

    public double getPeso() {
        return peso;
    }

    public final void setPeso(double peso) {
        if (peso < 0) {
            this.peso = 0.0;
        } else {
            this.peso = peso;
        }
    }

    public String getComentarios() {
        return comentarios;
    }

    public final void setComentarios(String comentarios) {
        if (comentarios == null || comentarios.isEmpty()) {
            this.comentarios = "Sin-Comentarios";

        } else {
            this.comentarios = comentarios;
        }
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon imagen) {
        this.foto = imagen;
    }

    public boolean fueAdoptado() {
        return fueAdoptado;
    }

    public void setFueAdoptado(boolean fueAdoptado) {
        this.fueAdoptado = fueAdoptado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if(tipo == null || tipo.isEmpty()) {
            this.tipo = TIPO_POR_DEFECTO;
        } else {
            this.tipo = tipo;            
        }
    }
    
    public boolean nombreValido() {
        return this.nombre != null && !this.nombre.trim().equals("");
    }
    
    public boolean alturaValida() {
        return this.altura > 0;
    }
    
    public boolean pesoValido() {
        return this.peso > 0;
    }
    
    public void actualizar(Mascota mascota) {
        this.nombre = mascota.getNombre();
        this.peso = mascota.getPeso();
        this.altura = mascota.getAltura();
        this.comentarios = mascota.getComentarios();
        this.fueAdoptado = mascota.fueAdoptado();
        this.tipo = mascota.getTipo();
        if(mascota.getFoto() != null) {
            this.foto = mascota.getFoto();    
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mascota other = (Mascota) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", altura=" + altura + ", peso=" + peso + ", comentarios=" + comentarios + '}';
    }
    
}
