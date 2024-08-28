
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestPilha {
	
	private Pilha pilha; 
	private int tamanhoMax = 10;
	private String msgExceptionPilhaCheia = "A pilha atingiu o limite e estourou :("; 
	private String msgExceptionPilhaVazia = "A pilha está vazia e não é possível desempilhar";
	
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
		assertEquals(pilhaValue, pilha.getTopoDaPilha());
	}
	
	@Test
	void empilharAndDesempilhar() {
		
		Object value1 = "Primeiro";
		Object value2 = "Segundo"; 
	
		//empilha 2 e verifica
		pilha.empilhar(value1);
		pilha.empilhar(value2);	
		
		verificaTamanhoPilha(2);
		assertEquals(value2,pilha.getTopoDaPilha());
		
		//desempilha 1 e verifica 
		pilha.desempilhar();
		
		verificaTamanhoPilha(1);
		assertEquals(value1, pilha.getTopoDaPilha());
		
	}
	
	@Test
	void desempilharPilhaVazia() {
		
		PilhaVaziaException exception = assertThrows(PilhaVaziaException.class, () -> pilha.desempilhar());
	    assertTrue(getMsgException(exception).contains(msgExceptionPilhaVazia));
	    
	}
	
	@Test
	void encherPilha() {

		empilharByQuant(tamanhoMax);
		
		try{
			pilha.empilhar("BOOOM!! Estourou"); 
			fail(); //se não deu a exceção irá para o catch
		}catch(PilhaCheiaException exception) {
			assertTrue(getMsgException(exception).contains(msgExceptionPilhaCheia));
		}
	
	}
	
	
}
