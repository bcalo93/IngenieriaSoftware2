package logicanegocio;

import dominio.Donacion;
import dominio.Padrino;
import dominio.Sistema;
import java.util.List;
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
        this.validarDonacion(padrino.getDonacion());
        if(padrino.getId() == null) {
            padrino.setId(GeneradorId.getInstancia().generarId());
            this.sistema.agregarPadrino(padrino);        
        
        } else {
            Padrino paraActualizar = this.getPadrinoPorId(padrino.getId());
            if(paraActualizar != null) {
                paraActualizar.actualizar(padrino);
            }
        }
    }
    
    public List<Padrino> getPadrinos() {
        return this.sistema.getPadrinos();
    }
    
    public Padrino getPadrinoPorId(Integer id) {
        return this.sistema.getPadrinos()
                .stream()
                .filter(padrino -> padrino.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
     
    private void validarPadrino(Padrino padrino) throws LogicaNegocioException {
        if (!this.textoValido(padrino.getNombre()) || padrino.getNombre().equals("Sin-Nombre")) {
            throw new LogicaNegocioException("Nombre es requerido.");
        }
        
        if (!this.textoValido(padrino.getApellido())) {
            throw new LogicaNegocioException("Apellido es requerido.");
        }
                
        if(!this.textoValido(padrino.getTelefono())) {
            throw new LogicaNegocioException("Telefono es requerido.");
        }
        
        if (!this.textoValido(padrino.getMail()) || padrino.getMail().equals("Sin-Mail")) {
            throw new LogicaNegocioException("Correo es requerido.");
        }
        
        this.validarFormatoEmail(padrino.getMail());
        
        if (!this.textoValido(padrino.getCiudad())) {
            throw new LogicaNegocioException("Ciudad es requerido.");
        }
        
        if (!this.textoValido(padrino.getPais())) {
            throw new LogicaNegocioException("Pais es requerido.");
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
    
    private void validarDonacion(Donacion donacion) throws LogicaNegocioException {
        if(donacion.getMontoDonacion() <= 0) {
            throw new LogicaNegocioException("Monto tiene que ser mayor a 0.");
        }
        
        if(!textoValido(donacion.getMoneda())) {
            throw new LogicaNegocioException("Moneda es requerido para una donacion.");
        }
    }
}
