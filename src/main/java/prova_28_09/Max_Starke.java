/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova_28_09;

/**
 *
 * @author maxna
 */
import java.util.Scanner;

public class Max_Starke {

	private class No {
		public int num = 0;
		public int numInvertido = 0;
		public No prox = null;
		public No ant = null;
	}
	
	private int inverteNum(int num){
		String b = new Integer(num).toString();
		String c = "";
		
		for (int i=b.length(); i > 0; i--) {
			c += b.substring(i - 1, i);
		}
		return Integer.valueOf(c);
	}
	
	private boolean ehCapicua(int num, int numInvertido){
		return num == numInvertido;
	}

	// Gera uma lista dinâmica com todas as iterações até alcançar o próximo número CAPICUA       
        
private No geraCapicua(int num) {
            No head = new No();
            head.num = num;
            head.numInvertido = inverteNum(num);
            No aux = head;
            while (!ehCapicua(aux.num, aux.numInvertido)){
                No novo = new No();
                novo.num = aux.num + aux.numInvertido;
                novo.numInvertido = inverteNum(novo.num);
                aux.prox = novo;
                aux = novo;     
            }
		return head;
	}

	// Busca na lista o valor CAPICUA imprime este valor
	private void imprimeCapicua(No head) {
		No aux = head;

		while (aux.prox != null)
			aux = aux.prox;

		System.out.println("*** MDC = " + aux.num);

	}

	// Imprime a sequência de iterações gerada pelo algorítmo
	private void imprimeSequenciaDeIteracoes(No head) {
		No aux = head;

		while (aux.prox != null) {
			System.out.println(aux.num + "+" + aux.numInvertido);
			aux = aux.prox;
		}
		System.out.println(aux.num + "+" + aux.numInvertido);

	}

	private void start() {
		Scanner s = new Scanner(System.in);
		System.out.println("*** CALCULO DO PRÓXIMO CAPICUA");

		System.out.println("Informe o valor a testar");
		int valor = s.nextInt();


		No head = geraCapicua(valor);

		imprimeCapicua(head);

		imprimeSequenciaDeIteracoes(head);

	}

	public static void main(String[] args) {
		Max_Starke questao = new Max_Starke();
		questao.start();
	}
}

