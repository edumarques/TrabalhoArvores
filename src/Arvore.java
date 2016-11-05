/**
 * Classe Arvore
 */

/**
 * @author Eduardo, Tharles
 *
 */
public class Arvore {
	public No raiz;

	public Arvore() {
		this.raiz = null;
	}

	/**
	 * @author Eduardo, Tharles
	 * @param nome
	 * Busca uma n� na �rvore.
	 */
	public No busca(String nome) {
		No noatual = this.raiz;
		while (noatual != null) {
			if (nome == noatual.getPessoa().getNome()) {
				return noatual;
			} else if (noatual.getPessoa().getNome().compareTo(nome) > 0) {
				noatual = noatual.getNoEsquerda();
			} else {
				noatual = noatual.getNoDireita();
			}
		}
		return noatual;
	}

	/**
	 * @author Eduardo, Tharles
	 * @param no
	 * @param pessoa
	 * Busca um n� na �rvore.
	 */
	public void inserirNo(No no, Pessoa pessoa) {
		if (this.raiz == null) {
			this.raiz = new No(pessoa);
		} else if (no.getPessoa().getNome().compareTo(pessoa.getNome()) == 0) {
			return;
		} else if (no.getPessoa().getNome().compareTo(pessoa.getNome()) > 0) {
			if (no.getNoEsquerda() != null) {
				inserirNo(no.getNoEsquerda(), pessoa);
			} else {
				no.setNoEsquerda(new No(pessoa));
			}
		} else if (no.getPessoa().getNome().compareTo(pessoa.getNome()) < 0) {
			if (no.getNoDireita() != null) {
				inserirNo(no.getNoDireita(), pessoa);
			} else {
				no.setNoDireita(new No(pessoa));
			}
		}
	}

	/**
	 * @author Eduardo, Tharles
	 * @param no
	 * @param pessoa
	 * @return no
	 * @throws Exception
	 * Remove um n� da �rvore.
	 */
	public No removerNo(No no, String pessoa) throws Exception {
		if (this.raiz == null) {
			throw new Exception("A �rvore est� vazia.");
		} else {
			if (no.getPessoa().getNome().compareTo(pessoa) > 0) {
				no.setNoEsquerda(removerNo(no.getNoEsquerda(), pessoa));
			} else if (no.getPessoa().getNome().compareTo(pessoa) < 0) {
				no.setNoDireita(removerNo(no.getNoDireita(), pessoa));
			} else {
				if (no.getNoEsquerda() != null && no.getNoDireita() != null) {
					System.out.println("Removido.");
					no.setValor(encontrarMinimo(no.getNoDireita()).getPessoa());
					no.setNoDireita(removerMinimo(no.getNoDireita()));
				} else if (no.getNoDireita() != null) {
					no = no.getNoDireita();
				} else {
					no = no.getNoEsquerda();
				}

			}

		}
		return no;
	}

	/**
	 * @author Eduardo
	 * @param no
	 * @return no
	 * Busca o n� m�nimo da �rvore.
	 */
	public No removerMinimo(No no) {
		if (no == null) {
			System.out.println("Erro. N� vazio.");
		} else if (no.getNoEsquerda() != null) {
			no.setNoEsquerda(removerMinimo(no.getNoEsquerda()));
			return no;
		} else {
			return no.getNoDireita();
		}
		return null;
	}

	/**
	 * @author Eduardo
	 * @param no
	 * @return no
	 * Encontro o n� m�nimo da �rvore.
	 */
	public No encontrarMinimo(No no) {
		if (no != null) {
			while (no.getNoEsquerda() != null) {
				no = no.getNoEsquerda();
			}
		}
		return no;
	}

	/**
	 * @author Tharles
	 * @param no
	 * @return no
	 * Encontro o n� m�ximo da �rvore
	 */
	public No encontrarMaximo(No no) {
		if (no != null) {
			while (no.getNoDireita() != null) {
				no = no.getNoDireita();
			}
		}
		return no;
	}

	/**
	 * @author Eduardo
	 * @param no
	 * @return no
	 * Encontra a altura da �rvore
	 */
	public int alturaNo(No no) {
		if (no == null) {
			return 0;
		}
		int altEsq = alturaNo(no.getNoEsquerda());
		int altDir = alturaNo(no.getNoDireita());
		if (altEsq > altDir) {
			return altEsq + 1;
		} else {
			return altDir + 1;
		}
	}

	/**
	 * @author Tharles
	 * @param no
	 * @return no
	 * Caminhamento pr�-fixado da �rvore
	 */
	public void prefixado(No no) {
		if (no != null) {
			no.getPessoa().imprimeDados();
			prefixado(no.getNoEsquerda());
			prefixado(no.getNoDireita());
		}
	}

	/**
	 * @author Tharles
	 * @param no
	 * @return no
	 * Caminhamento p�s-fixado da �rvore
	 */
	public void posfixado(No no) {
		if (no != null) {
			posfixado(no.getNoEsquerda());
			posfixado(no.getNoDireita());
			no.getPessoa().imprimeDados();
		}
	}

}
