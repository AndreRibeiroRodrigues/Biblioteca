package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import entities.Emprestimo;
import entities.Funcionario;
import entities.ItensEmprestimo;
import entities.Livro;

public class Relatorio {
	private static final String path = "C:\\GitHub\\Biblioteca\\CSV";
	static Scanner sc = new Scanner(System.in);

	public void Relat(List<Livro> livros, List<ItensEmprestimo> itensEmprestimos,
			List<Funcionario> funcionarios,
			List<Aluno> alunos, List<Emprestimo> emprestimos) {

		// relatório de cadastro BY total
		try {
			BufferedReader Livro = new BufferedReader(new FileReader(path + "\\Livros.csv"));
			BufferedReader Funcionario = new BufferedReader(
					new FileReader(path + "\\Funcionarios.csv"));
			BufferedReader Alunos = new BufferedReader(new FileReader(path + "\\Alunos.csv"));
			BufferedReader Emprestimos = new BufferedReader(
					new FileReader(path + "\\Emprestimos.csv"));

			int totalLivros = 0;
			int totalEmprestimos = 0;
			int totalAlunos = 0;
			int totalFuncionario = 0;
			totalLivros = -1;
			while (Livro.readLine() != null) {
				totalLivros++;
			}

			Livro.close();
			totalEmprestimos = -1;
			while (Emprestimos.readLine() != null) {
				totalEmprestimos++;

			}
			Emprestimos.close();
			totalAlunos = -1;
			while (Alunos.readLine() != null) {
				totalAlunos++;
			}
			Alunos.close();
totalFuncionario = -1;
			while (Funcionario.readLine() != null) {
				totalFuncionario++;
			}
			Funcionario.close();

			System.out.println("Total de Livros: " + totalLivros);
			System.out.println("Total de Emprestimos: " + totalEmprestimos);
			System.out.println("Total de Funcionarios: " + totalFuncionario);
			System.out.println("Total de Alunos: " + totalAlunos);

		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
		}
		// relatório de cadastro BY total

		System.out.println("Deseja ver o relatorio de multas?");
		System.out.println("Digite [S] SIM ou [N] Nao");
		String es = sc.next();
		while (!es.equalsIgnoreCase("s") && !es.equalsIgnoreCase("n")) {
			System.out.println("Valor invalido \nDigite Novamente");
			es = sc.next();
		}
		do {

			System.out.println("Qual aluno voce deseja ver:");
			String aluno = sc.nextLine();
			if (PorAluno(alunos, aluno) != null) {
				System.out.println("o aluno " + PorAluno(alunos, aluno).getNome() + " tem uma multa de " + "R$ "
						+ PorAluno(alunos, aluno).getMulta());
			}else{
				System.out.println("Aluno não encontrado");
			}

			System.out.println("Deseja ver a multa de outro aluno?");
			System.out.println("Digite [S] SIM ou [N] Nao");
			es = sc.next();
			while (!es.equalsIgnoreCase("s") && !es.equalsIgnoreCase("n")) {
				System.out.println("Valor invalido \nDigite Novamente");
			}
		} while (es.equalsIgnoreCase("s"));
		Biblioteca.inicio(funcionarios, itensEmprestimos, livros, emprestimos, alunos);

		sc.close();
	}

	static Aluno PorAluno(List<Aluno> alunos, String aluno) {

		for (int i = 0; alunos.size() >= i; i++) {
			if (alunos.get(i).getNome() == aluno) {
				return alunos.get(i);
			}
		}
		return null;

	}
}
