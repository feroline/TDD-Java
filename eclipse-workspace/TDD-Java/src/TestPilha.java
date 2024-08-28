
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestPilha {
	
	private Pilha pilha; 
	
	@BeforeEach
	public void inicializarPilha() {
		pilha = new Pilha(10); //inicializa a pilha com capacidade de 10
	}

	// verifica se a pilha está vazia
	@Test
	void pilhaVazia() {
		
		assertTrue(pilha.isVazia()); 	//verifica se o método retorna 'true'. O método verifica se a pilha está vazia.
		assertEquals(0,pilha.tamanho()); 	//verifica se o length da pilha é igual a 0
	}

	
	@Test
	void empilharElemento() {
		
		Object pilhaValue = "Primeiro"; 
		
		pilha.empilhar(pilhaValue); 	// empilhará elementos de string
		assertFalse(pilha.isVazia()); // verificar se o método retorna 'false'. O método verifica se a pilha está vazia
		assertEquals(1,pilha.tamanho()); 	//verifica se o length da pilha é igual a 1
		assertEquals(pilhaValue, pilha.topoDaPilha());//verifica se o valor do primeiro item da pilha
	}
	
	@Test
	void empilhaDoisElementos() {
		
		Object value1 = "Primeiro";
		Object value2 = "Segundo"; 
	
		//empilha 2 e verifica
		pilha.empilhar(value1);
		pilha.empilhar(value2);	
		assertEquals(2, pilha.tamanho());
		assertEquals(value2,pilha.topoDaPilha());
		
		//desempilha 1 e verifica 
		Object desempilhado = pilha.desempilhar();
		assertEquals(1,pilha.tamanho());
		assertEquals(value1, pilha.topoDaPilha());
		
	}
	
	@Test
	void desempilharPilhaVazia() {
		String mensagemEsperada = "A pilha está vazia e não é possível desempilhar";
		
		// verifica se a assertion retornada corresponde a assertion desejada
		PilhaVaziaException exception = assertThrows(PilhaVaziaException.class, () -> pilha.desempilhar());
		
	    String mensagemRecebida = exception.getMessage();
	    assertTrue(mensagemRecebida.contains(mensagemEsperada)); //verifica se a mensagem de erro da assertion retornada é igual a mensagem desejada

	}
	
	@Test
	void encherPilha() {
		String mensagemEsperada = "A pilha atingiu o limite e estourou :("; 
		
		for(int i = 0; i < 10; i++) {
			pilha.empilhar("conteúdo "+ i);
		}
		
		try{
			pilha.empilhar("BOOOM!! Estourou"); 
			fail(); //se não deu a exceção irá para o catch
		}catch(PilhaCheiaException exception) {
			String mensagemRecebida = exception.getMessage();
			assertTrue(mensagemRecebida.contains(mensagemEsperada));
		}
		
	
	}

	
}
