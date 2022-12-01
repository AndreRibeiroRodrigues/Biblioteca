package metodos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import entities.Emprestimo;
import entities.Funcionario;
import entities.ItensEmprestimo;
import entities.Livro;
import entities.Professor;

public class Biblioteca {
	static Scanner sc = new Scanner(System.in);

	static int escolha;

	static Aluno al = new Aluno();
	static Professor pr = new Professor();
	static Livro li = new Livro();
	static Emprestimo em = new Emprestimo();
	static Relatorio re = new Relatorio();
	static ItensEmprestimo ie = new ItensEmprestimo();
	static Funcionario fu = new Funcionario();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//instancia as listas
		List<Aluno> alunos = new ArrayList<Aluno>();
		al.valores(alunos);
		List<Emprestimo> emprestimos = em.valores();
		List<Livro> livros = li.valores();
		List<ItensEmprestimo> ItensEmprestimos = ie.valores();
		List<Funcionario> funcionarios = fu.valores();
		inicio(funcionarios, ItensEmprestimos, livros, emprestimos, alunos);

	}

	public static void inicio(List<Funcionario> funcionarios, List<ItensEmprestimo> itensEmprestimos,
			List<Livro> livros, List<Emprestimo> emprestimos, List<Aluno> alunos) {
	//chama como parâmetro as listas anteriormente chamadas

		System.out.println("BIBLIOTECA");
		System.out.println("\n");
		System.out.println("[1] Cadastro de itens ");
		System.out.println("[2] Cadastro de usuarios ");
		System.out.println("[3] Emprestico de itens ");
		System.out.println("[4] Emitir Relaório ");
		System.out.println("[5] sair");

		escolha = sc.nextInt();

		switch (escolha) {

			case 1:
				li.cadastroItem(livros, itensEmprestimos, funcionarios, alunos, emprestimos);
				break;
			case 2:
				cadastroUsuario(livros, itensEmprestimos, funcionarios, alunos, emprestimos);
				break;
			case 3:
				em.Emprestar(livros, itensEmprestimos, funcionarios, alunos, emprestimos);
				break;
			case 4:
				re.Relat(livros, itensEmprestimos, funcionarios, alunos, emprestimos);
				break;
			case 5:
				System.out.println("Voce saiu");
				al.persisteDados(alunos);
				li.persisteDados(livros);
				fu.persisteDados(funcionarios);
				em.persisteDados(emprestimos);
				break;
		}
	}

	static void cadastroUsuario(List<Livro> livros, List<ItensEmprestimo> itensEmprestimos,
			List<Funcionario> funcionarios,	List<Aluno> alunos, List<Emprestimo> emprestimos) {
		System.out.println("Escolha quem voce quer cadastrar");
		System.out.println("[1] Funcionario");
		System.out.println("[2] Professor");
		System.out.println("[3] Aluno");
		escolha = sc.nextInt();

		switch (escolha) {
			case 1:
				System.out.println("voce escolheu Funcionario");
				Funcionario.cadastroFuncionario(livros, itensEmprestimos, funcionarios, alunos, emprestimos);
				break;
			/// case 2:
			/// System.out.println("Voce escolheu Professor");
			/// break;
			case 3:
				System.out.println("Voce escolheu Aluno");
				Aluno.cadastroAluno(livros, itensEmprestimos, funcionarios, alunos, emprestimos);
				break;
			case 4:
				System.out.println("Voce escolheu voltar");
				inicio(funcionarios, itensEmprestimos, livros, emprestimos, alunos);
				break;
		}

	}

	static void login(List<Funcionario> funcionarios, List<ItensEmprestimo> ItensEmprestimos, List<Livro> livros,
			List<Emprestimo> emprestimos, List<Aluno> alunos) {
		String user;
		String senha;

		do {
			System.out.println("Digite seu usuario:");
			user = sc.next();
			System.out.println("Digite a sua senha:");
			senha = sc.next();

			var path = "C:\\GitHub\\Biblioteca\\CSV";
			boolean status = false;
			
			try (BufferedReader br = new BufferedReader(new FileReader(path+ "\\Funcionarios.csv"))) {

				String line = br.readLine();

				while (line != null) {
					line = br.readLine();
					String[] vect = line.replaceAll("\"", "").split(";");
					String u = vect[6];
					String s = vect[5];
					if (u.equalsIgnoreCase(user) && s.equalsIgnoreCase(senha)) {
						status = true;
						break;
					} else {
						status = false;
					}
					line = br.readLine();
				}
				if (status) {
					System.out.printf("Seja bem vindo(a) %s \n\n", user);
					inicio(funcionarios, ItensEmprestimos, livros, emprestimos, alunos);
				} else {
					System.out.println("Falha no login");
					System.out.println("Usuario ou senha invalido");
				}

			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}

		} while (false);
		sc.close();
	}

}
