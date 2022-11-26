package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Relatorio {
	static Scanner sc = new Scanner(System.in);
	public void Relat() {
		

//		relatório de cadastro BY total
		try {
			BufferedReader Livro = new BufferedReader(new FileReader("C:\\GitHub\\Biblioteca\\CSV\\Livros.csv"));
			BufferedReader Funcionario = new BufferedReader(
					new FileReader("C:\\GitHub\\Biblioteca\\CSV\\Funcionarios.csv"));
			BufferedReader Alunos = new BufferedReader(new FileReader("C:\\GitHub\\Biblioteca\\CSV\\Aluno.csv"));
			BufferedReader Emprestimos = new BufferedReader(
					new FileReader("C:\\GitHub\\Biblioteca\\CSV\\Emprestimo.csv"));

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
//		relatório de cadastro BY total

		System.out.println("Deseja ver o rela´torio de multas?");
		System.out.println("Digite [S] SIM ou [N] Nao");
		String es = sc.next().toUpperCase();
		while (!es.equalsIgnoreCase("S") || !es.equalsIgnoreCase("N") && es.length() > 1) {
			System.out.println("Valor invalido \nDigite Novamente");
			es = sc.next();
		}
		if (es.equalsIgnoreCase("s")) {
			PorAluno();
		} else {
			Biblioteca.inicio();
		}
		sc.close();
	}

	static void PorAluno() {
		// List<Alunos> ListaAlunos = new ArrayList<>();
		
		System.out.println("Voce iniciou o relatório por aluno.");
		System.out.println("Qual aluno voce deseja ver:");
		String aluno = sc.nextLine();
		
		try(BufferedReader Alu = new BufferedReader(new FileReader("C:\\GitHub\\Biblioteca\\CSV\\Aluno.csv"))) {
			Alu.readLine();
			while(Alu != null) {
				Alu.readLine();
				String[] vect = Alu.readLine().split(";");
				if (vect[1] == aluno) {
					System.out.println("A multa do aluno " + vect[1]+  " é " + vect[5]);
				}
				
			}

		}catch (IOException e) {
			System.err.println("Error:" + e.getMessage());
		}
	}
}
