/**
 * Classe Arvore
 */

/**
 * @author Eduardo
 *
 */
public class Arvore {
	private No raiz;

	/**
	 * @author Tharles
	 * @param no
	 * @param pessoa
	 */
	public void inserirNo(No no, Pessoa pessoa) {
		Pessoa p = new Pessoa(pessoa.getNome(),pessoa.calcularIdade(),pessoa.getCpf(),pessoa.getTelefone());
		
		if (this.raiz == null) {
			this.raiz = new No(p);
		}else if (no.getPessoa().getNome().compareTo(pessoa.getNome()) == 0) {
			return;
		}else if (no.getPessoa().getNome().compareTo(pessoa.getNome()) > 0){ 
			if (no.getNoEsquerda() != null) {
				inserirNo(no.getNoEsquerda(), p);
			} else {
				no.setNoEsquerda(new No(p));
			}
		}else if (no.getPessoa().getNome().compareTo(pessoa.getNome()) < 0){ 
				if (no.getNoDireita() != null) {
					inserirNo(no.getNoDireita(), p);
				} else {
					no.setNoDireita(new No(p));
				}
			}
		}
	/**
	 * @author Eduardo
	 * @param no
	 * @param valor
	 * @return Remove n�
	 * @throws Exception
	 */
	public No removerNo(No no, int valor) throws Exception {
		if (this.raiz == null) {
			throw new Exception("A �rvore est� vazia.");
		} else {
			if (valor < no.getValor()) {
				no.setNoEsquerda(removerNo(no.getNoEsquerda(), valor));
			} else if (valor > no.getValor()) {
				no.setNoDireita(removerNo(no.getNoDireita(), valor));
			} else if (no.getNoEsquerda() != null && no.getNoDireita() != null) {
				System.out.println("N� " + no.getValor() + " removido.");
				no.setValor(encontrarMinimo(no.getNoDireita()).getValor());
				no.setNoDireita(removerMinimo(no.getNoDireita()));
			} else {
				System.out.println("N� " + no.getValor() + " removido.");
				no = (no.getNoEsquerda() != null) ? no.getNoEsquerda() : no.getNoDireita();
			}
			return no;
		}
	}

	/**
	 * @author Eduardo
	 * @param no
	 * @return Remove o m�nimo
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
	 * @return Encontra valor m�nimo
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
	 * @author Eduardo2w22
	 * @param no
	 * @return Altura do n�
	 */
	public int alturaNo(No no){
        if(no == null){
            return 0;
        }
        int altEsq = alturaNo(no.getNoEsquerda());
        int altDir = alturaNo(no.getNoDireita());
        if(altEsq > altDir){
            return altEsq + 1;
        } else {
            return altDir + 1;
        }
    }

}
