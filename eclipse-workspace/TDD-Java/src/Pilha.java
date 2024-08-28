

public class Pilha {

	private Object[] pilhaValue;
	private int quantidade = 0;
	
	
	public Pilha(int tamanhoMax) {
		pilhaValue = new Object[tamanhoMax];
	}

	public Boolean isVazia() {
		return (quantidade == 0); // equivale a: (pilhaValue == null) ? true : false; 
	}

	public int tamanho() {
		return this.quantidade; //retorna a quantidade na pilha
	}

	public void empilhar(Object conteudo) { //FIXME: Talvez seja necessário converter para Object 
		
		if(quantidade == pilhaValue.length )
			throw new PilhaCheiaException("A pilha atingiu o limite e estourou :(");
	
		
		this.pilhaValue[quantidade] = conteudo; //guardo o valor da pilha recebido, pois será utilizado futuramente
		this.quantidade ++; //incrementa a quantidade
	}

	public Object topoDaPilha() {
		return this.pilhaValue[quantidade-1];
	}
	
	public Object desempilhar() {
		String mensagemErro = "A pilha está vazia e não é possível desempilhar";
		
		if(isVazia()) 
			throw new PilhaVaziaException(mensagemErro);
	
			
		Object topo = topoDaPilha(); 
		quantidade --; 
		return topo;
	}

}
