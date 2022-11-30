package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import entities.Alunos;
import entities.Emprestimo;
import entities.Funcionario;
import entities.ItensEmprestimo;
import entities.Livro;

public class Relatorio {
	private static final String path = "C:\\GitHub\\Biblioteca\\CSV";
	static Scanner sc = new Scanner(System.in);

	public void Relat(List<Livro> livros, List<ItensEmprestimo> itensEmprestimos,
			List<Funcionario> funcionarios,
			List<Alunos> alunos, List<Emprestimo> emprestimos) {

		// relatório de cadastro BY total
		try {
			BufferedReader Livro = new BufferedReader(new FileReader(path + "\\Livros.csv"));
			BufferedReader Funcionario = new BufferedReader(
					new FileReader(path + "\\Funcionarios.csv"));
			BufferedReader Alunos = new BufferedReader(new FileReader(path + "\\Aluno.csv"));
			BufferedReader Emprestimos = new BufferedReader(
					new FileReader(path + "\\Emprestimo.csv"));

			int totalLivros = 0;
			int totalEmprestimos = 0;
			int totalAlunos = 0;
			int totalFuncionario = 0;

			while (Livro.readLine() != null) {
				totalLivros++;
			}

			Livro.close();

			while (Emprestimos.readLine() != null) {
				totalEmprestimos++;

			}
			Emprestimos.close();

			while (Alunos.readLine() != null) {
				totalAlunos++;
			}
			Alunos.close();

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

		System.out.println("Deseja ver o rela´torio de multas?");
		System.out.println("Digite [S] SIM ou [N] Nao");
		String es = sc.next().toUpperCase();
		while (!es.equalsIgnoreCase("S") || !es.equalsIgnoreCase("N") && es.length() > 1) {
			System.out.println("Valor invalido \nDigite Novamente");
			es = sc.next();
		}
		if (es.equalsIgnoreCase("s")) {
			System.out.println("Qual aluno voce deseja ver:");
			String aluno = sc.nextLine();
			System.out.println("o aluno "+ PorAluno(alunos, aluno).getNome() + " tem uma multa de " + "R$ "+PorAluno(alunos, aluno).getMulta());

		} else {
			Biblioteca.inicio(livros, itensEmprestimos, funcionarios, alunos, emprestimos);
		}
		sc.close();
	}

	static Alunos PorAluno(List<Alunos> alunos, String aluno) {

		for (int i = 0; alunos.size() >= i; i++) {
			if (alunos.get(i).getNome() == aluno) {
				return alunos.get(i);
			}
		}
		return null;

	}
}
