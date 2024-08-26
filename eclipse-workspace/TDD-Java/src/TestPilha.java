import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPilha {

	// verifica se a pilha está vazia
	@Test
	void pilhaVazia() {
		
		Pilha pilha = new Pilha(); //inicializa a classe pilha com capacidade 10, neste caso de arrays
		
		assertTrue(pilha.isVazia()); 	//verifica se o método retorna 'true'. O método verifica se a pilha está vazia.
		assertEquals(0,pilha.tamanho()); 	//verifica se o length da pilha é igual a 0
	}

	
	@Test
	void empilharElemento() {
		
		Pilha pilha = new Pilha();
		String pilhaValue = "Primeiro"; 
		
		pilha.empilhar(pilhaValue); 	// empilhará elementos de string
		assertFalse(pilha.isVazia()); // verificar se o método retorna 'false'. O método verifica se a pilha está vazia
		assertEquals(1,pilha.tamanho()); 	//verifica se o length da pilha é igual a 1
		assertEquals(pilhaValue, pilha.topoDaPilha());//verifica se o valor do primeiro item da pilha
	}
}
