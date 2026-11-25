Ejercicio 4: Servicio de Caché en Memoria

Contexto del problema: Una plataforma web necesita almacenar perfiles de usuario consultados frecuentemente en una estructura de caché en memoria para evitar consultas repetitivas al servidor principal. La memoria disponible es limitada, por lo que toda la aplicación debe compartir un único repositorio de caché sincronizado.

Objetivo de aprendizaje: Diseñar un Singleton funcional que gestione un estado interno dinámico accesible de forma transversal.

Requisitos funcionales:

Permitir almacenar, recuperar y eliminar elementos de la caché en memoria mediante claves únicas.

Incluir un mecanismo interno de validación para verificar la existencia de claves y actualizar datos almacenados.

Restricciones técnicas:

La estructura de datos interna que almacena la caché debe estar encapsulada dentro de la clase Singleton y protegida contra modificaciones externas no autorizadas.

La implementación debe asegurar que la inicialización de la caché ocurra de forma diferida solo cuando se solicite por primera vez.

# Ejercicio 4: Pizarra Precio Dólar (Patrón Singleton)

## Temática

Banca Digital y Tradicional — Cotización centralizada de monedas compartida entre canales.

## Consigna

El banco necesita mostrar y actualizar el precio del dólar y del euro en tiempo real para todos sus canales (App móvil, Home Banking y mesas de operación). Si cada módulo manejara su propia lista de cotizaciones en memoria, una actualización hecha por Gerencia no se reflejaría al instante en la aplicación de los clientes.

El objetivo es aplicar el patrón Singleton para centralizar el diccionario de precios en una única pizarra compartida, permitiendo actualizar valores y consultarlos siempre desde la misma referencia en memoria.

## Explicación lógica

1. Atributos: En la clase PizarraPrecioDolar se declara precios (private Map<String, Double>) para guardar cada moneda junto con su cotización actual, y instancia (private static PizarraPrecioDolar), que va a conservar la única referencia en memoria para que todos los sectores consulten y actualicen los mismos valores sin duplicar el mapa.
2. Instancia única: El constructor se define como private para impedir que se creen pizarras paralelas usando new, y además inicializa el HashMap cargando los valores base de DOLAR (1580.00) y EURO (1725.00) recién cuando se solicita por primera vez. El método getInstancia() controla el acceso: revisa si instancia es null (es decir, si todavía no se creó), la instancia una sola vez y en las siguientes llamadas devuelve siempre ese mismo objeto ya existente.
3. Asignación y Acceso: En Main, primero se obtiene la instancia desde el lado de la app (pizarraApp) y se consulta la cotización inicial con verPrecio("DOLAR"). Luego se pide la referencia desde gerencia (pizarraGerencia) y se actualiza el precio usando cambiarPrecio("DOLAR", 1630.00), lo que sobrescribe el valor en el mapa interno. Al volver a consultar desde pizarraApp se ve el nuevo precio al instante, y la comparación pizarApp == pizarraGerencia confirma que ambas variables apuntan exactamente al mismo objeto en memoria.



## Estructura del ejercicio

* PizarraPrecioDolar.java: Implementa el Singleton con el mapa encapsulado de cotizaciones y los métodos cambiarPrecio(...) y verPrecio(...)
* Main.java: Simula la consulta desde la App, la actualización desde Gerencia y verifica que comparten la misma instancia


