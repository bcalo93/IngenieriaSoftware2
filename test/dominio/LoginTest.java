package dominio;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LoginTest {
    
    @Test
    public void testConstructor() {
        Login login = new Login("usuario", "contrasenia");
        assertEquals("usuario", login.getMail());
        assertEquals("contrasenia", login.getPass());
    }
    
    @Test
    public void testSetMail() {
        Login login = new Login("usuario", "contrasenia");
        login.setMail("usuarionuevo");
        assertEquals("usuarionuevo", login.getMail());
        assertEquals("contrasenia", login.getPass());
    }
    
    @Test
    public void testSetPass() {
        Login login = new Login("usuario", "contrasenia");
        login.setPass("nuevopass");
        assertEquals("usuario", login.getMail());
        assertEquals("nuevopass", login.getPass());
    }
    
    @Test
    public void testValidarUsuarioOkTest() {
        Login login = new Login("admin", "admin");
        boolean resultado = login.validarUsuario("admin", "admin");
        assertTrue(resultado);
    }
    
    @Test
    public void testValidarUsuarioInvalidoTest() {
        Login login = new Login("admin", "admin");
        boolean resultado = login.validarUsuario("invalido", "admin");
        assertFalse(resultado);
    }
    
    @Test
    public void testValidarContraseniaInvalidaTest() {
        Login login = new Login("admin", "admin");
        boolean resultado = login.validarUsuario("admin", "invalida");
        assertFalse(resultado);
    }
}
