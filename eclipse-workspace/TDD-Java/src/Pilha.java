

public class Pilha {

	private String pilhaValue; 
	private int quantidade;
	
	
	public Boolean isVazia() {
		return (pilhaValue == null); // equivale a: (pilhaValue == null) ? true : false; 
	}

	public int tamanho() {
		return this.quantidade; //retorna a quantidade na pilha
	}

	public void empilhar(String pilhaValue) { //FIXME: Talvez seja necessário converter para Object 
		this.pilhaValue = pilhaValue; //guardo o valor da pilha recebido, pois será utilizado futuramente
		this.quantidade ++; //incrementa a quantidade
	}

	public Object topoDaPilha() {
		return this.pilhaValue;
	}

}
