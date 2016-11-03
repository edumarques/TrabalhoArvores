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
	 * @author Eduardo
	 * @param no
	 * @param valor
	 */
	public void inserirNo(No no, int valor) {
		if (this.raiz == null) {
			this.raiz = new No(valor);
		} else {
			if (valor < no.getValor()) {
				if (no.getNoEsquerda() != null) {
					inserirNo(no.getNoEsquerda(), valor);
				} else {
					no.setNoEsquerda(new No(valor));
				}
			} else if (valor > no.getValor()) {
				if (no.getNoDireita() != null) {
					inserirNo(no.getNoDireita(), valor);
				} else {
					no.setNoDireita(new No(valor));
				}
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
	 * @author Eduardo2w
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
