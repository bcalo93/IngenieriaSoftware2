package dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PadrinoTest {
    
    private Padrino padrino;
    
    @Before
    public void empezarCadaTest() {
        padrino = new Padrino();
    }

    @Test
    public void testConstructorSinParametros() {
        Assert.assertEquals("Sin-Nombre", padrino.getNombre());
        Assert.assertEquals("Sin-Mail", padrino.getMail());
        Assert.assertEquals("Sin-Apellido", padrino.getApellido());
        Assert.assertEquals("Sin-Telefono", padrino.getTelefono());
        Assert.assertEquals("Sin-Ciudad", padrino.getCiudad());
        Assert.assertEquals("Sin-Pais", padrino.getPais());
        Assert.assertEquals(0, padrino.getQuiereApadrinar().size());
        Assert.assertNotNull(padrino.getDonacion());
    }
    
    @Test
    public void testConstructorConParametros() {
        Padrino conParametros = new Padrino("Juan", "juan@mail.com", "Perez", "1234567890",
            "Montevideo", "Uruguay", new Donacion(2000, "USD", FrecuenciaDonacion.MENSUAL, 
            MedioDonacion.TRANSFERENCIA_BANCARIA));
        
        Assert.assertEquals("Juan", conParametros.getNombre());
        Assert.assertEquals("Perez", conParametros.getApellido());
        Assert.assertEquals("juan@mail.com", conParametros.getMail());
        Assert.assertEquals("1234567890", conParametros.getTelefono());
        Assert.assertEquals("Montevideo", conParametros.getCiudad());
        Assert.assertEquals("Uruguay", conParametros.getPais());
        Assert.assertEquals(2000, conParametros.getDonacion().getMontoDonacion());
        Assert.assertEquals("USD", conParametros.getDonacion().getMoneda());
        Assert.assertEquals(FrecuenciaDonacion.MENSUAL, conParametros.getDonacion()
                .getFrecuencia());
        Assert.assertEquals(MedioDonacion.TRANSFERENCIA_BANCARIA, conParametros
                .getDonacion().getMedio());
    }
    
    @Test
    public void testSetNombre() {
        padrino.setNombre("Carlos");
        Assert.assertEquals("Carlos", padrino.getNombre());
    }
    
    @Test
    public void testSetApellido() {
        padrino.setApellido("Gonzalez");
        Assert.assertEquals("Gonzalez", padrino.getApellido());
    }
    
    @Test
    public void testSetMail() {
        padrino.setMail("cgonzalez@mail.com");
        Assert.assertEquals("cgonzalez@mail.com", padrino.getMail());
    }
    
    @Test
    public void testSetTelefono() {
        padrino.setTelefono("0987654321");
        Assert.assertEquals("0987654321", padrino.getTelefono());
    }
    
    @Test
    public void testSetCiudad() {
        padrino.setCiudad("Maldonado");
        Assert.assertEquals("Maldonado", padrino.getCiudad());
    }
    
    @Test
    public void testSetPais() {
        padrino.setPais("Uruguay");
        Assert.assertEquals("Uruguay", padrino.getPais());
    }
    
    @Test
    public void testSetDonacion() {
        Donacion donacion = new Donacion();
        padrino.setDonacion(donacion);
        Assert.assertEquals(donacion, padrino.getDonacion());
    }
    
    @Test
    public void testAgregarMascota() {
        Mascota mascota = new Mascota();
        padrino.agregarMascota(mascota);
        Assert.assertEquals(1, padrino.getQuiereApadrinar().size());
        Assert.assertEquals(mascota, padrino.getQuiereApadrinar().get(0));
    }
    
    @Test
    public void testBorrarMascota() {
        Mascota mascota = new Mascota();
        padrino.agregarMascota(mascota);
        Assert.assertEquals(1, padrino.getQuiereApadrinar().size());
        padrino.borrarMascota(mascota);
        Assert.assertEquals(0, padrino.getQuiereApadrinar().size());
    }
}
