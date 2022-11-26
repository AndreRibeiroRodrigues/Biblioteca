package entities;

import java.util.Random;

public class Emprestimo {
	private int codigo;
	private Alunos alunos;
	private Funcionario funcionario;
	private String dataEmprestimo;
	private String dataDevolução;

	public void Emprestar() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		Random cod = new Random();
		this.codigo = cod.nextInt(10000000, 99999999);
	}

	public Alunos getAlunos() {
		return alunos;
	}

	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolução() {
		return dataDevolução;
	}

	public void setDataDevolução(String dataDevolução) {
		this.dataDevolução = dataDevolução;
	}

	@Override
	public String toString() {
		return  codigo + ";" + alunos + ";" + funcionario+ ";" + dataEmprestimo + ";" + dataDevolução;
	}

	
}
