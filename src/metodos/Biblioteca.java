package metodos;

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

		inicio();
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
		
		switch(escolha){
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
		sc.close();
	}
	
}