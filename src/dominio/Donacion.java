package dominio;

public class Donacion {
    public static final String MONEDA_POR_DEFECTO = "USD";
    
    private int montoDonacion;
    private String moneda;
    private FrecuenciaDonacion frecuencia;
    private MedioDonacion medio;

    public Donacion() {
        this.frecuencia = FrecuenciaDonacion.UNA_VEZ;
        this.medio = MedioDonacion.TARJETA_CREDITO;
        this.moneda = MONEDA_POR_DEFECTO;
    }
    
    public Donacion(int montoDonacion, String moneda, FrecuenciaDonacion frecuencia, 
            MedioDonacion medio) {
        this.montoDonacion = montoDonacion;
        this.moneda = moneda;
        this.frecuencia = frecuencia;
        this.medio = medio;
    }
    
    public Donacion(Donacion donacion) {
        this.montoDonacion = donacion.getMontoDonacion();
        this.moneda  = donacion.getMoneda();
        this.frecuencia = donacion.getFrecuencia();
        this.medio = donacion.getMedio();
    }
    
    public int getMontoDonacion() {
        return montoDonacion;
    }

    public void setMontoDonacion(int montoDonacion) {
        this.montoDonacion = montoDonacion;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public FrecuenciaDonacion getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(FrecuenciaDonacion frecuencia) {
        this.frecuencia = frecuencia;
    }

    public MedioDonacion getMedio() {
        return medio;
    }

    public void setMedio(MedioDonacion medio) {
        this.medio = medio;
    }
    
}