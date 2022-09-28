/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.alg;

/**
 *
 * @author maxna
 */
public class App {

    static int[] lista = {5, 4, 3, 2, 1};
    static int fieldsChecked = 0;

    public static void main(String[] args) {
        
        while (fieldsChecked < lista.length - 1){
            int pivo = lista[lista.length - 1];
            int posicaoFila = 0;

            for (int j = 0; j < lista.length - 1; j++) {
                if (lista[j] < pivo) {
                    changePositions(lista, posicaoFila, j);
                    posicaoFila++;
                }
            }
            changePositions(lista, posicaoFila, lista.length - 1);
            fieldsChecked++;
        }
    }

    public static void changePositions(int[] lista, int i, int j) {
        int aux = lista[i];
        lista[j] = lista[i];
        lista[i] = aux;
    }

    public static void partitionate(int[] lista, int position) {
        
    }
}
