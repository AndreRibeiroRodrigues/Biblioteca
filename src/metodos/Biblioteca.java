package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Auth;

public class Biblioteca {
	static Scanner sc = new Scanner(System.in);
	public static Auth au = new Auth();

	static int escolha;

	static Cadastrar cr = new Cadastrar();
	static Emprestimo em = new Emprestimo();
	static Relatório re = new Relatório();

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
			cr.cadastroItem();
		case 2:
			cadastroUsuario();
		case 3:
			em.EmprestimoLivro();
		case 4:
			re.Relatorio();
		case 5:
			System.out.println("Voce saiu");
			break;
		default:
			System.out.println("Error: Valor invalido");
		}
		sc.close();

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
			cr.cadastroFuncionario();
		case 2:
			System.out.println("Voce escolheu Professor");
			cr.cadastroProfessor();
		case 3:
			System.out.println("Voce escolheu Aluno");
			cr.cadastroAluno();
		case 4:
			System.out.println("Voce escolheu voltar");
			inicio();
		}
		sc.close();

	}

	static void login() {
		String user;
		String senha;
		boolean status;
		do {
			System.out.println("Digite seu usuario:");
			user = sc.next();
			System.out.println("Digite a sua senha:");
			senha = sc.next();
			Altenticar(user, senha);
			status = au.getStatus();
			if (status == true) {
				System.out.printf("Seja bem vindo(a) %s \n\n", au.getUsuario());
				inicio();
			} else {
				System.out.println("Falha no login");
				System.out.println("Usuario ou senha invalido");
			}
		} while (status != true);
		sc.close();
	}

	static void Altenticar(String user, String senha) {
		List<String> funcio = new ArrayList<>();
		List<String> senh = new ArrayList<>();

		String path = "c:\\GitHub\\Biblioteca\\CSV\\Funcionarios.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			line = br.readLine();

			while (line != null) {

				String[] vect = line.split(",");
				au.setUsuario(vect[6]);
				au.setSenha(vect[5]);

				funcio.add(au.getUsuario());
				senh.add(au.getSenha());

				line = br.readLine();
			}

			if (funcio.contains(user) && senh.contains(senha)) {
				au.setStatus(true);

			} else {
				au.setStatus(false);

			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
