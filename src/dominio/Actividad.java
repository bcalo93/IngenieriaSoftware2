package dominio;

import java.time.LocalTime;

public abstract class Actividad {

    public abstract String getNombre();

    public abstract LocalTime getHora();

    public abstract void setHora(LocalTime hora);

    public abstract Usuario getUsuario();

    public abstract void setUsuario(Usuario responasble);

    public abstract Mascota getMascota();

    public abstract void setMascota(Mascota mascota);

    public abstract boolean getFueRealizado();

    public abstract void setFueRealizado(boolean seCompleto);

    public abstract Fecha getFecha();

    public abstract void setFecha(Fecha fecha);
}
