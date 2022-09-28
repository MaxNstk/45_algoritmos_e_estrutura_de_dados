/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_21_09_dinamicidade;

/**
 *
 * @author maxna
 */
import java.util.Scanner;

public class PilhaDinamica {

    private static No topo = null;

    public static void push(int chave) {
        if (topo == null) {
            topo = new No();
            topo.chave = chave;
            topo.ant = null;
            topo.prox = null;
        } else {
            No novo = new No();
            novo.chave = chave;
            novo.ant = topo;
            topo.prox = novo;
            topo = topo.prox;
        }
    }

    public static int pop() {
        if (topo != null) {
            No aux = topo;
            topo = topo.ant;
            if (topo != null) {
                topo.prox = null;
            }

            aux.ant = null;
            return aux.chave;
        }

        return -1;
    }

    public static void print() {
        if (topo != null) {
            No aux = topo;

            while (aux.ant != null) {
                System.out.println(aux.chave);
                aux = aux.ant;
            }

            System.out.println(aux.chave);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("***PILHA DUPLAMENTE ENCADEADA");
        System.out.println("1 - Push 2 - Pop 3 - Imprimir 4 - Sair");
        int opcao = s.nextInt();
        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    System.out.println("Informe o valor da chave");
                    int chave = s.nextInt();
                    push(chave);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    print();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            System.out.println("***PILHA DUPLAMENTE ENCADEADA");
            System.out.println("1 - Push 2 - Pop 3 - Imprimir 4 - Sair");
            opcao = s.nextInt();
        }
        s.close();
    }
}
