import java.util.Scanner;

import metodos.Cadastrar;
import metodos.Emprestimo;
import metodos.Relatório;

public class Biblioteca {
	public static void main(String[] args) {
		inicio();
	}

	public static void inicio() {
		int escolha;

		Scanner sc = new Scanner(System.in);

		Cadastrar cr = new Cadastrar();
		Emprestimo em = new Emprestimo();
		Relatório re = new Relatório();

		System.out.println("BIBLIOTECA");
		System.out.println("=============================");
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
		sc.close();
	}
}