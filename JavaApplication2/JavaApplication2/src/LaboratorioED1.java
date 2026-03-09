import java.util.Random;

public class LaboratorioED1 {

    static long itBurbuja = 0;
    static long itInsercion = 0;
    static long itSeleccion = 0;
    static long itMerge = 0;
    static long itQuick = 0;

    public static void main(String[] args) {

        int n = 100;
        int[] base = new int[n];
        Random r = new Random();

        // Generar arreglo aleatorio
        for (int i = 0; i < n; i++) {
            base[i] = r.nextInt(1000);
        }

        // BURBUJA (4 PASADAS)
        int[] a1 = base.clone();
        long inicio = System.nanoTime();
        burbuja4Pasadas(a1);
        long fin = System.nanoTime();
        long tiempoBurbuja = fin - inicio;

        // INSERCION 
        int[] a2 = base.clone();
        inicio = System.nanoTime();
        insercion(a2);
        fin = System.nanoTime();
        long tiempoInsercion = fin - inicio;

        // ================= SELECCION 
        int[] a3 = base.clone();
        inicio = System.nanoTime();
        seleccion(a3);
        fin = System.nanoTime();
        long tiempoSeleccion = fin - inicio;

        //  MERGE 
        int[] a4 = base.clone();
        inicio = System.nanoTime();
        mergeSort(a4, 0, a4.length - 1);
        fin = System.nanoTime();
        long tiempoMerge = fin - inicio;

        // QUICK 
        int[] a5 = base.clone();
        inicio = System.nanoTime();
        quickSort(a5, 0, a5.length - 1);
        fin = System.nanoTime();
        long tiempoQuick = fin - inicio;

        //  RESULTADOS 
        System.out.println(" RESULTADOS ");

        System.out.println("\nBurbuja (4 pasadas)");
        System.out.println("Tiempo: " + tiempoBurbuja + " ns");
        System.out.println("Iteraciones: " + itBurbuja);

        System.out.println("\nInsercion");
        System.out.println("Tiempo: " + tiempoInsercion + " ns");
        System.out.println("Iteraciones: " + itInsercion);

        System.out.println("\nSeleccion");
        System.out.println("Tiempo: " + tiempoSeleccion + " ns");
        System.out.println("Iteraciones: " + itSeleccion);

        System.out.println("\nMerge");
        System.out.println("Tiempo: " + tiempoMerge + " ns");
        System.out.println("Iteraciones: " + itMerge);

        System.out.println("\nQuick");
        System.out.println("Tiempo: " + tiempoQuick + " ns");
        System.out.println("Iteraciones: " + itQuick);
    }

    // bURBUJA 4 PASADAS 
    static void burbuja4Pasadas(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < 4; i++) {  // SOLO 4 PASADAS
            for (int j = 0; j < n - i - 1; j++) {
                itBurbuja++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //  INSERCION
    static void insercion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                itInsercion++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }

    //  SELECCION 
    static void seleccion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                itSeleccion++;
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    //  MERGE 
    static void mergeSort(int[] arr, int izq, int der) {
        if (izq < der) {
            int mid = (izq + der) / 2;
            mergeSort(arr, izq, mid);
            mergeSort(arr, mid + 1, der);
            merge(arr, izq, mid, der);
        }
    }

    static void merge(int[] arr, int izq, int mid, int der) {
        int n1 = mid - izq + 1;
        int n2 = der - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[izq + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = izq;

        while (i < n1 && j < n2) {
            itMerge++;
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    //  QUICK 
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            itQuick++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}

/*
---------------------------------------------------------
RESPUESTAS DEL LABORATORIO

1) ¿Cuál algoritmo "mueve" más elementos?

El algoritmo que más mueve elementos es Burbuja, ya que 
realiza múltiples intercambios cuando los elementos 
están desordenados. Esto provoca más movimientos en 
comparación con algoritmos como Merge o Quick, que 
optimizan la cantidad de intercambios.

2) ¿Cuál fue más fácil de entender y por qué?

El algoritmo más fácil de entender fue Burbuja, porque 
su lógica es directa: compara elementos consecutivos 
y los intercambia si están en el orden incorrecto. 
No utiliza recursividad ni divisiones complejas.
---------------------------------------------------------
*/