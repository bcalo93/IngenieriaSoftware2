package logicanegocio;

import dominio.Padrino;
import dominio.Sistema;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import logicanegocio.excepciones.LogicaNegocioException;

public class LogicaPadrino {
    
    private static final String REG_EMAIL = "^(.+)@(.+)$";
    
    private Sistema sistema;
    
    public LogicaPadrino(Sistema sistema) {
        this.sistema = sistema;
    }
    
    public void guardarPadrino(Padrino padrino) throws LogicaNegocioException {
        this.validarPadrino(padrino);
        padrino.setId(GeneradorId.getInstancia().generarId());
        this.sistema.agregarPadrino(padrino);
    }
    
    
    private void validarPadrino(Padrino padrino) throws LogicaNegocioException {
        if (!this.textoValido(padrino.getNombre() )) {
            throw new LogicaNegocioException("Nombre es requerido.");
        }
        
        if (!this.textoValido(padrino.getApellido())) {
            throw new LogicaNegocioException("Apellido es requerido.");
        }
        
        if (!this.textoValido(padrino.getCiudad())) {
            throw new LogicaNegocioException("Ciudad es requerido.");
        }
        
        if (!this.textoValido(padrino.getMail())) {
            throw new LogicaNegocioException("Correo es requerido.");
        }
        
        this.validarFormatoEmail(padrino.getMail());
        
        if (!this.textoValido(padrino.getPais())) {
            throw new LogicaNegocioException("Pais es requerido.");
        }
        
        if(!this.textoValido(padrino.getTelefono())) {
            throw new LogicaNegocioException("Telefono es requerido.");
        }
    }
    
    private boolean textoValido(String texto) {
        return texto != null && !texto.trim().equals("");
    }
    
    private void validarFormatoEmail(String email) throws LogicaNegocioException {
        Pattern pattern = Pattern.compile(REG_EMAIL);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()) {
            throw new LogicaNegocioException("El formato del correo no es valido.");
        }
    }
    
}