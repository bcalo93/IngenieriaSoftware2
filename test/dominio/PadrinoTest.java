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
    public void testConstructorConPadrino() {
        Padrino conPadrino = new Padrino(new Padrino("Juan", "juan@mail.com", "Perez", "1234567890",
            "Montevideo", "Uruguay", new Donacion(2000, "USD", FrecuenciaDonacion.MENSUAL, 
            MedioDonacion.TRANSFERENCIA_BANCARIA)));
        Assert.assertEquals("Juan", conPadrino.getNombre());
        Assert.assertEquals("Perez", conPadrino.getApellido());
        Assert.assertEquals("juan@mail.com", conPadrino.getMail());
        Assert.assertEquals("1234567890", conPadrino.getTelefono());
        Assert.assertEquals("Montevideo", conPadrino.getCiudad());
        Assert.assertEquals("Uruguay", conPadrino.getPais());
        Assert.assertEquals(2000, conPadrino.getDonacion().getMontoDonacion());
        Assert.assertEquals("USD", conPadrino.getDonacion().getMoneda());
        Assert.assertEquals(FrecuenciaDonacion.MENSUAL, conPadrino.getDonacion()
                .getFrecuencia());
        Assert.assertEquals(MedioDonacion.TRANSFERENCIA_BANCARIA, conPadrino
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
    public void testAgregarMascotaNull() {
        padrino.agregarMascota(null);
        Assert.assertEquals(0, padrino.getQuiereApadrinar().size());
    }
    
    @Test
    public void testBorrarMascota() {
        Mascota mascota = new Mascota();
        padrino.agregarMascota(mascota);
        Assert.assertEquals(1, padrino.getQuiereApadrinar().size());
        padrino.borrarMascota(mascota);
        Assert.assertEquals(0, padrino.getQuiereApadrinar().size());
    }
    
    @Test
    public void testActualizar() {
        Padrino paraActualizar = new Padrino();
        
        paraActualizar.actualizar(new Padrino("Juan", "juan@mail.com", "Perez", "1234567890",
            "Montevideo", "Uruguay", new Donacion(2000, "USD", FrecuenciaDonacion.MENSUAL, 
            MedioDonacion.TRANSFERENCIA_BANCARIA)));
        
        Assert.assertEquals("Juan", paraActualizar.getNombre());
        Assert.assertEquals("Perez", paraActualizar.getApellido());
        Assert.assertEquals("juan@mail.com", paraActualizar.getMail());
        Assert.assertEquals("1234567890", paraActualizar.getTelefono());
        Assert.assertEquals("Montevideo", paraActualizar.getCiudad());
        Assert.assertEquals("Uruguay", paraActualizar.getPais());
        Assert.assertEquals(2000, paraActualizar.getDonacion().getMontoDonacion());
        Assert.assertEquals("USD", paraActualizar.getDonacion().getMoneda());
        Assert.assertEquals(FrecuenciaDonacion.MENSUAL, paraActualizar.getDonacion()
                .getFrecuencia());
        Assert.assertEquals(MedioDonacion.TRANSFERENCIA_BANCARIA, paraActualizar
                .getDonacion().getMedio());
    }
    
    @Test
    public void testToString() {
        Padrino testToString = new Padrino();
        testToString.setNombre("Nombre Padrino");
        testToString.setApellido("Apellido Padrino");
        Assert.assertEquals("Nombre Padrino Apellido Padrino", testToString.toString());
    }
}
