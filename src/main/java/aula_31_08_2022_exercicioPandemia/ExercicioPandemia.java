/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_31_08_2022_exercicioPandemia;

import static aula_31_08_2022_quickSortInterativo.QuickSortIterativo.quickSort;
import static aula_31_08_22_buscaBinaria.BuscaBinaria.buscaBinaria;
import java.util.Random;

/**
 *
 * @author maxna
 */
public class ExercicioPandemia {
    
    public static void main(String[] args) {
        
        // quantidade de pessoas
        int[] values = new int[100];
        
        // gerador de idade de pessoas 
        Random r = new Random(100);
        for (int i = 0; i < values.length; i++) {
            values[i] = r.nextInt(100);
        }
        
        quickSort(values, 0, values.length - 1);
        
        // idade da pessoa a ser buscada
        int dia = buscaBinaria(values, 50);
        
        // intervalo de dias 
        int qtdDias = (dia/2);
        
        
    }
    
}
