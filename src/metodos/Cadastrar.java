package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import entities.Alunos;
import entities.Livros;
import entities.Professor;

public class Cadastrar {
	static String path;

	public Scanner sc = new Scanner(System.in);

	public void cadastroItem() {
		path = "C:\\Users\\andrerodrigues\\git\\Biblioteca\\CSV\\Livros.txt";

		Livros livro = new Livros();

		String es;
		int codigo = 1;

		do {
			System.out.println("Voce iniciou o cadastro de item");
			System.out.println("Digite o nome do autor:");
			livro.setAutor(sc.nextLine());

			System.out.println("Digite o titulo:");
			livro.setTitulo(sc.nextLine());

			System.out.println("Digite a editora:");
			livro.setEditora(sc.nextLine());

			System.out.println("Digite o tipo [L] livro [P] periodico:");
			livro.setTipo(sc.next().toUpperCase().charAt(0));

			System.out.println("Digite o ano de publicação:");
			livro.setAnopublicacao(sc.nextInt());
			while (livro.getAnopublicacao() < 1900 || livro.getAnopublicacao() > 2030) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				livro.setAnopublicacao(sc.nextInt());
			}

			System.out.println("Digite o issn:");
			livro.setIssn(sc.nextInt());
			while (livro.getIssn() > 99999999 || livro.getIssn() < 10000000) {
				System.out.println("Valor invalido");
				System.out.println("Digite novamente");
				livro.setIssn(sc.nextInt());
			}

			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//				Gerar o codigo unico;
				String line = br.readLine();
				while (line != null) {
					codigo++;
					line = br.readLine();
				}
				livro.setCodigo(codigo);

				FileWriter adicionar = new FileWriter(path, true);
				PrintWriter pw = new PrintWriter(adicionar);

				pw.println(livro.toString());
				pw.flush();
				pw.close();

			}

			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
				System.out.println("Nao foi possivel cadastrar o item \n");
			}

//		escolha de cadastrar novamente;
			System.out.println("Deseja cadastrar mais um iten?");
			System.out.println("[S] Sim [N] Não");
			es = sc.next();
			while (!es.equalsIgnoreCase("s") && !es.equalsIgnoreCase("n")) {
				System.out.println("valor Invalido");
				System.out.println("Digite novamente");
				es = sc.next();
			}
		} while (es.equalsIgnoreCase("s"));
		Biblioteca.inicio();
	}

	public void cadastroAluno() {
//		Matricula,Nome,Endereco,Curso,DataIngresso,Multa
		path = "C:\\Users\\andrerodrigues\\git\\Biblioteca\\CSV\\Aluno.txt";

		Alunos aluno = new Alunos();

		System.out.println("voce inicou o cadastro de alunos");

		System.out.println("Digite a matricula do aluno:");
		aluno.setMatricula(sc.nextInt());
		System.out.println(aluno.getMatricula());

	}

	public void cadastroProfessor() {
//		matrícula,nome,endereço,data-ingresso,setor
		path = "C:\\Users\\andrerodrigues\\git\\Biblioteca\\CSV\\Professores.txt";

		Professor prof = new Professor();

		String es;
		do {
			System.out.println("voce inicou o cadastro de professor");

			System.out.println("Digite a matricula de professor:");

			prof.setMatricula(sc.nextInt());

//		escolha de cadastrar novamente;
			System.out.println("Deseja cadastrar mais um professor?");
			System.out.println("[S] Sim [N] Não");
			es = sc.next();
			while (!es.equalsIgnoreCase("s") && !es.equalsIgnoreCase("n")) {
				System.out.println("valor Invalido");
				System.out.println("Digite novamente");
				es = sc.next();
			}
		} while (es.equalsIgnoreCase("s"));
		Biblioteca.inicio();
	}

	public void cadastroFuncionario() {
//		matrícula,nome,endereço,data-ingresso,setor,senha,login
		path = "C:\\Users\\andrerodrigues\\git\\Biblioteca\\CSV\\Funcionarios.txt";

	}

}
