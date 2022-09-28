/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_21_09_dinamicidade;

import java.util.Scanner;

/**
 *
 * @author maxna
 */
public class FilaDinamica {
    
    static Cliente start;
    public static void push(Cliente c){
        if (start == null){
            start = c;
            start.previous = null;
            start.next = null;
        }
        else{
            Cliente aux = start;
            while (aux.next != null){
                aux = aux.next;
            }
            aux.next = c;
            c.previous = aux;
            c.next = null;
        }
    }
    
    public static Cliente pop(){
        // empty
        if (start == null)
            return null;
        Cliente aux = start;
        start = start.next;
        return aux;
    }
    
    public static void print(){
        if (start.next != null){
            System.out.println(start.name);
            Cliente aux = start;
            while(aux.next != null){
            
                System.out.println(aux.name);
                aux = aux.next;
            }
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
                    String name = s.next();
                    push(new Cliente(1,name));
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
            System.out.println("***Fila DUPLAMENTE ENCADEADA");
            System.out.println("1 - Push 2 - Pop 3 - Imprimir 4 - Sair");
            opcao = s.nextInt();
        }
        s.close();
    }
    
}
