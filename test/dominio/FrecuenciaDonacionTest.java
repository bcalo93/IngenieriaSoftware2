package dominio;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class FrecuenciaDonacionTest {
    
    @Test
    public void testToStringUnaVez() {
        assertEquals("Una vez", FrecuenciaDonacion.UNA_VEZ.toString());
    }
    
    @Test
    public void testToStringMensual() {
        assertEquals("Mensual", FrecuenciaDonacion.MENSUAL.toString());
    }
    
    @Test
    public void testToStringTrimestral() {
        assertEquals("Trimestral", FrecuenciaDonacion.TRIMESTRAL.toString());
    }
    
    @Test
    public void testToStringAnual() {
        assertEquals("Anual", FrecuenciaDonacion.ANUAL.toString());
    }
}
