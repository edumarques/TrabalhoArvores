/**
 * Classe No (da arvore)
 */

/**
 * @author Eduardo
 *
 */
public class No {
	private Pessoa pessoa;
	private No noEsquerda;
	private No noDireita;

	public No() {
	}
	
	public No(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setValor(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public No getNoEsquerda() {
		return noEsquerda;
	}

	public void setNoEsquerda(No noEsquerda) {
		this.noEsquerda = noEsquerda;
	}

	public No getNoDireita() {
		return noDireita;
	}

	public void setNoDireita(No noDireita) {
		this.noDireita = noDireita;
	}

	@Override
	public String toString() {
		return "No [valor=" + pessoa + "]";
	}

}
