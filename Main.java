public class Main {
    public static void main(String[] args) {
        PizarraPrecioDolar pizarraApp = PizarraPrecioDolar.getInstancia();
        PizarraPrecioDolar pizarraGerencia = PizarraPrecioDolar.getInstancia();

        System.out.println("Precio inicial Dólar en App: $" + pizarraApp.verPrecio("DOLAR"));

        // Gerencia sube el precio en la pizarra
        pizarraGerencia.cambiarPrecio("DOLAR", 1630.00);

        // La App automáticamente muestra el nuevo precio
        System.out.println("Nuevo precio Dólar en App: $" + pizarraApp.verPrecio("DOLAR"));
        System.out.println("¿Misma pizarra?: " + (pizarraApp == pizarraGerencia));
    }
}
