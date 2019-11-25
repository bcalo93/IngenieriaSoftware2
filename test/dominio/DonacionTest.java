package dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DonacionTest {
    
    private Donacion donacion;
    
    @Before
    public void empezarCadaTest() {
        donacion = new Donacion();
    }
    
    @Test
    public void testConstructorSinParametros() {
        Assert.assertEquals(0, donacion.getMontoDonacion());
        Assert.assertEquals(Donacion.MONEDA_POR_DEFECTO, donacion.getMoneda());
        Assert.assertEquals(FrecuenciaDonacion.UNA_VEZ, donacion.getFrecuencia());
        Assert.assertEquals(MedioDonacion.TARJETA_CREDITO, donacion.getMedio());
    }
    
    @Test
    public void testConstructorConParametros() {
        Donacion conParametros = new Donacion(2000, "USD", FrecuenciaDonacion.MENSUAL, 
            MedioDonacion.TRANSFERENCIA_BANCARIA);
        Assert.assertEquals(2000, conParametros.getMontoDonacion());
        Assert.assertEquals("USD", conParametros.getMoneda());
        Assert.assertEquals(FrecuenciaDonacion.MENSUAL, conParametros.getFrecuencia());
        Assert.assertEquals(MedioDonacion.TRANSFERENCIA_BANCARIA, conParametros.getMedio());
    }
    
    @Test
    public void testSetMontoDonacion() {
        donacion.setMontoDonacion(3000);
        Assert.assertEquals(3000, donacion.getMontoDonacion());
    }
    
    @Test
    public void testSetMoneda() {
        donacion.setMoneda("U$");
        Assert.assertEquals("U$", donacion.getMoneda());
    }
    
    @Test
    public void testSetFrecuencia() {
        donacion.setFrecuencia(FrecuenciaDonacion.ANUAL);
        Assert.assertEquals(FrecuenciaDonacion.ANUAL, donacion.getFrecuencia());
    }
    
    @Test
    public void testSetMedio() {
        donacion.setMedio(MedioDonacion.TRANSFERENCIA_BANCARIA);
        Assert.assertEquals(MedioDonacion.TRANSFERENCIA_BANCARIA, donacion.getMedio());
    }
}
