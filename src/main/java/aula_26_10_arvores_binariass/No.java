package aula_26_10_arvores_binariass;

public class No {
	private No esq; 
	private No dir;
	private int chave = 0;
	public String filename;
	public int size;
	
	public No(int chave) {
		this.chave = chave;
	}
        
        public int getSize() {
            return this.size;
        }

	public No(int chave, String filename, int size) {
		this.chave = chave;
		this.filename = filename;
		this.size = size;
		esq = null; 
		dir = null;
	}
	
	public int getValor(){
		return chave;
	}
	
	public void setValor(int valor){
		this.chave =  valor;
	}
		
	public No getEsquerda(){
		return esq;
	}

	public No getDireita(){
		return dir;
	}
	
	public void setEsquerda(No esq){
		this.esq = esq;
	}

	public void setDireita(No dir){
		this.dir = dir;
	}
	
        public String toString(){
            return this.filename;
        }
}
