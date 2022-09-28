/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_31_08_22_buscaBinaria;

/**
 *
 * @author maxna
 */
public class BuscaBinaria {

    public static int buscaBinaria(int[] lista, int elemento) {
        int esq = 0, dir = lista.length - 1;

        while (esq <= dir) {
            int mid = esq + (dir - esq) / 2;

            if (lista[mid] == elemento) {
                return mid;
            }

            if (lista[mid] < elemento) {
                esq = mid + 1;
            } else {
                dir = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] lista = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int x = 4;

        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i] + " ");
        }

        System.out.println();

        int result = buscaBinaria(lista, x);

        if (result == -1) {
            System.out.println("Não Encontrado");
        } else {
            System.out.println("O elemento " + x + " foi encontrado na posição " + result);
        }
    }

}
