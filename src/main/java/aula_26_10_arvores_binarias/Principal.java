package exemplo;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Arvore arvore = new Arvore();
		arvore.insere(arvore.getRaiz(), 20, "teste", 10);
		arvore.insere(arvore.getRaiz(), 15, "teste", 10);
		arvore.insere(arvore.getRaiz(), 30, "teste", 10);
		arvore.insere(arvore.getRaiz(), 2, "teste", 10);
		arvore.insere(arvore.getRaiz(), 17, "teste", 10);
		arvore.insere(arvore.getRaiz(), 45, "teste", 10);
		arvore.insere(arvore.getRaiz(), 1, "teste", 10);
		arvore.insere(arvore.getRaiz(), 18, "teste", 10);
		arvore.insere(arvore.getRaiz(), 35, "teste", 10);
		arvore.insere(arvore.getRaiz(), 60, "teste", 10);
		arvore.insere(arvore.getRaiz(), 32, "teste", 10);
		arvore.insere(arvore.getRaiz(), 80, "teste", 10);
		arvore.insere(arvore.getRaiz(), 48, "teste", 10);
		arvore.insere(arvore.getRaiz(), 25, "teste", 10);
		arvore.insere(arvore.getRaiz(), 90, "teste", 10);
		
		arvore.caminhaPreFixado(arvore.getRaiz());
		arvore.caminhaCentral(arvore.getRaiz());
		arvore.caminhaPosFixado(arvore.getRaiz());
		
		/*
		
		while (true){
			System.out.println("|--------------------------------------------|");
			System.out.println("|   PROGRAMA ARVORE BINARIA                  |");
			System.out.println("|1- INSERIR                                  |");
			System.out.println("|2- REMOVER                                  |");
			System.out.println("|3- CONTAR ELEMENTOS                         |");
			System.out.println("|4- LOCALIZAR                                |");
			System.out.println("|5- CAMINHAMENTO CENTRAL                     |");
			System.out.println("|6- CAMINHAMENTO PRÉ-FIXADO                  |");
			System.out.println("|7- CAMINHAMENTO PÓS-FIXADO                  |");
			System.out.println("|8- DESCOBRIR IRMÃO DE UM NODO               |");
			System.out.println("|9- DESCOBRIR PROFUNDIDADE DA ARVORE (ALTURA)|");
			System.out.println("|10- DESCOBRIR DISTANCIA DE UM NODO          |");
			System.out.println("|       (EM RELAÇÃO À RAIZ)                  |");
			System.out.println("|11- TAMANHO DE UM ARQUIVO                   |");
			System.out.println("|12- TAMANHO TOTAL (TODOS OS ARQUIVOS)       |");
			System.out.println("|13- SAIR                                    |");
			System.out.println("|--------------------------------------------|");
			System.out.print("INFORME A SUA OPCAO: ");
			int opcao = s.nextInt();
			if (opcao == 13)
				break;

			int chave = 0;
			switch (opcao){
			case 1:
				//System.out.println("INSERIR ELEMENTO NA ARVORE- INFORME O VALOR A SER INSERIDO: ");
				//valor = s.nextInt();
				//arvore.insere(arvore.getRaiz(), valor);
				arvore.insere(arvore.getRaiz(), 20, "teste", 10);
				arvore.insere(arvore.getRaiz(), 15, "teste", 10);
				arvore.insere(arvore.getRaiz(), 30, "teste", 10);
				arvore.insere(arvore.getRaiz(), 2, "teste", 10);
				arvore.insere(arvore.getRaiz(), 17, "teste", 10);
				arvore.insere(arvore.getRaiz(), 45, "teste", 10);
				arvore.insere(arvore.getRaiz(), 1, "teste", 10);
				arvore.insere(arvore.getRaiz(), 18, "teste", 10);
				arvore.insere(arvore.getRaiz(), 35, "teste", 10);
				arvore.insere(arvore.getRaiz(), 60, "teste", 10);
				arvore.insere(arvore.getRaiz(), 32, "teste", 10);
				arvore.insere(arvore.getRaiz(), 80, "teste", 10);
				arvore.insere(arvore.getRaiz(), 48, "teste", 10);
				arvore.insere(arvore.getRaiz(), 25, "teste", 10);
				arvore.insere(arvore.getRaiz(), 90, "teste", 10);
				break;
			case 2:
				System.out.println("REMOVER ELEMENTO NA ARVORE- INFORME O VALOR A SER REMOVIDO");
				chave = s.nextInt();
				if (arvore.remove(null, arvore.getRaiz(), chave))
					System.out.println("Valor removido com sucesso!!");
				else
					System.out.println("Valor não foi removido!!");
				break;
			case 3:
				System.out.println("CONTAGEM DE ELEMENTOS DA ARVORE");
				System.out.println("Quantidade de elementos da árvore: " + arvore.contaElementos(arvore.getRaiz()));
				break;
			case 4:
				System.out.println("VERIFICAR SE ELEMENTO EXISTE NA ARVORE- INFORME O VALOR A LOCALIZAR");
				chave = s.nextInt();
				No no = arvore.localiza(arvore.getRaiz(), chave);
				if (no != null)
					System.out.println("Valor existe!!");
				else
					System.out.println("Valor não existe!!");
				break;
			case 5:
				System.out.println("LISTA DE ELEMENTOS - CAMINHAMENTO CENTRAL");
				arvore.caminhaCentral(arvore.getRaiz());
				break;
			case 6:
				System.out.println("LISTA DE ELEMENTOS - CAMINHAMENTO PRÉ-FIXADO");
				arvore.caminhaPreFixado(arvore.getRaiz());
				break;
			case 7:
				System.out.println("LISTA DE ELEMENTOS - CAMINHAMENTO PÓS-FIXADO");
				arvore.caminhaPosFixado(arvore.getRaiz());
				break;
			case 8:
				System.out.println("DESCOBRIR O IRMÃO DE UM NODO - INFORME O NODO REFERÊNCIA");
				chave = s.nextInt();
				No irmao = arvore.getIrmao(arvore.getRaiz(), chave);
				if (irmao != null)
					System.out.println(irmao.getValor());
				else
					System.out.println("Não possui irmão");
				break;
			case 9:
				int prof = arvore.getProf(arvore.getRaiz());
				System.out.println("A profundidade é: " + prof);
				break;
			case 10:
				System.out.println("DESCOBRIR A DISTANCIA DE UM NODO - INFORME O NODO REFERÊNCIA");
				chave = s.nextInt();
				int dist = arvore.getDistancia(arvore.getRaiz(), chave);
				if (dist >= 0)
					System.out.println("A distância é: " + dist);
				else
					System.out.println("Não localizado");
				break;
			case 11:
				System.out.println("DESCOBRIR O TAMANHO DE UM ARQUIVO - INFORME A CHAVE");
				chave = s.nextInt();
				tamanho = arvore.fileSize(arvore.getRaiz(), chave);
				if (tamanho >= 0)
					System.out.println("O tamanho do arquuvo é: " + tamanho);
				else
					System.out.println("Não localizado");
				break;
			case 12:
				System.out.println("DESCOBRIR O TAMANHO TOTAL");
				tamanho = arvore.totalSize(arvore.getRaiz());
				if (tamanho >= 0)
					System.out.println("O tamanho da pasta é: " + tamanho);
				else
					System.out.println("Não localizado");
				break;
			default:
				System.out.println("OPÇÃO INVALIDA!");
				break;
			}
		}
		
		arvore = null;
		System.out.println("****FIM****!");
		*/
	}
}
