/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_31_08_2022_quickSortInterativo;

import java.util.Random;

/**
 *
 * @author maxna
 */
public class QuickSortIterativo {

    private static void troca(int[] lista, int i, int j) {
        int aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }

    private static int particiona(int[] lista, int esq, int dir) {
        int pivotValue = lista[dir];
        int i = (esq - 1);

        for (int j = esq; j <= dir - 1; j++) {
            if (lista[j] <= pivotValue) {
                i++;
                troca(lista, i, j);
            }
        }

        i++;
        troca(lista, i, dir);
        return i;

    }

    public static void quickSort(int[] lista, int indiceEsq, int indiceDir) {
        Pilha pilha = new Pilha(indiceDir - (indiceEsq + 1));

        pilha.empilha(new Segmento(indiceEsq, indiceDir));

        while (!pilha.vazia()) {
            Segmento seg = pilha.desempilha();

            int indicePivot = particiona(lista, seg.esq, seg.dir);

            if (pilha.existeSegmentoNaEsquerda(seg.esq, indicePivot)) {
                pilha.empilha(new Segmento(seg.esq, indicePivot - 1));
            }

            if (pilha.existeSegmentoNaDireita(seg.dir, indicePivot)) {
                pilha.empilha(new Segmento(indicePivot + 1, seg.dir));
            }
        }
    }

    public static void main(String[] args) {
        int[] values = new int[100];
        Random r = new Random();

        for (int i = 0; i < values.length; i++) {
            values[i] = r.nextInt(100);
        }

        quickSort(values, 0, values.length - 1);

        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
}
