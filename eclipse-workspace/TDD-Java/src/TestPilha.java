
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestPilha {
	
	private Pilha pilha; 
	private int tamanhoMax = 10;

	
	@BeforeEach
	public void inicializarPilha() {
		pilha = new Pilha(tamanhoMax); 
	}

	@Test
	void isPilhaVazia() {
		
		assertTrue(pilha.isVazia()); 	
		verificaTamanhoPilha(0);
	}

	
	@Test
	void empilharElemento() {
		
		Object pilhaValue = "Primeiro"; 
		pilha.empilhar(pilhaValue); 	
		
		assertFalse(pilha.isVazia()); 
		verificaTamanhoPilha(1);
		verificarTopoPilha(pilhaValue);
		
	}
	
	@Test
	void empilharAndDesempilhar() {
		
		Object value1 = "Primeiro";
		Object value2 = "Segundo"; 
	
		pilha.empilhar(value1);
		pilha.empilhar(value2);		
		verificaTamanhoPilha(2);
		verificarTopoPilha(value2);
		
		pilha.desempilhar();

		verificaTamanhoPilha(1);
		verificarTopoPilha(value1);
		
	}
	
	@Test
	void desempilharPilhaVazia() {
		
		PilhaVaziaException exception = assertThrows(PilhaVaziaException.class, () -> pilha.desempilhar());
	    assertTrue(getMsgException(exception).contains(MessagesExceptions.PILHA_VAZIA.toString()));
	    
	}
	
	@Test
	void encherPilha() {

		empilharByQuant(tamanhoMax);
		
		try{
			pilha.empilhar("BOOOM!! Estourou"); 
			fail();
		}catch(PilhaCheiaException exception) {
			assertTrue(getMsgException(exception).contains(MessagesExceptions.PILHA_CHEIA.toString()));
		}
	
	}
	

	private String getMsgException(RuntimeException exception) {
		return exception.getMessage();
	}
	
	private void empilharByQuant(int quantidade) {
		for(int i = 0; i < quantidade; i++) {
			pilha.empilhar("conteúdo "+ i);
		}
		
	}

	private void verificaTamanhoPilha(int tamanhoEsperado) {
		assertEquals(tamanhoEsperado,pilha.getTamanho());
	}
	
	private void verificarTopoPilha(Object valor) {
		assertEquals(valor,pilha.getTopoDaPilha());
	}
	
	
}
