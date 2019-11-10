package logicanegocio;

import dominio.Donacion;
import dominio.FrecuenciaDonacion;
import dominio.MedioDonacion;
import dominio.Padrino;
import dominio.Sistema;
import logicanegocio.excepciones.LogicaNegocioException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogicaPadrinoTest {
    private LogicaPadrino logica;
    private Sistema sistema;
    
    @Before
    public void iniciarTest() {
        this.sistema = new Sistema();
        this.logica = new LogicaPadrino(sistema);
    }
    
    @Test
    public void guardarPadrinoOkTest() throws LogicaNegocioException {
        Padrino padrino = new Padrino();
        padrino.setNombre("Test Nombre");
        padrino.setApellido("Test Apellido");
        padrino.setMail("mail@mail.com");
        padrino.setTelefono("23123412");
        padrino.setCiudad("Test Ciudad");
        padrino.setPais("Test Pais");
        padrino.setDonacion(new Donacion(2000, "U$", FrecuenciaDonacion.MENSUAL, 
                MedioDonacion.TARJETA_CREDITO));
        this.logica.guardarPadrino(padrino);
        
        Padrino resultado = this.sistema.getPadrinos().stream()
                .findFirst().get();
        assertEquals("Test Nombre", resultado.getNombre());
        assertEquals("Test Apellido", resultado.getApellido());
        assertEquals("mail@mail.com", resultado.getMail());
        assertEquals("23123412", resultado.getTelefono());
        assertEquals("Test Ciudad", resultado.getCiudad());
        assertEquals("Test Pais", resultado.getPais());
        assertEquals(Integer.valueOf(GeneradorId.getInstancia().getIdActual()), 
                resultado.getId());
        assertEquals(0, resultado.getQuiereApadrinar().size());
        assertEquals(2000, padrino.getDonacion().getMontoDonacion());
        assertEquals("U$", padrino.getDonacion().getMoneda());
        assertEquals(FrecuenciaDonacion.MENSUAL, padrino.getDonacion()
                .getFrecuencia());
        assertEquals(MedioDonacion.TARJETA_CREDITO, padrino.getDonacion()
                .getMedio());
    }
    
    @Test(expected = LogicaNegocioException.class)
    public void guardarPadrinoMailFaltanteTest() throws LogicaNegocioException {
        Padrino padrino = new Padrino();
        padrino.setNombre("Test Nombre");
        padrino.setMail(" ");
        padrino.setApellido("Test Apellido");
        padrino.setTelefono("23123412");
        padrino.setCiudad("Test Ciudad");
        padrino.setPais("Test Pais");
        try {
            this.logica.guardarPadrino(padrino);
        } finally {
            assertEquals(0, this.sistema.getPadrinos().size());
        }
    }
    
    @Test(expected = LogicaNegocioException.class)
    public void guardarPadrinoNombreFaltanteTest() throws LogicaNegocioException {
        Padrino padrino = new Padrino();
        padrino.setNombre(" ");
        padrino.setMail("mail@mail.com");
        padrino.setApellido("Test Apellido");
        padrino.setTelefono("23123412");
        padrino.setCiudad("Test Ciudad");
        padrino.setPais("Test Pais");
        try {
            this.logica.guardarPadrino(padrino);
        } finally {
            assertEquals(0, this.sistema.getPadrinos().size());
        }
    }
    
    @Test(expected = LogicaNegocioException.class)
    public void guardarPadrinoApellidoFaltanteTest() throws LogicaNegocioException {
        Padrino padrino = new Padrino();
        padrino.setApellido(null);
        padrino.setMail("mail@mail.com");
        padrino.setNombre("Test Nombre");
        padrino.setTelefono("23123412");
        padrino.setCiudad("Test Ciudad");
        padrino.setPais("Test Pais");
        try {
            this.logica.guardarPadrino(padrino);
        } finally {
            assertEquals(0, this.sistema.getPadrinos().size());
        }
    }
    
    @Test(expected = LogicaNegocioException.class)
    public void guardarPadrinoTelefonoFaltanteTest() throws LogicaNegocioException {
        Padrino padrino = new Padrino();
        padrino.setTelefono(null);
        padrino.setMail("mail@mail.com");
        padrino.setNombre("Test Nombre");
        padrino.setApellido("Test Apellido");
        padrino.setCiudad("Test Ciudad");
        padrino.setPais("Test Pais");
        try {
            this.logica.guardarPadrino(padrino);
        } finally {
            assertEquals(0, this.sistema.getPadrinos().size());
        }
    }
    
    @Test(expected = LogicaNegocioException.class)
    public void guardarPadrinoCiudadFaltanteTest() throws LogicaNegocioException {
        Padrino padrino = new Padrino();
        padrino.setCiudad(null);
        padrino.setMail("mail@mail.com");
        padrino.setNombre("Test Nombre");
        padrino.setApellido("Test Apellido");
        padrino.setTelefono("23123412");
        padrino.setPais("Test Pais");
        try {
            this.logica.guardarPadrino(padrino);
        } finally {
            assertEquals(0, this.sistema.getPadrinos().size());
        }
    }
    
    @Test(expected = LogicaNegocioException.class)
    public void guardarPadrinoPaisFaltanteTest() throws LogicaNegocioException {
        Padrino padrino = new Padrino();
        padrino.setPais(null);
        padrino.setMail("mail@mail.com");
        padrino.setNombre("Test Nombre");
        padrino.setApellido("Test Apellido");
        padrino.setTelefono("23123412");
        padrino.setCiudad("Test Ciudad");
        try {
            this.logica.guardarPadrino(padrino);
        } finally {
            assertEquals(0, this.sistema.getPadrinos().size());
        }
    }
    
    @Test(expected = LogicaNegocioException.class)
    public void guardarPadrinoMalFormatoMailTest() throws LogicaNegocioException {
        Padrino padrino = new Padrino();
        padrino.setNombre("Test Nombre");
        padrino.setApellido("Test Apellido");
        padrino.setMail("@mail.com");
        padrino.setTelefono("23123412");
        padrino.setCiudad("Test Ciudad");
        padrino.setPais("Test Pais");
        try {
            this.logica.guardarPadrino(padrino);
        } finally {
            assertEquals(0, this.sistema.getPadrinos().size());
        }
    }
    
    @Test(expected = LogicaNegocioException.class)
    public void guardarPadrinoMontoDonacionInvalidoTest() throws LogicaNegocioException {
        Padrino padrino = new Padrino();
        padrino.setNombre("Test Nombre");
        padrino.setApellido("Test Apellido");
        padrino.setMail("mail@mail.com");
        padrino.setTelefono("23123412");
        padrino.setCiudad("Test Ciudad");
        padrino.setPais("Test Pais");
        padrino.setDonacion(new Donacion(0, "U$", FrecuenciaDonacion.MENSUAL, 
                MedioDonacion.TARJETA_CREDITO));
        try {
            this.logica.guardarPadrino(padrino);
        } finally {
            assertEquals(0, this.sistema.getPadrinos().size());
        }
    }
    
    @Test(expected = LogicaNegocioException.class)
    public void guardarPadrinoMonedaNullTest() throws LogicaNegocioException {
        Padrino padrino = new Padrino();
        padrino.setNombre("Test Nombre");
        padrino.setApellido("Test Apellido");
        padrino.setMail("mail@mail.com");
        padrino.setTelefono("23123412");
        padrino.setCiudad("Test Ciudad");
        padrino.setPais("Test Pais");
        padrino.setDonacion(new Donacion(300, null, FrecuenciaDonacion.MENSUAL, 
                MedioDonacion.TARJETA_CREDITO));
        try {
            this.logica.guardarPadrino(padrino);
        } finally {
            assertEquals(0, this.sistema.getPadrinos().size());
        }   
    }
}
