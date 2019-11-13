package dominio;

public enum MedioDonacion {
    TARJETA_CREDITO, TRANSFERENCIA_BANCARIA;
    
    @Override
    public String toString() {
        switch (this) {
            case TARJETA_CREDITO: return "Tarjeta de credito";
            default: return "Transferencia Bancaria";
        }
    }
}
