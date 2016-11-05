import java.time.Year;

/**
 * Classe Pessoa
 */

/**
 * @author Eduardo
 *
 */
public class Pessoa {
	private String nome;
	private int anoNascimento;
	private String cpf;
	private String telefone;

	public Pessoa(String nome, int nascimento, String cpf, String telefone) {
		super();
		this.nome = nome;
		this.anoNascimento = nascimento;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	
	/**
	 * @author Eduardo
	 */
	public void imprimeDados(){
		System.out.println("Nome: " + this.getNome());
		System.out.println("Idade: " + this.calcularIdade());
		System.out.println("CPF: " + this.getCpf());
		System.out.println("Telefone: " + this.getTelefone());
	}
	
	/**
	 * @author Eduardo
	 * @return idade calculada
	 */
	public int calcularIdade(){
		return Year.now().getValue() - this.getAnoNascimento();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setNascimento(int nascimento) {
		this.anoNascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
