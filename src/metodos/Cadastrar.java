package metodos;

import java.util.Scanner;

public class Cadastrar {

	public Scanner sc = new Scanner(System.in);
	private int issn, dia, mes, ano;
	private String autor, titulo, editora, anopublicação, es;
	private char tipo;

	public void cadastroItem() {
		do {
			System.out.println("Voce iniciou o cadastro de item");
			System.out.println("Digite o nome do autor:");
			autor = sc.next();
			System.out.println("Digite o titulo:");
			titulo = sc.next();
			System.out.println("Digite a editora:");
			editora = sc.next();
			System.out.println("Digite o tipo [L] livro [P] periodico:");
			tipo = sc.next().charAt(0);
			System.out.println("Digite o ano de publicação:");
			System.out.println("Digite o dia:");
			dia = sc.nextInt();
			while (dia < 1 || dia > 31) {
				System.out.println("Valor digitado invalido");
				dia = sc.nextInt();
			}
			System.out.println("Digite o Mês");
			mes = sc.nextInt();
			while (mes < 1 || mes > 12) {
				System.out.println("Valor digitado invalido");
				mes = sc.nextInt();
			}
			System.out.println("Digite o Ano");
			ano = sc.nextInt();
			while (ano < 1900 || ano > 2030) {
				System.out.println("Valor digitado invalido");
				ano = sc.nextInt();
			}
			anopublicação = dia + "/" + mes + "/" + ano;
			System.out.println(anopublicação);
			System.out.println("Digite o issn:");
			issn = sc.nextInt();
			
			
//			escolha de cadastrar novamente
			System.out.println("Deseja cadastrar mais um iten?");
			System.out.println("[S] Sim [N] Não");
			es = sc.next();
			while (!es.equalsIgnoreCase("s") || es.equalsIgnoreCase("n")) {
				System.out.println("valor Invalido");
				System.out.println("Digite novamente");
				es = sc.next();
			}
		} while (es.equalsIgnoreCase("s"));
	}

	public void cadastroUsuario() {

	}

}
