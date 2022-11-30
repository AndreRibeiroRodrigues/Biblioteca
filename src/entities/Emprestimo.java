package entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Emprestimo {
	private int codigo;
	private int codigoCliente;
	private int codigoFuncionario;
	private String dataEmprestimo;
	private String dataDevolução;

	public Emprestimo(int codigo, int codigoCliente, int codigoFuncionario, String dataEmprestimo,
			String dataDevolução) {
		this.codigo = codigo;
		this.codigoCliente = codigoCliente;
		this.codigoFuncionario = codigoFuncionario;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolução = dataDevolução;
	}

	public Emprestimo() {
		this.setCodigo();
	}

	public List<Emprestimo> valores() throws FileNotFoundException, IOException {
		var path = "C:\\GitHub\\Biblioteca\\CSV";
		List<Emprestimo> Emprestimos = new ArrayList<>();
		try (BufferedReader lineReader = new BufferedReader(new FileReader(path + "\\Emprestimo.csv"))) {
			String line = lineReader.readLine();
			while (line != null) {
				line = lineReader.readLine();
				if (line == null || line.isEmpty()) {
					break;
				}
				String[] vect = line.replaceAll("\"", "").split(";");
				Emprestimo Emprestimo = new Emprestimo(Integer.parseInt(vect[0]), Integer.parseInt(vect[1]),
						Integer.parseInt(vect[2]), vect[3], vect[4]);
				Emprestimos.add(Emprestimo);

			}
			return Emprestimos;
		}
	}

	// código,matrícula-cliente,matrícula-funcionário,dataempréstimo,data-devolução
	public void Emprestar(List<Livro> livros, List<ItensEmprestimo> itensEmprestimos,
			List<Funcionario> funcionarios,
			List<Alunos> alunos, List<Emprestimo> emprestimos) {

		Scanner sc = new Scanner(System.in);
		int es;

		Emprestimo emprestimo = new Emprestimo();
		System.out.println("Emprestimo ");
		emprestimo.setCodigoCliente(sc.nextInt());
		System.out.println("funcionario");
		emprestimo.setCodigoFuncionario(sc.nextInt());

		do {
			System.out.println("Livro ");
			int codigoLivro = sc.nextInt();

			ItensEmprestimo itensEmprestimo = new ItensEmprestimo();
			itensEmprestimo.setCodigoemprestimo(emprestimo.getCodigo());
			itensEmprestimo.setCodigolivro(codigoLivro);
			itensEmprestimos.add(itensEmprestimo);

			System.out.println("deseja emprestar mains um item?");
			System.out.println("1 para sair e 2 para escolher mais um livro");
			es = sc.nextInt();
		} while (es != 1);
		System.out.println("dataEmprestimo ");
		emprestimo.setDataEmprestimo(sc.next());
		emprestimos.add(emprestimo);
		sc.close();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo() {
		Random cod = new Random();
		this.codigo = cod.nextInt(10000000, 99999999);
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(int codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
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
		return codigo + ";" + codigoCliente + ";" + codigoFuncionario + ";" + dataEmprestimo + ";" + dataDevolução;
	}

}