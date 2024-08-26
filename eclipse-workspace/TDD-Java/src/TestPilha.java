import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPilha {

	// verifica se a pilha está vazia
	@Test
	void pilhaVazia() {
		//inicializa a classe pilha com capacidade 10, neste caso de arrays
		Pilha pilha = new Pilha(10);
		
		//verifica se o método retorna 'true'. O método verifica se a pilha está vazia.
		assertTrue(pilha.isVazia());
		
		//verifica se o length da pilha é igual a 0
		assertEquals(0,pilha.tamanho());
	}

}
