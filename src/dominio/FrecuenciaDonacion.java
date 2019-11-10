package dominio;

public enum FrecuenciaDonacion {
    UNA_VEZ, MENSUAL, TRIMESTRAL, ANUAL;
    
    @Override
    public String toString() {
        switch (this) {
            case UNA_VEZ: return "Una vez";
            case MENSUAL: return "Mensual";
            case TRIMESTRAL: return "Trimestral";
            default: return "Anual";
        }
    }
}
