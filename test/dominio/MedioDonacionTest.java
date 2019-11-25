package dominio;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedioDonacionTest {
    
    @Test
    public void testToStringTarjetaDeCredito() {
        assertEquals("Tarjeta de credito", MedioDonacion.TARJETA_CREDITO.toString());
    }
    
    @Test
    public void testToStringTransferenciaBancaria() {
        assertEquals("Transferencia Bancaria", MedioDonacion.TRANSFERENCIA_BANCARIA
                .toString());
    }
}
