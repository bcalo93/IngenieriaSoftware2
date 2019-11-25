package dominio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdoptanteTest {
    
    private Mascota mascota;
    
    @Before
    public void inicializarTest() {
        this.mascota = new Mascota("Rasty", 10, 10, "", "Perro", true, "sin adoptar");
    }
    
    @Test
    public void testConstructor() {
        Adoptante adoptante = new Adoptante("Carlos", "Perez", "203123", mascota);
        assertEquals("Carlos", adoptante.getNombre());
        assertEquals("Perez", adoptante.getApellido());
        assertEquals("203123", adoptante.getTelefono());
        assertEquals(mascota, adoptante.getAnimalAdoptado());
    }
    
    @Test
    public void testSetNombre() {
        Adoptante adoptante = new Adoptante("Carlos", "Perez", "203123", mascota);
        adoptante.setNombre("Juan");
        assertEquals("Juan", adoptante.getNombre());
        assertEquals("Perez", adoptante.getApellido());
        assertEquals("203123", adoptante.getTelefono());
        assertEquals(mascota, adoptante.getAnimalAdoptado());
    }
    
    @Test
    public void testSetApellido() {
        Adoptante adoptante = new Adoptante("Carlos", "Perez", "203123", mascota);
        adoptante.setApellido("Gomez");
        assertEquals("Carlos", adoptante.getNombre());
        assertEquals("Gomez", adoptante.getApellido());
        assertEquals("203123", adoptante.getTelefono());
        assertEquals(mascota, adoptante.getAnimalAdoptado());
    }
    
    @Test
    public void testSetTelefono() {
        Adoptante adoptante = new Adoptante("Carlos", "Perez", "203123", mascota);
        adoptante.setTelefono("31241243123");
        assertEquals("Carlos", adoptante.getNombre());
        assertEquals("Perez", adoptante.getApellido());
        assertEquals("31241243123", adoptante.getTelefono());
        assertEquals(mascota, adoptante.getAnimalAdoptado());
    }
    
    @Test
    public void testSetAnimalAdoptado() {
        Mascota nuevaMascota = new Mascota();
        Adoptante adoptante = new Adoptante("Carlos", "Perez", "203123", mascota);
        
        adoptante.setAnimalAdoptado(nuevaMascota);
        assertEquals("Carlos", adoptante.getNombre());
        assertEquals("Perez", adoptante.getApellido());
        assertEquals("203123", adoptante.getTelefono());
        assertEquals(nuevaMascota, adoptante.getAnimalAdoptado());
    }
    
    @Test
    public void testToString() {
        Adoptante adoptante = new Adoptante("Carlos", "Perez", "203123", mascota);
        assertEquals("Carlos Perez", adoptante.toString());
    
    }
}
