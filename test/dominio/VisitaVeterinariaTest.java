/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.LocalTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author marce
 */
public class VisitaVeterinariaTest {

    private VisitaVeterinaria visita;

    @Before
    public void setUp() {
        visita = new VisitaVeterinaria();
    }

    @Test
    public void testConstructorSinParametros() {
        VisitaVeterinaria unaVisita = new VisitaVeterinaria();
        assertEquals("Sin-Nombre", unaVisita.getNombre());
        assertEquals("Sin-Motivo", unaVisita.getMotivo());
        assertEquals(false, unaVisita.getFueRealizado());
    }

    @Test
    public void testConstructorPorParametros() {
        Fecha fecha = new Fecha();
        LocalTime time = LocalTime.now();
        Usuario usuario = new Usuario();
        Mascota mascota = new Mascota();
        Veterinaria vet = new Veterinaria();
        VisitaVeterinaria unaVisita = new VisitaVeterinaria("Nombre", time, usuario, mascota, false, fecha, vet, "medico");
        Usuario resResponsable = unaVisita.getUsuario();
        Mascota resMascota = unaVisita.getMascota();
        String resNombreAct = unaVisita.getNombre();
        boolean resFueRealizada = unaVisita.getFueRealizado();
        Fecha resFecha = unaVisita.getFecha();
        LocalTime resHora = unaVisita.getHora();
        assertEquals(usuario, resResponsable);
        assertEquals(mascota, resMascota);
        assertEquals("Nombre", resNombreAct);
        assertEquals(false, resFueRealizada);
        assertEquals(fecha, resFecha);
        assertEquals(time, resHora);
        assertEquals(vet, unaVisita.getVeterinaria());
        assertEquals("medico", unaVisita.getMotivo());
    }

    @Test
    public void testConstructorPorParametrosVacio() {
        Fecha fecha = new Fecha();
        LocalTime time = LocalTime.now();
        Usuario usuario = new Usuario();
        Mascota mascota = new Mascota();
        Veterinaria vet = new Veterinaria();
        VisitaVeterinaria unaVisita = new VisitaVeterinaria("", time, usuario, mascota, false, fecha, vet, "");
        Usuario resResponsable = unaVisita.getUsuario();
        Mascota resMascota = unaVisita.getMascota();
        String resNombreAct = unaVisita.getNombre();
        boolean resFueRealizada = unaVisita.getFueRealizado();
        Fecha resFecha = unaVisita.getFecha();
        LocalTime resHora = unaVisita.getHora();
        assertEquals(usuario, resResponsable);
        assertEquals(mascota, resMascota);
        assertEquals("Sin-Nombre", resNombreAct);
        assertEquals(false, resFueRealizada);
        assertEquals(fecha, resFecha);
        assertEquals(time, resHora);
        assertEquals(vet, unaVisita.getVeterinaria());
        assertEquals("Sin-Motivo", unaVisita.getMotivo());
    }

    @Test
    public void testSetNombreActiidad() {
        visita.setNombre("Nombre");
        String resNombre = visita.getNombre();
        assertEquals("Nombre", resNombre);
    }

    @Test
    public void testSetNombreVacio() {
        visita.setNombre("");
        String resNombre = visita.getNombre();
        assertEquals("Sin-Nombre", resNombre);
    }

    @Test
    public void testSetHora() {
        LocalTime time = LocalTime.now();
        visita.setHora(time);
        LocalTime resHora = visita.getHora();
        assertEquals(time, resHora);
    }

    @Test
    public void testToString() {
        LocalTime time = LocalTime.now();
        Fecha fecha = new Fecha();
        visita.setHora(time);
        visita.setFecha(fecha);
        Usuario usuario = visita.getUsuario();
        Mascota mascota = visita.getMascota();
        String nombre = visita.getNombre();
        boolean fueRealizado = visita.getFueRealizado();
        Veterinaria veterinaria = visita.getVeterinaria();
        String resToString = visita.toString();
        assertEquals("VisitaVeterinaria{" + "nombre=" + nombre + ", hora=" + time + ", responsable=" + usuario + ", mascota=" + mascota + ", fueRealizado=" + fueRealizado + ", fecha=" + fecha + ", veterinaria=" + veterinaria + '}', resToString);
    }

    @Test
    public void testSetFueRealizadoTrue() {
        visita.setFueRealizado(true);
        boolean resFueRealizado = visita.getFueRealizado();
        assertEquals(true, resFueRealizado);
    }

    @Test
    public void testSetFueRealizadoFalse() {
        visita.setFueRealizado(false);
        boolean resFueRealizado = visita.getFueRealizado();
        assertEquals(false, resFueRealizado);
    }

    @Test
    public void testSetMascota() {
        Mascota mascota;
        mascota = new Mascota();
        visita.setMascota(mascota);
        assertEquals(mascota, visita.getMascota());
    }

    @Test
    public void testSetResponsable() {
        Usuario responsable;
        responsable = new Usuario();
        visita.setUsuario(responsable);
        assertEquals(responsable, visita.getUsuario());
    }
}
