package logicanegocio;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class GeneradorIdTest {
    
    @Test
    public void generarIdTresVecesTest() {
        assertEquals(1, GeneradorId.getInstancia().generarId());
        assertEquals(2, GeneradorId.getInstancia().generarId());
        assertEquals(3, GeneradorId.getInstancia().generarId());
        assertEquals(3, GeneradorId.getInstancia().getIdActual());
    }
}
