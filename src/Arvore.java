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
		this.raiz=null;
	}
	/**
	 * @author Tharles
	 * @param nome
	 */
	public No busca(String nome){
		  No noatual = this.raiz;
		  while(noatual != null){
			  if(nome == noatual.getPessoa().getNome()){
				  return noatual;
			  }
			  else if(noatual.getPessoa().getNome().compareTo(nome) > 0){
				  noatual = noatual.getNoEsquerda();
			  }
			  else{
				  noatual = noatual.getNoDireita();
			  }
		  }
		  return null;
	}
	
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
	 * @author Tharles
	 * @param no
	 * @param pessoa
	 * @return Remove n�
	 * @throws Exception
	 */
	public No removerNo(No no, String pessoa) throws Exception {
		if (this.raiz == null) {
			throw new Exception("A �rvore est� vazia.");
		} else {
			if (no.getPessoa().getNome().compareTo(pessoa) > 0) {
				no.setNoEsquerda(removerNo(no.getNoEsquerda(), pessoa));
			} else if (no.getPessoa().getNome().compareTo(pessoa) < 0) {
				no.setNoDireita(removerNo(no.getNoDireita(), pessoa));
			} else{
				if (no.getNoEsquerda() != null && no.getNoDireita() != null) {
					System.out.println("N� " + no.getPessoa() + " removido.");
					no.setValor(encontrarMinimo(no.getNoDireita()).getPessoa());
					no.setNoDireita(removerMinimo(no.getNoDireita()));
				}else if (no.getNoDireita() != null) { 
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
	 * @author Tharles
	 * @param no
	 * @return Encontra valor máximo
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
	/**
	 * @author Tharles
	 * @param no
	 * @return caminhamento prefixado 
	 */
	private void prefixado(No no) {
        if (no != null) {
            System.out.print(", " + no.getPessoa().getNome());
            prefixado(no.getNoEsquerda());
            prefixado(no.getNoDireita());
        }
	}

	/**
	 * @author Tharles
	 * @param no
	 * @return  caminhamento pós-fixado
	 */
    private void posfixado(No no) {
        if (no != null) {
        	posfixado(no.getNoEsquerda());
        	posfixado(no.getNoDireita());
            System.out.print(" " + no.getPessoa().getNome());
        }
    }

}
