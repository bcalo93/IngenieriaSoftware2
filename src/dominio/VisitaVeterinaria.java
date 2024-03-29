/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.LocalTime;

/**
 *
 * @author marce
 */
public class VisitaVeterinaria extends Actividad {

    private String nombre;
    private LocalTime hora;
    private Usuario responsable;
    private Mascota mascota;
    private boolean fueRealizado;
    private Fecha fecha;
    private Veterinaria veterinaria;
    private String motivo;

    public VisitaVeterinaria() {
        this.nombre = "Sin-Nombre";
        this.hora = LocalTime.now();
        this.responsable = new Usuario();
        this.mascota = new Mascota();
        this.fueRealizado = false;
        this.fecha = new Fecha();
        this.veterinaria = new Veterinaria();
        this.motivo = "Sin-Motivo";
    }

    public VisitaVeterinaria(String nombre, LocalTime hora, Usuario responsable, Mascota mascota, boolean fueRealizado, Fecha fecha, Veterinaria veterinaria, String motivo) {
        setNombre(nombre);
        this.hora = hora;
        this.responsable = responsable;
        this.mascota = mascota;
        this.fueRealizado = fueRealizado;
        this.fecha = fecha;
        this.veterinaria = veterinaria;
        setMotivo(motivo);
    }

    public String getMotivo() {
        return motivo;
    }

    public final void setMotivo(String motivo) {
        if(motivo.equals("")){
            this.motivo = "Sin-Motivo";
        }else{
            this.motivo = motivo;
        }
    }

    public Veterinaria getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    public final void setNombre(String nombre) {
        if (nombre.equals("")) {
            this.nombre = "Sin-Nombre";
        } else {
            this.nombre = nombre;
        }
    }

    @Override
    public LocalTime getHora() {
        return this.hora;
    }

    @Override
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public Usuario getUsuario() {
        return this.responsable;
    }

    @Override
    public void setUsuario(Usuario responasble) {
        this.responsable = responasble;
    }

    @Override
    public Mascota getMascota() {
        return this.mascota;
    }

    @Override
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public boolean getFueRealizado() {
        return this.fueRealizado;
    }

    @Override
    public void setFueRealizado(boolean seCompleto) {
        this.fueRealizado = seCompleto;
        if(fueRealizado)
            veterinaria.eliminarActividadAgendada(this);
    }

    @Override
    public Fecha getFecha() {
        return this.fecha;
    }

    @Override
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "VisitaVeterinaria{" + "nombre=" + nombre + ", hora=" + hora + ", responsable=" + responsable + ", mascota=" + mascota + ", fueRealizado=" + fueRealizado + ", fecha=" + fecha + ", veterinaria=" + veterinaria + '}';
    }

  

    
}
