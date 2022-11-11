package biblioteca;


public class Professor {
	private int matricula;
	private String nome,endereco,setor,data;

	public Professor() {
		super();
		this.matricula = 0;
		this.nome = "";
		this.endereco = "";
		this.setor = "";
		this.data = "";
	}
	public Professor(int matricula, String nome, String endereco, String setor, String data) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
		this.setor = setor;
		this.data = data;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return  matricula + "," + nome + "," + endereco + "," + setor
				+ "," + data;
	}
}
