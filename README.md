# Calculadora de ventas Wtech — Patrón de diseño Visitor

Aplicación del patrón **Visitor** (GoF, de comportamiento) para una empresa que vende
productos de tecnología. Se calculan el **subtotal**, el **costo de envío** y el **total**
de un pedido **sin modificar las clases de los productos** y sin usar `instanceof`,
`getClass()` ni condicionales por tipo.

## Regla de envío de Wtech

Por cada 100 gramos de peso, el producto paga un 2% de envío calculado sobre su precio:

```
porcentajeEnvio = (pesoGramos / 100) * 2
costoEnvio      = precio * porcentajeEnvio / 100
```

| Producto              | Precio (USD) | Peso (g) |
|-----------------------|--------------|----------|
| Tablet                | 200          | 250      |
| Computadora portátil  | 400          | 1000     |
| Computadora de torre  | 600          | 6000     |
| Televisión            | 300          | 4000     |

## Estructura de paquetes

```
src/
├── model/                      Producto (interfaz) y productos concretos
│   ├── Producto.java           aceptar(Visitante)
│   ├── Tablet.java             precio 200, peso 250
│   ├── Portatil.java           precio 400, peso 1000
│   ├── ComputadoraTorre.java   precio 600, peso 6000
│   ├── Television.java         precio 300, peso 4000
│   └── Pedido.java             colección de productos con cantidades
├── visitor/
│   ├── Visitante.java                  método visitar() por cada producto (doble despacho)
│   ├── CalculadorSubtotalVisitor.java  acumula la suma de precios
│   └── CalculadorEnvioVisitor.java     acumula el costo de envío
└── main/
    └── Main.java               escenario de prueba
```

Cada producto implementa `aceptar(Visitante v)` con una sola línea, `v.visitar(this)`, de
modo que es el propio objeto quien indica qué método del visitante corresponde. Las clases
de producto solo guardan datos; toda la lógica vive en los visitantes.

## Compilar y ejecutar

Requiere Java 21. Sin Maven ni Gradle:

```bash
javac -d bin $(find src -name '*.java')
java -cp bin main.Main
```

## Salida en consola

Escenario de prueba: **2 tablets, 1 computadora portátil, 1 computadora de torre y 1
televisión**.

```
Subtotal: $1700.00
Envío:    $1060.00
Total:    $2760.00
```

- Subtotal: `2·200 + 400 + 600 + 300 = 1700`
- Envío: `2·10 + 80 + 720 + 240 = 1060`
- Total: `1700 + 1060 = 2760`
