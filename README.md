# Tienda de Sudaderas - Java Swing Project

Este es un proyecto de aplicación de escritorio desarrollado en Java utilizando la biblioteca **Swing**. 
Permite simular el proceso de compra de una tienda de ropa con una interfaz gráfica.

## Características

- **Visual**: Visualización de productos con imágenes, nombres y precios.
- **Carrito de Compras**: Agregado el objeto con selección de tallas.
- **Cálculo en el pago**: Actualización automática del total de la compra.
- **Atajos de Teclado**: 
  - `Ctrl + F` para finalizar compra.
  - `Ctrl + P` para realizar el pago.
 
    
- Estructura

- `Proyecto.java`: Clase principal que lanza la aplicación.
- `Ventana.java`: Interfaz del catálogo y carrito.
- `VentanaPago.java`: Interfaz de confirmación de pago.
- `/src/proyecto/*.jpg`: Recursos visuales de las sudaderas.

## Ejecución

1. Clona este repositorio.
2. Asegúrate de tener las imágenes (`sudadera1.jpg`, etc.) en la carpeta del paquete `proyecto`.
3. Compila y ejecuta la clase `Proyecto.java`.

```bash
javac proyecto/*.java
java proyecto.Proyecto
