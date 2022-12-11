package exercicios_grafos_;

public class Principal {
	
	
	public static void main(String[] args){
		Vertice v;
		Grafo grafo = new Grafo();
		
		grafo.addVertice(1);
		grafo.addVertice(2);
		grafo.addVertice(3);
		grafo.addVertice(4);
		grafo.addVertice(5);
		grafo.addVertice(6);
		grafo.addVertice(7);
		grafo.addVertice(8);
		
		v = grafo.getVertice(1);
		v.addAdjacencia(grafo.getVertice(2), 20);
		v.addAdjacencia(grafo.getVertice(4), 80);
		v.addAdjacencia(grafo.getVertice(7), 90);
		
		v = grafo.getVertice(2);
		v.addAdjacencia(grafo.getVertice(6), -10);
		
		v = grafo.getVertice(3);
		v.addAdjacencia(grafo.getVertice(4), 10);
		v.addAdjacencia(grafo.getVertice(6), 50);
		v.addAdjacencia(grafo.getVertice(8), 20);
		v.addAdjacencia(v, 5);
		
		v = grafo.getVertice(4);
		v.addAdjacencia(grafo.getVertice(7), 20);
		
		v = grafo.getVertice(5);
		v.addAdjacencia(grafo.getVertice(2), 50);
		v.addAdjacencia(grafo.getVertice(7), 30);
		
		v = grafo.getVertice(6);
		v.addAdjacencia(grafo.getVertice(3), 10);
		v.addAdjacencia(grafo.getVertice(4), 40);

		v = grafo.getVertice(7);
		v.addAdjacencia(grafo.getVertice(1), 20);
		
		/*
		v = grafo.getVertice(1);
		v.addAdjacencia(grafo.getVertice(2), 20);
		v.addAdjacencia(grafo.getVertice(3), 80);
		v.addAdjacencia(grafo.getVertice(4), 90);
		
		v = grafo.getVertice(2);
		v.addAdjacencia(grafo.getVertice(4), 10);
		v.addAdjacencia(grafo.getVertice(5), 10);
		
		v = grafo.getVertice(3);
		v.addAdjacencia(grafo.getVertice(6), 50);
		
		v = grafo.getVertice(4);
		v.addAdjacencia(grafo.getVertice(3), 20);
		
		v = grafo.getVertice(5);
		v.addAdjacencia(grafo.getVertice(4), 50);
		
		v = grafo.getVertice(6);
		v.addAdjacencia(grafo.getVertice(4), 40);

		v = grafo.getVertice(7);
		v.addAdjacencia(grafo.getVertice(4), 20);
		v.addAdjacencia(grafo.getVertice(5), 20);
		v.addAdjacencia(grafo.getVertice(6), 20);
		*/

		grafo.print();
		
		System.out.println("-------------------------------------");
		
		try{
			grafo.caminhaLargura();
			//grafo.reset();
			//grafo.caminhaProfundidade();
			//grafo.menorCaminho(1, 7);
		}
		catch (Exception e)
		{
			System.out.println("buxa");
		}

		System.out.println("-------------------------------------");
		
	
	}

}
