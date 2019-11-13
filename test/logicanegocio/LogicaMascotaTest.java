package logicanegocio;

import dominio.Mascota;
import dominio.Sistema;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class LogicaMascotaTest {
    private LogicaMascota logica;
    private Sistema sistema;
    
    @Before
    public void inicializarTest() {
        this.sistema = new Sistema();
        this.logica = new LogicaMascota(sistema);
    }
    
    @Test
    public void getMascotasExcluyendoOkTest() {
        ArrayList<Mascota> mascotasPrueba = this.crearMascotas(20);
        this.sistema.setMascotas(mascotasPrueba);
        
        List<Mascota> aExcluir = mascotasPrueba.subList(9, 14);
        
        List<Mascota> resultado = logica.getMascotasExcluyendo(aExcluir);
        assertEquals(15, resultado.size());
        for(Mascota mascota : aExcluir) {
            assertFalse(resultado.contains(mascota));
        }
    }
    
    @Test
    public void getMascotasExcluyendoListVaciaTest() {
        ArrayList<Mascota> mascotasPrueba = this.crearMascotas(20);
        this.sistema.setMascotas(mascotasPrueba);
        
        List<Mascota> resultado = logica.getMascotasExcluyendo(new ArrayList<>());
        assertEquals(20, resultado.size());
    }
    
    @Test
    public void getMascotaPorNombreOkTest() {
        sistema.setMascotas(this.crearMascotas(20));
        
        Mascota resultado = logica.getMascotaPorNombre("Mascota15");
        assertNotNull(resultado);
        assertEquals(17.0, resultado.getAltura(), 0);
        assertEquals(35.0, resultado.getPeso(), 0);
        assertEquals("Comentario15", resultado.getComentarios());
        assertEquals("Gato", resultado.getTipo());
    }
    
    @Test
    public void getMascotaPorNombreNoExisteTest() {
        sistema.setMascotas(this.crearMascotas(20));
        
        Mascota resultado = logica.getMascotaPorNombre("noexiste");
        assertNull(resultado);
    }
    
    @Test
    public void getMascotaPorNombreNullTest() {
        sistema.setMascotas(this.crearMascotas(20));
        
        Mascota resultado = logica.getMascotaPorNombre(null);
        assertNull(resultado);
    }
    
    private ArrayList<Mascota> crearMascotas(int cantidad) {
        ArrayList<Mascota> resultado = new ArrayList<>();
        for(int i = 0; i < cantidad; i++) {
            resultado.add(new Mascota("Mascota" + i, i + 2.0, i + 20.0, 
                    "Comentario" + i, "Gato"));
        }
        return resultado;
    }
    
}
