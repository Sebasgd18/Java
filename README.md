# Laboratorio de Algoritmos de Ordenamiento en Java

Este proyecto implementa diferentes **algoritmos de ordenamiento** en Java con el objetivo de comparar su rendimiento.

El programa genera un arreglo de números y aplica distintos métodos de ordenamiento, midiendo:

- Tiempo de ejecución (nanosegundos)
- Número de iteraciones realizadas

## Algoritmos implementados

Los algoritmos incluidos en este laboratorio son:

- Burbuja (Bubble Sort) – versión con 4 pasadas
- Inserción (Insertion Sort)
- Selección (Selection Sort)
- Merge Sort
- Quick Sort

Cada algoritmo trabaja sobre una copia del mismo arreglo para poder comparar su rendimiento de forma justa.

## Funcionamiento del programa

1. Se genera un arreglo de números.
2. Se crea una copia del arreglo para cada algoritmo.
3. Se ejecuta cada método de ordenamiento.
4. Se mide el tiempo utilizando `System.nanoTime()`.
5. Se cuentan las iteraciones realizadas.
6. Se muestran los resultados en consola.

## Ejemplo de ejecución
RESULTADOS

Burbuja (4 pasadas)
Tiempo: 18600 ns
Iteraciones: 390

Insercion
Tiempo: 77600 ns
Iteraciones: 2484

Seleccion
Tiempo: 135800 ns
Iteraciones: 4950

Merge
Tiempo: 54100 ns
Iteraciones: 540

Quick
Tiempo: 31900 ns
Iteraciones: 628
