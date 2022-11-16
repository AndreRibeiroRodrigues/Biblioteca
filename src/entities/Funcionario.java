package entities;

public class Funcionario {
	int matricula;
	String nome, endereco, dataingrasso, setor, senha, login;
	
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
	
	public String getDataingrasso() {
		return dataingrasso;
	}
	
	public void setDataingrasso(String dataingrasso) {
		this.dataingrasso = dataingrasso;
	}
	
	public String getSetor() {
		return setor;
	}
	
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return matricula + "," + nome + "," + endereco + "," + dataingrasso + "," + setor + "," + senha + "," + login;
	}
	
	
	
}
