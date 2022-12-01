package metodos;

import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import entities.Emprestimo;
import entities.Funcionario;
import entities.ItensEmprestimo;
import entities.Livro;

public class Relatorio {
	static Scanner sc = new Scanner(System.in);

	public void Relat(List<Livro> livros, List<ItensEmprestimo> itensEmprestimos,
			List<Funcionario> funcionarios,
			List<Aluno> alunos, List<Emprestimo> emprestimos) {

	
			System.out.println("Total de Livros: " + livros.size());
			System.out.println("Total de Emprestimos: " + emprestimos.size());
			System.out.println("Total de Funcionarios: " + funcionarios.size());
			System.out.println("Total de Alunos: " + alunos.size());
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
