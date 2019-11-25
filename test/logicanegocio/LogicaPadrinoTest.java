package logicanegocio;

import dominio.Donacion;
import dominio.FrecuenciaDonacion;
import dominio.MedioDonacion;
import dominio.Padrino;
import dominio.Sistema;
import java.util.ArrayList;
import java.util.List;
import logicanegocio.excepciones.LogicaNegocioException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
        assertEquals(2000, resultado.getDonacion().getMontoDonacion());
        assertEquals("U$", resultado.getDonacion().getMoneda());
        assertEquals(FrecuenciaDonacion.MENSUAL, resultado.getDonacion()
                .getFrecuencia());
        assertEquals(MedioDonacion.TARJETA_CREDITO, resultado.getDonacion()
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
    
    @Test(expected = LogicaNegocioException.class)
    public void guardarPadrinoSinNombreTest() throws LogicaNegocioException {
        Padrino padrino = new Padrino();
        padrino.setApellido("Test Apellido");
        padrino.setMail("mail@mail.com");
        padrino.setTelefono("23123412");
        padrino.setCiudad("Test Ciudad");
        padrino.setPais("Test Pais");
        padrino.setDonacion(new Donacion(300, "U$", FrecuenciaDonacion.MENSUAL, 
                MedioDonacion.TARJETA_CREDITO));
        try {
            this.logica.guardarPadrino(padrino);
        } finally {
            assertEquals(0, this.sistema.getPadrinos().size());
        }   
    }
    
    @Test(expected = LogicaNegocioException.class)
    public void guardarPadrinoSinMailTest() throws LogicaNegocioException {
        Padrino padrino = new Padrino();
        padrino.setNombre("Test Nombre");
        padrino.setApellido("Test Apellido");
        padrino.setTelefono("23123412");
        padrino.setCiudad("Test Ciudad");
        padrino.setPais("Test Pais");
        padrino.setDonacion(new Donacion(300, "U$", FrecuenciaDonacion.MENSUAL, 
                MedioDonacion.TARJETA_CREDITO));
        try {
            this.logica.guardarPadrino(padrino);
        } finally {
            assertEquals(0, this.sistema.getPadrinos().size());
        }   
    }
    
    @Test
    public void guardarPadrinoConId() throws LogicaNegocioException {
        Integer idEsperado = 1;
        Padrino padrinoConId = new Padrino("Nombre", "email@email.com", "Apellido", 
                "Telefono", "Ciudad", "Pais", new Donacion());
        padrinoConId.setId(idEsperado);
        sistema.agregarPadrino(padrinoConId);
        
        Padrino padrino = new Padrino();
        padrino.setId(idEsperado);
        padrino.setNombre("Test Nombre");
        padrino.setApellido("Test Apellido");
        padrino.setMail("mail@mail.com");
        padrino.setTelefono("23123412");
        padrino.setCiudad("Test Ciudad");
        padrino.setPais("Test Pais");
        padrino.setDonacion(new Donacion(2000, "U$", FrecuenciaDonacion.MENSUAL, 
                MedioDonacion.TARJETA_CREDITO));
        
        this.logica.guardarPadrino(padrino);
        
        assertEquals(1, sistema.getPadrinos().size());
        
        Padrino resultado = logica.getPadrinoPorId(1);
        assertEquals("Test Nombre", resultado.getNombre());
        assertEquals("Test Apellido", resultado.getApellido());
        assertEquals("mail@mail.com", resultado.getMail());
        assertEquals("23123412", resultado.getTelefono());
        assertEquals("Test Ciudad", resultado.getCiudad());
        assertEquals("Test Pais", resultado.getPais());
        assertEquals(Integer.valueOf(GeneradorId.getInstancia().getIdActual()), 
                resultado.getId());
        assertEquals(0, resultado.getQuiereApadrinar().size());
        assertEquals(2000, resultado.getDonacion().getMontoDonacion());
        assertEquals("U$", resultado.getDonacion().getMoneda());
        assertEquals(FrecuenciaDonacion.MENSUAL, resultado.getDonacion()
                .getFrecuencia());
        assertEquals(MedioDonacion.TARJETA_CREDITO, resultado.getDonacion()
                .getMedio());
    }
    
    @Test
    public void guardarPadrinoConIdInexistente() throws LogicaNegocioException {
        Padrino padrinoConId = new Padrino("Nombre", "email@email.com", "Apellido", 
                "Telefono", "Ciudad", "Pais", new Donacion(300, "U$", 
                        FrecuenciaDonacion.MENSUAL, MedioDonacion.TARJETA_CREDITO));
        padrinoConId.setId(1);
        sistema.agregarPadrino(padrinoConId);
        
        Padrino padrino = new Padrino();
        padrino.setId(20);
        padrino.setNombre("Test Nombre");
        padrino.setApellido("Test Apellido");
        padrino.setMail("mail@mail.com");
        padrino.setTelefono("23123412");
        padrino.setCiudad("Test Ciudad");
        padrino.setPais("Test Pais");
        padrino.setDonacion(new Donacion(2000, "U$", FrecuenciaDonacion.MENSUAL, 
                MedioDonacion.TARJETA_CREDITO));
        
        this.logica.guardarPadrino(padrino);
        
        assertEquals(1, sistema.getPadrinos().size());
        
        Padrino resultado = logica.getPadrinoPorId(1);
        assertEquals("Nombre", resultado.getNombre());
        assertEquals("Apellido", resultado.getApellido());
        assertEquals("email@email.com", resultado.getMail());
        assertEquals("Telefono", resultado.getTelefono());
        assertEquals("Ciudad", resultado.getCiudad());
        assertEquals("Pais", resultado.getPais());
        assertEquals(Integer.valueOf(GeneradorId.getInstancia().getIdActual()), 
                resultado.getId());
        assertEquals(0, resultado.getQuiereApadrinar().size());
        
        assertEquals(300, resultado.getDonacion().getMontoDonacion());
        assertEquals("U$", resultado.getDonacion().getMoneda());
        assertEquals(FrecuenciaDonacion.MENSUAL, resultado.getDonacion()
                .getFrecuencia());
        assertEquals(MedioDonacion.TARJETA_CREDITO, resultado.getDonacion()
                .getMedio());
    }
    
    @Test
    public void getPadrinosTest() {
        sistema.setPadrinos(crearPadrinos(20));
        
        List<Padrino> resultado = logica.getPadrinos();
        assertEquals(20, resultado.size());
    }
    
    @Test
    public void borrarPadrinoTest() {
        ArrayList<Padrino> padrinos = crearPadrinos(20);
        sistema.setPadrinos(padrinos);
        Padrino paraBorrar = padrinos.get(10);
        Integer idBorrado = paraBorrar.getId();
        
        logica.borrarPadrino(paraBorrar);
        assertEquals(19, padrinos.size());
        assertFalse(padrinos.stream().anyMatch(padrino -> 
                padrino.getId() == idBorrado));
    }
    
    @Test
    public void borrarPadrinoNullTest() {
        ArrayList<Padrino> padrinos = crearPadrinos(20);
        sistema.setPadrinos(padrinos);
        logica.borrarPadrino(null);
        assertEquals(20, padrinos.size());
    }
    
    private ArrayList<Padrino> crearPadrinos(int cantidad) {
        ArrayList<Padrino> padrinos = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            Padrino paraAgregar = new Padrino("Nombre" + i, "mail" + i + "@mail.com", 
                    "Apellido" + i, "123123123","Montevideo", "Uruguay", 
                    new Donacion(2000, "U$", FrecuenciaDonacion.MENSUAL,
                            MedioDonacion.TARJETA_CREDITO));
            paraAgregar.setId(i);
            padrinos.add(paraAgregar);
        }
        return padrinos;
    }
}
