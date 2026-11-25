import java.util.HashMap;
import java.util.Map;

public class PizarraPrecioDolar {
    private static PizarraPrecioDolar instancia;
    private Map<String, Double> precios;

    private PizarraPrecioDolar() {
        precios = new HashMap<>();
        precios.put("DOLAR", 1580.00);
        precios.put("EURO", 1725.00);
    }

    public static PizarraPrecioDolar getInstancia() {
        if (instancia == null) {
            instancia = new PizarraPrecioDolar();
        }
        return instancia;
    }

    public void cambiarPrecio(String moneda, double nuevoPrecio) {
        precios.put(moneda, nuevoPrecio);
        System.out.println("[PIZARRA] Nuevo precio de " + moneda + ": $" + nuevoPrecio);
    }

    public double verPrecio(String moneda) {
        return precios.getOrDefault(moneda, 0.0);
    }
}