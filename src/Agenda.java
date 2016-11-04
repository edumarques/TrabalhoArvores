
/**
 * @author tharles
 *
 */
public class Agenda {
	Arvore a = new Arvore();
	
	public Agenda() {
	
	}
	/**
	 * @author Tharles
	 * @param pessoa
	* */
	public void armazenaPessoa(Pessoa pessoa){
		
		
		No n1 = new No();
		Pessoa p1 = new Pessoa("Tharles", 1991, "123123123", "12343321");
		a.inserirNo(n1, pessoa);
		
		
	}
	/**
	 * @author Tharles
	 * @param pessoa
	 */
	public void removePessoa(String nome) throws Exception{
		a.removerNo(a.raiz, nome);
		
	}
	/**
	 * @author Tharles
	 * @param pessoa
	 */
	public void buscaPessoa(String nome){
		a.busca(nome);
	}
	public void imprimeAgenda(){
		
		
	}
	public void imprimePessoa(){
		
	}

}
