package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import entities.Alunos;
import entities.Auth;
import entities.Emprestimo;
import entities.Funcionario;
import entities.Livros;
import entities.Professor;

public class Biblioteca {
	static Scanner sc = new Scanner(System.in);
	static Auth au = new Auth();

	static int escolha;

	static Professor pr = new Professor();
	static Livros li = new Livros();
	static Emprestimo em = new Emprestimo();
	static Relatorio re = new Relatorio();

	public static void main(String[] args) {
		login();
	}

	public static void inicio() {

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
			li.cadastroItem();
			break;
		case 2:
			cadastroUsuario();
			break;
		case 3:
			em.Emprestar();
			break;
		case 4:
			re.Relat();
			break;
		case 5:
			System.out.println("Voce saiu");
			break;
		}
	}

	static void cadastroUsuario() {
		System.out.println("Escolha quem voce quer cadastrar");
		System.out.println("[1] Funcionario");
		System.out.println("[2] Professor");
		System.out.println("[3] Aluno");
		escolha = sc.nextInt();

		switch (escolha) {
		case 1:
			System.out.println("voce escolheu Funcionario");
			Funcionario.cadastroFuncionario();
			break;
		///case 2:
			///System.out.println("Voce escolheu Professor");
			///break;
		case 3:
			System.out.println("Voce escolheu Aluno");
			Alunos.cadastroAluno();
			break;
		case 4:
			System.out.println("Voce escolheu voltar");
			inicio();
			break;
		}
		sc.close();

	}

	static void login() {
		String user;
		String senha;
		
		do {
			System.out.println("Digite seu usuario:");
			user = sc.next();
			System.out.println("Digite a sua senha:");
			senha = sc.next();
			Altenticar(user, senha);

			String path = "c:\\GitHub\\Biblioteca\\CSV\\Funcionarios.csv";
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				
				String line = br.readLine();

				boolean status;
				while (line != null) {
					line = br.readLine();
					String[] vect = line.replaceAll("\"", "").split(";");
					String u = vect[6];
					String s = vect[5];
					System.out.println(u + "/" + s);
					System.out.println(user + "/" + senha);
					if (u.equalsIgnoreCase(user) && s.equalsIgnoreCase(senha + "\"")) {
						status = true;
					} else {
						status = false;
					}

					line = br.readLine();
				}
				if (status  != true) {
					System.out.printf("Seja bem vindo(a) %s \n\n", user);
					inicio();
				} else {
					System.out.println("Falha no login");
					System.out.println("Usuario ou senha invalido");
				}

			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
			
			

		} while (au.getStatus() != true);
		sc.close();
	}

	static void Altenticar(String user, String senha) {
		

	}

}
