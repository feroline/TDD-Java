
public enum MessagesExceptions {
	PILHA_CHEIA {
		public String toString() {
			return "A pilha atingiu o limite e estourou :("; 
		}
	},
	PILHA_VAZIA {
		public String toString() {
			return "A pilha está vazia e não é possível desempilhar";
		}
	}
}