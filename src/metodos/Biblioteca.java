package metodos;

import java.util.Scanner;

import entities.Auth;

public class Biblioteca {
	static Scanner sc = new Scanner(System.in);
	public static Auth au = new Auth();

	public static void main(String[] args) {

		login();
	}

	public static void inicio() {
		int escolha;

		Cadastrar cr = new Cadastrar();
		Emprestimo em = new Emprestimo();
		Relatório re = new Relatório();

		System.out.println("BIBLIOTECA");
		System.out.println("------------------");
		System.out.println("[1] Cadastro de itens " + "[2] Cadastro de usuarios " + "[3] Emprestico de itens "
				+ "[4] Emitir Relaório " + "[5] sair");
		escolha = sc.nextInt();

		switch (escolha) {

		case 1:
			cr.cadastroItem();
		case 2:
			cr.cadastroUsuario();
		case 3:
			em.EmprestimoLivro();
		case 4:
			re.Relatorio();
		case 5:
			System.out.println("Voce saiu");
		}
		System.out.println("erro");
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
			autenticar.Altenticar(user, senha);
			status = au.getStatus();
			if (status == true) {
				System.out.println(au.getUsuario() + "Logado(a) com sucesso");
				inicio();
			} else {
				System.out.println("Falha no login");
				System.out.println("Usuario ou senha invalido");
			}
		} while (status != true);
	}

}