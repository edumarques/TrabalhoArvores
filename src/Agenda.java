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
	 */
	public void armazenaPessoa(Pessoa pessoa) {
		a.inserirNo(new No(pessoa), pessoa);
	}

	/**
	 * @author Tharles
	 * @param pessoa
	 */
	public void removePessoa(String nome) throws Exception {
		a.removerNo(a.raiz, nome);
	}

	/**
	 * @author Tharles
	 * @param pessoa
	 */
	public void buscaPessoa(String nome) {
		a.busca(nome);
	}

	/**
	 * @author Eduardo
	 */
	public void imprimeAgenda() {
		a.prefixado(a.raiz);
	}

	/**
	 * @author Eduardo
	 * @param nome
	 */
	public void imprimePessoa(String nome) {
		No n = a.busca(nome);
		n.getPessoa().imprimeDados();
	}

}
