package metodos;

import java.io.BufferedReader;
import java.io.FileReader;

public class Relatório {
	public void Relatorio() {
		
//		relatório de livros
		
		try {
			BufferedReader Livro = new BufferedReader(
					new FileReader("C:\\GitHub\\Biblioteca\\CSV\\Livros.txt"));
			BufferedReader Funcionario = new BufferedReader(
					new FileReader("C:\\GitHub\\Biblioteca\\CSV\\Funcionarios.txt"));
			BufferedReader Alunos = new BufferedReader(
					new FileReader("C:\\GitHub\\Biblioteca\\CSV\\Aluno.txt"));
			BufferedReader Emprestimos = new BufferedReader(
					new FileReader("C:\\GitHub\\Biblioteca\\CSV\\Emprestimo.txt"));
			
			int totalLivros = 0;
			int totalEmprestimos = 0;
			int totalAlunos = 0;
			int totalFuncionario = 0;
			
			while (Livro.readLine() != null) {
				totalLivros++;
			}

			Livro.close();
			
			while(Emprestimos.readLine() != null) {
				totalEmprestimos++;
				
			}
			Emprestimos.close();
			
			while(Alunos.readLine() !=  null) {
				totalAlunos++;
			}
			Alunos.close();
			
			while(Funcionario.readLine() != null) {
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
		
	}
}
