package logicanegocio;

import dominio.Mascota;
import dominio.Sistema;
import java.util.List;
import java.util.stream.Collectors;

public class LogicaMascota {
    private Sistema sistema;
    
    public LogicaMascota(Sistema sistema) {
        this.sistema = sistema;
    }
    
    public List<Mascota> getMascotasExcluyendo(List<Mascota> escluir) {
        return this.sistema
                .getMascotas()
                .stream()
                .filter(mascota -> !escluir.contains(mascota))
                .collect(Collectors.toList());
    }
    
    public Mascota getMascotaPorNombre(String nombre) {
        return this.sistema
                .getMascotas()
                .stream()
                .filter(mascota -> mascota.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }
    
}
