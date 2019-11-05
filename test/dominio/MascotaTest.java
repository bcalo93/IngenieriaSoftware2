/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import javax.swing.ImageIcon;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author marce
 */
public class MascotaTest {
    private Mascota mascota;
    
    @Before
    public void setUp() {
        mascota = new Mascota();
    }
    
    @Test
    public void testConstructorSinParametros() {
        Mascota unaMascota = new Mascota();
        assertEquals("Sin-Nombre", unaMascota.getNombre());
        assertEquals(0, unaMascota.getPeso(),0);
        assertEquals(0, unaMascota.getAltura(),0);
        assertNull(unaMascota.getFoto());
        assertEquals("Sin-Comentarios", unaMascota.getComentarios());
        assertEquals(Mascota.TIPO_POR_DEFECTO, unaMascota.getTipo());
    }
    
     @Test
    public void testConstructorPorParametros() {
        Mascota unaMascota = new Mascota("Rasta", 1.1, 2.3, "Es rubio", "Perro");
        assertEquals("Rasta", unaMascota.getNombre());
        assertEquals(1.1, unaMascota.getAltura(), 0);
        assertEquals(2.3, unaMascota.getPeso(), 0);
        assertEquals("Es rubio", unaMascota.getComentarios());
        assertEquals("Perro", unaMascota.getTipo());
        assertEquals(null, unaMascota.getFoto());
    }
     @Test
    public void testConstructorPorParametrosConPesoYAlturaMenoresQue0() {
        Mascota unaMascota = new Mascota("Pedro", -1.1, -2.3, "Es rubio", "Gato");
        assertEquals("Pedro", unaMascota.getNombre());
        assertEquals(0.0, unaMascota.getAltura(), 0);
        assertEquals(0.0, unaMascota.getPeso(), 0);
        assertEquals("Es rubio", unaMascota.getComentarios());
        assertEquals("Gato", unaMascota.getTipo());
        assertEquals(null, unaMascota.getFoto());
    }
    
     @Test
    public void testConstructorPorParametrosConNombreYComentariosVacios() {
        Mascota unaMascota = new Mascota("", -1.1, -2.3, "", "");
        assertEquals("Sin-Nombre", unaMascota.getNombre());
        assertEquals(0.0, unaMascota.getAltura(), 0);
        assertEquals(0.0, unaMascota.getPeso(), 0);
        assertEquals("Sin-Comentarios", unaMascota.getComentarios());
        assertEquals(Mascota.TIPO_POR_DEFECTO, unaMascota.getTipo());
        assertEquals(null, unaMascota.getFoto());
    }
    
    @Test
    public void testSetNombre(){
        mascota.setNombre("Rasta");
        assertEquals("Rasta", mascota.getNombre());
    }
    
    @Test
    public void testSetNombreVacio(){
        mascota.setNombre("");
        assertEquals("Sin-Nombre", mascota.getNombre());
    }
    
    @Test
    public void testSetNombreNull(){
        mascota.setNombre(null);
        assertEquals("Sin-Nombre", mascota.getNombre());
    }
     @Test
    public void testSetComentarios(){
        mascota.setComentarios("Es rubio");
        assertEquals("Es rubio", mascota.getComentarios());
    }
    
    @Test
    public void testSetComentariosVacio(){
        mascota.setComentarios("");
        assertEquals("Sin-Comentarios", mascota.getComentarios());
    }
    
    @Test
    public void testSetComentariosNull(){
        mascota.setComentarios(null);
        assertEquals("Sin-Comentarios", mascota.getComentarios());
    }
    
    @Test
    public void testSetRutaFoto(){
        ImageIcon imagen = new ImageIcon("/interfaz.images/perro.png");
        mascota.setFoto(imagen);
        assertEquals(imagen, mascota.getFoto());
    }
    
    @Test
    public void testSetRutaFotoVacia(){
        mascota.setFoto(null);
        assertEquals(null, mascota.getFoto());
    }
    
    @Test
    public void testSetTipo() {
        mascota.setTipo("Caballo");
        assertEquals("Caballo", mascota.getTipo());
    }
    
    @Test
    public void testSetTipoVacio() {
        mascota.setTipo("Caballo");
        assertEquals("Caballo", mascota.getTipo());
        mascota.setTipo("");
        assertEquals("Perro", mascota.getTipo());
    }
    
    @Test
    public void testSetTipoNull() {
        mascota.setTipo(null);
        assertEquals("Perro", mascota.getTipo());
    }
    
    @Test
    public void testToString(){
        String resToString = mascota.toString();
        String nombre = mascota.getNombre();
        double altura = mascota.getAltura();
        double peso = mascota.getPeso();
        String comentarios = mascota.getComentarios();
        assertEquals("Mascota{" + "nombre=" + nombre + ", altura=" + altura + ", peso=" + peso + ", comentarios=" + comentarios + '}', resToString);
    }
    
    
    @Test
    public void testNombreValidoOk() {
        mascota.setNombre("Nombre valido");
        boolean resultado = mascota.nombreValido();
        assertTrue(resultado);
        assertEquals("Nombre valido", mascota.getNombre());
    }
    
    @Test
    public void testNombreValidoEspacioBlanco() {
        mascota.setNombre(" ");
        boolean resultado = mascota.nombreValido();
        assertFalse(resultado);
        assertEquals(" ", mascota.getNombre());
    }
    
    @Test
    public void testAlturaValidaOk() {
        mascota.setAltura(2.0);
        boolean resultado = mascota.alturaValida();
        assertTrue(resultado);
        assertEquals(2.0, mascota.getAltura(), 0);
    }
    
    @Test
    public void testAlturaValidaCero() {
        mascota.setAltura(0.0);
        boolean resultado = mascota.alturaValida();
        assertFalse(resultado);
        assertEquals(0.0, mascota.getAltura(), 0);
    }
    
    @Test
    public void testPesoValidoOk() {
        mascota.setPeso(5.0);
        boolean resultado = mascota.pesoValido();
        assertTrue(resultado);
        assertEquals(5.0, mascota.getPeso(), 0);
    }
    
    @Test
    public void testPesoValidaCero() {
        mascota.setAltura(0.0);
        boolean resultado = mascota.alturaValida();
        assertFalse(resultado);
        assertEquals(0.0, mascota.getAltura(), 0);
    }
    
    @Test
    public void testActualizarMascota() {
        ImageIcon imagen = new ImageIcon("/interfaz.images/gato.png");
        Mascota nuevosValores = new Mascota("Misifu", 20.0, 10.0, "Es un gato mimoso", 
                "Gato");
        nuevosValores.setFoto(imagen);
        mascota.actualizar(nuevosValores);
        assertEquals("Misifu", mascota.getNombre());
        assertEquals(20.0, mascota.getAltura(), 0);
        assertEquals(10.0, mascota.getPeso(), 0);
        assertEquals("Es un gato mimoso", mascota.getComentarios());
        assertEquals("Gato", mascota.getTipo());
        assertEquals(imagen, mascota.getFoto());
    }
    
    @Test
    public void testActualizarImagenNull() {
        ImageIcon imagen = new ImageIcon("/interfaz.images/gato.png");
        mascota.setFoto(imagen);
        Mascota nuevosValores = new Mascota("Misifu", 20.0, 10.0, "Es un gato mimoso", 
                "Gato");
        mascota.actualizar(nuevosValores);
        assertEquals("Misifu", mascota.getNombre());
        assertEquals(20.0, mascota.getAltura(), 0);
        assertEquals(10.0, mascota.getPeso(), 0);
        assertEquals("Es un gato mimoso", mascota.getComentarios());
        assertEquals("Gato", mascota.getTipo());
        assertEquals(imagen, mascota.getFoto());
    }
}
