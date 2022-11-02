package aula_19_10_hash_tables_max;

public class Principal {

	public static void main(String[] args) {

            Cliente c1 = new Cliente("11111111111","Cliente 1");
            Cliente c2 = new Cliente("22222222222","Cliente 2");
            Cliente c3 = new Cliente("33333333333","Cliente 3");
            Cliente c4 = new Cliente("44444444444","Cliente 4");
            Cliente c5 = new Cliente("55555555555","Cliente 5");
            Cliente c6 = new Cliente("66666666666","Cliente 6");
            Cliente c7 = new Cliente("77777777777","Cliente 7");
            Cliente c8 = new Cliente("88888888888","Cliente 8");
            Cliente c9 = new Cliente("99999999999","Cliente 9");
            Cliente c10 = new Cliente("1010101010","Cliente 10");
            Cliente c11 = new Cliente("1111111111","Cliente 11");
            Cliente c12 = new Cliente("1212121212","Cliente 12");
            Cliente c13 = new Cliente("1313131313","Cliente 13");
            Cliente c14 = new Cliente("1414141414","Cliente 14");
            Cliente c15 = new Cliente("1515151515","Cliente 15");


            int tamanhoColecao = 15;
            int maximoColisoes = 2;
            //int tamanhoColecao = 5000;
            //int maximoColisoes = 3;

            Hash tabela = new Hash (tamanhoColecao,maximoColisoes);
            tabela.insere(532322557, c1);
            tabela.insere(387414012, c2);
            tabela.insere(977112414, c3);
            tabela.insere(983629276, c4);
            tabela.insere(738229373, c5);
            tabela.insere(662151455, c6);
            tabela.insere(761118988, c7);
            tabela.insere(811123445, c8);
            tabela.insere(976543231, c9);
            tabela.insere(106547632, c10);
            tabela.insere(111156366, c11);
            tabela.insere(123456323, c12);
            tabela.insere(138957655, c13);
            tabela.insere(149876544, c14);
            tabela.insere(158865232, c15);
            tabela.imprime();
            tabela.remove(387414012);
            tabela.remove(811123445);
            tabela.remove(976543231);
            tabela.remove(158865232);
            tabela.imprime();

	}

}
