public class Pilha {

	private Object[] pilhaValue;
	private int tamanhoPilha = 0;	
	
	public Pilha(int tamanhoMax) {
		pilhaValue = new Object[tamanhoMax];
	}

	public Boolean isVazia() {
		return (tamanhoPilha == 0);
	}

	public int getTamanho() {
		return this.tamanhoPilha; 
	}
	
	public Object getTopoDaPilha() {
		return this.pilhaValue[tamanhoPilha-1];
	}
	
	private void setTamanho(Boolean isAdicionar) {
		if(isAdicionar) {
			this.tamanhoPilha ++;	
		}else {
			this.tamanhoPilha --; 
		}
		
	}
	
	private void setConteudoPilha(Object conteudo) {
		this.pilhaValue[tamanhoPilha] = conteudo;
	}

	public void empilhar(Object conteudo) {
		
		if(tamanhoPilha == pilhaValue.length )
			throw new PilhaCheiaException(MessagesExceptions.PILHA_CHEIA.toString());
	
		setConteudoPilha(conteudo);
		setTamanho(true);
	}
	
	public Object desempilhar() {
		
		if(isVazia()) 
			throw new PilhaVaziaException(MessagesExceptions.PILHA_VAZIA.toString());
	
		setTamanho(false);
		return getTopoDaPilha();
	}

}
