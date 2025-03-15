package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.util.Arrays;
import java.util.PriorityQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EjercicioArrays {
    
    private static final Logger logger = LogManager.getLogger(EjercicioArrays.class);
    
    // Ejercicio 1
    public static int riquezaMaxima(int[][] cuentas) {
        int maxRiqueza = 0;
        for (int[] cliente : cuentas) {
            int riquezaCliente = Arrays.stream(cliente).sum();
            maxRiqueza = Math.max(maxRiqueza, riquezaCliente);
        }
        logger.info("Riqueza máxima encontrada: " + maxRiqueza);
        return maxRiqueza;
    }
    
    // Ejercicio 2
    public static int[][] ordenarDiagonales(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        
        logger.info("Iniciando ordenamiento de diagonales");
        

        for (int i = 0; i < m; i++) {
            ordenarDiagonal(mat, i, 0);
        }
        
        for (int j = 1; j < n; j++) {
            ordenarDiagonal(mat, 0, j);
        }
        
        logger.info("Finalizado ordenamiento de diagonales");
        return mat;
    }
    
    private static void ordenarDiagonal(int[][] mat, int row, int col) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = row, j = col;
        
        while (i < m && j < n) {
            pq.add(mat[i][j]);
            i++;
            j++;
        }
        
        i = row;
        j = col;
        while (i < m && j < n) {
            mat[i][j] = pq.poll();
            i++;
            j++;
        }
    }
    
    // Ejercicio 3
    public static int sumaMatriz(int[][] mat) {
        int suma = 0;
        for (int[] fila : mat) {
            for (int num : fila) {
                suma += num;
            }
        }
        logger.info("Suma total de la matriz: " + suma);
        return suma;
    }
}
