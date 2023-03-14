package lab02;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	
	// Construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}
	
	// Getters and Setters
	public String getNome() {
		return nome;
	}
}
