package entities;

public class emprestimo {
	int codigo, matriculaclientes, matricula, funcionario;
	String dataemprestimo, datadevolucao;
	
	public emprestimo(int codigo, int matriculaclientes, int matricula, int funcionario, String dataemprestimo,
			String datadevolucao) {
		super();
		this.codigo = codigo;
		this.matriculaclientes = matriculaclientes;
		this.matricula = matricula;
		this.funcionario = funcionario;
		this.dataemprestimo = dataemprestimo;
		this.datadevolucao = datadevolucao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getMatriculaclientes() {
		return matriculaclientes;
	}

	public void setMatriculaclientes(int matriculaclientes) {
		this.matriculaclientes = matriculaclientes;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}

	public String getDataemprestimo() {
		return dataemprestimo;
	}

	public void setDataemprestimo(String dataemprestimo) {
		this.dataemprestimo = dataemprestimo;
	}

	public String getDatadevolucao() {
		return datadevolucao;
	}

	public void setDatadevolucao(String datadevolucao) {
		this.datadevolucao = datadevolucao;
	}

	@Override
	public String toString() {
		return codigo + "," + matriculaclientes + "," + matricula + "," + funcionario + "," + dataemprestimo + ","
				+ datadevolucao;
	}
	
	
}
