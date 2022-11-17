package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import entities.Alunos;
import entities.Funcionario;
import entities.Livros;
import entities.Professor;

public class Cadastrar {
	static String path;

	public Scanner sc = new Scanner(System.in);

//	public void cadastroItem() {
////		Consertar e ajustar para cadastrar periodico e livro alternando pelo tipo 
//		path = "C:\\GitHub\\Biblioteca\\CSV\\Livros.txt";
//
//		Livros livro = new Livros();
//
//		String es;
//		int codigo = 0;
//
//		System.out.println("Voce iniciou o cadastro de item");
//		do {
//			System.out.println("Digite o nome do autor:");
//			livro.setAutor(sc.nextLine());
//
//			System.out.println("Digite o titulo:");
//			livro.setTitulo(sc.nextLine());
//
//			System.out.println("Digite a editora:");
//			livro.setEditora(sc.nextLine());
//
//			System.out.println("Digite o tipo [L] livro [P] periodico:");
//			livro.setTipo(sc.next().toUpperCase().charAt(0));
//
//			System.out.println("Digite o ano de publicação:");
//			livro.setAnopublicacao(sc.nextInt());
//			while (livro.getAnopublicacao() < 1900 || livro.getAnopublicacao() > 2030) {
//				System.out.println("Valor digitado invalido \nDigite novamente");
//				livro.setAnopublicacao(sc.nextInt());
//			}
//
//			System.out.println("Digite o issn:");
//			livro.setIssn(sc.nextInt());
//			while (livro.getIssn() > 99999999 || livro.getIssn() < 10000000) {
//				System.out.println("Valor digitado invalido \nDigite novamente");
//				livro.setIssn(sc.nextInt());
//			}
//
//			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
////				Gerar o codigo unico;
//				String line = br.readLine();
//				while (line != null) {
//					codigo++;
//					line = br.readLine();
//				}
//				livro.setCodigo(codigo);
//
//				FileWriter adicionar = new FileWriter(path, true);
//				PrintWriter pw = new PrintWriter(adicionar);
//
//				pw.println(livro.toString());
//				pw.flush();
//				pw.close();
//
//			}
//
//			catch (IOException e) {
//				System.out.println("Error: " + e.getMessage());
//				System.out.println("Nao foi possivel cadastrar o item \n");
//			}
//
////		escolha de cadastrar novamente;
//			System.out.println("Deseja cadastrar mais um iten?");
//			System.out.println("[S] Sim [N] Não");
//			es = sc.next();
//			while (!es.equalsIgnoreCase("s") && !es.equalsIgnoreCase("n")) {
//				System.out.println("valor Invalido");
//				System.out.println("Digite novamente");
//				es = sc.next();
//			}
//		} while (es.equalsIgnoreCase("s"));
//		Biblioteca.inicio();
//	}

	public void cadastroAluno() {
//		Matricula,Nome,Endereco,Curso,DataIngresso,Multa
		path = "C:\\GitHub\\Biblioteca\\CSV\\Aluno.txt";

		Alunos aluno = new Alunos();
		String es;

		System.out.println("voce inicou o cadastro de alunos");

		do {
			System.out.println("Digite a matricula do aluno:");
			aluno.setMatricula(sc.nextInt());
			while (aluno.getMatricula() > 99999999 || aluno.getMatricula() < 10000000) {
				System.out.println("Valor invalido");
				System.out.println("Digite novamente");
				aluno.setMatricula(sc.nextInt());
			}

			sc.nextLine();
			System.out.println("Digite o nome do aluno:");
			aluno.setNome(sc.nextLine());

			System.out.println("Digite o endereço do aluno:");
			aluno.setEndereco(sc.nextLine());
			System.out.println("Informe a data de ingresso:");

			System.out.println("Digite o dia:");
			int dia = sc.nextInt();
			while (dia > 31 || dia < 01) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				dia = sc.nextInt();
			}

			System.out.println("Digite o mes:");
			int mes = sc.nextInt();
			while (mes > 12 || mes < 01) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				mes = sc.nextInt();
			}

			System.out.println("Digite o ano:");
			int ano = sc.nextInt();
			while (ano < 1900 || ano > 2030) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				ano = sc.nextInt();
			}
			aluno.setData(dia + "/" + mes + "/" + ano);

			try {
				FileWriter local = new FileWriter(path, true);
				PrintWriter pw = new PrintWriter(local);
				pw.println(aluno.toString());
				pw.flush();
				pw.close();

			} catch (IOException e) {
				System.out.println("ERROR: " + e.getMessage());
			}
//			escolha de cadastrar novamente;
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

	public void cadastroProfessor() {
//		matrícula,nome,endereço,data-ingresso,setor
		path = "C:\\GitHub\\Biblioteca\\CSV\\Professores.txt";

		Professor prof = new Professor();

		String es;

		System.out.println("voce inicou o cadastro de professor");
		do {
			System.out.println("Digite a matricula de professor:");
			prof.setMatricula(sc.nextInt());
			sc.nextLine();
			System.out.println("Digite o nome do professor:");
			prof.setNome(sc.nextLine());

			System.out.println("Digite o endereço do professor:");
			prof.setEndereco(sc.nextLine());

			System.out.println("Digite o setor do professor:");
			prof.setSetor(sc.nextLine());

			System.out.println("Data de ingresso do professor:");

			System.out.println("digite o dia:");
			int dia = sc.nextInt();
			while (dia > 31 || dia < 01) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				dia = sc.nextInt();
			}

			System.out.println("Digite o mes:");
			int mes = sc.nextInt();
			while (mes > 12 || mes < 01) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				mes = sc.nextInt();
			}

			System.out.println("Digite o ano:");
			int ano = sc.nextInt();
			while (ano < 1900 || ano > 2030) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				ano = sc.nextInt();
			}

			prof.setData(dia + "/" + mes + "/" + ano);

			try {
				FileWriter local = new FileWriter(path, true);
				PrintWriter pw = new PrintWriter(local);
				pw.println(prof.toString());
				pw.flush();
				pw.close();

			} catch (IOException e) {
				System.out.println("ERROR: " + e.getMessage());
			}

//			escolha de cadastrar novamente;
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
		path = "C:\\GitHub\\Biblioteca\\CSV\\Funcionarios.txt";

		Funcionario funcionario = new Funcionario();

		String es;

		System.out.println("Voce iniciou o cadastro de usuarios. \n");

		do {
			System.out.println("Digite a matricula do usuario:");
			funcionario.setMatricula(sc.nextInt());
			sc.nextLine();
			System.out.println("Digite o nome do funcionario:");
			funcionario.setNome(sc.nextLine());

			System.out.println("Digite  endereco do usuario:");
			funcionario.setEndereco(sc.nextLine());

			System.out.println("Informe a data de ingresso do aluno:");

			System.out.println("digite o dia:");
			int dia = sc.nextInt();
			while (dia > 31 || dia < 01) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				dia = sc.nextInt();
			}

			System.out.println("Digite o mes:");
			int mes = sc.nextInt();
			while (mes > 12 || mes < 01) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				mes = sc.nextInt();
			}

			System.out.println("Digite o ano:");
			int ano = sc.nextInt();
			while (ano < 1900 || ano > 2030) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				ano = sc.nextInt();
			}
			funcionario.setDataingrasso(dia + "/" + mes + "/" + ano);
			sc.nextLine();
			System.out.println("Digite o setor do funcionario:");
			funcionario.setSetor(sc.nextLine());

			System.out.println("Digite o login do funcionario:");
			funcionario.setLogin(sc.nextLine());

			System.out.println("Digite a senha do funcionario:");
			funcionario.setSenha(sc.nextLine());
			sc.close();

			try {
				FileWriter local = new FileWriter(path, true);
				PrintWriter pw = new PrintWriter(local);
				pw.println(funcionario.toString());
				pw.flush();
				pw.close();
			} catch (IOException e) {
				System.out.println("ERROR: " + e.getMessage());
			}
//			escolha de cadastrar novamente;
			System.out.println("Deseja cadastrar mais um professor?");
			System.out.println("[S] Sim [N] Não");
			es = sc.next();
			while (!es.equalsIgnoreCase("s") && !es.equalsIgnoreCase("n")) {
				System.out.println("valor Invalido");
				System.out.println("Digite novamente");
				es = sc.next();
				sc.close();
			}
		} while (es.equalsIgnoreCase("s"));
		Biblioteca.inicio();

	}

}
