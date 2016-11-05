/**
 * Classe Agenda
 */

/**
 * @author Eduardo, Tharles
 *
 */
public class Agenda {
	Arvore a = new Arvore();

	public Agenda() {
	}

	/**
	 * @author Eduardo, Tharles
	 * @param pessoa
	 * Armazena uma pessoa na agenda.
	 */
	public void armazenaPessoa(Pessoa pessoa) {
		a.inserirNo(new No(pessoa), pessoa);
	}

	/**
	 * @author Tharles
	 * @param nome
	 * Remove uma pessoa da agenda.
	 */
	public void removePessoa(String nome) throws Exception {
		a.removerNo(a.raiz, nome);
	}

	/**
	 * @author Tharles
	 * @param nome
	 * Busca uma pessoa na agenda.
	 */
	public void buscaPessoa(String nome) {
		a.busca(nome);
	}

	/**
	 * @author Eduardo
	 * Imprime toda a agenda.
	 */
	public void imprimeAgenda() {
		a.prefixado(a.raiz);
	}

	/**
	 * @author Eduardo
	 * @param nome
	 * Imprime os dados de uma pessoa da agenda.
	 */
	public void imprimePessoa(String nome) {
		No n = a.busca(nome);
		n.getPessoa().imprimeDados();
	}

}
