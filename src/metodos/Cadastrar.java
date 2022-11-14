package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import entities.Livros;

public class Cadastrar {

	public Scanner sc = new Scanner(System.in);

	public void cadastroItem() {
		String path = "C:\\Users\\andrerodrigues\\git\\Biblioteca\\CSV\\Livros.txt";
		

		int issnlivro, dia, mes, ano;
		String autorlivro, titulolivro, editoralivro, anopublicacaolivro, es;
		char tipolivro;
		int codigolivro = 0;

		do {
			System.out.println("Voce iniciou o cadastro de item");
			System.out.println("Digite o nome do autor:");
			autorlivro = sc.next();
			System.out.println("Digite o titulo:");
			titulolivro = sc.next();
			System.out.println("Digite a editora:");
			editoralivro = sc.next();
			System.out.println("Digite o tipo [L] livro [P] periodico:");
			tipolivro = sc.next().charAt(0);
			Character.toUpperCase(tipolivro);
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
			anopublicacaolivro = dia + "/" + mes + "/" + ano;
			System.out.println("Digite o issn:");
			issnlivro = sc.nextInt();
			while(issnlivro > 99999999 || issnlivro < 10000000)

			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//				Gerar o codigo unico;
				String line = br.readLine();
				while (line != null) {

					codigolivro++;
					line = br.readLine();

				}
				Livros li = new Livros(codigolivro, autorlivro, titulolivro, editoralivro, tipolivro,
						anopublicacaolivro, issnlivro);
				FileWriter adicionar = new FileWriter(path, true);

				if (line == null) {
					
					adicionar.append(li.toString() + "\n");
					adicionar.close();
				}

			}

			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}

//			escolha de cadastrar novamente;
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

	public void cadastroUsuario() {

	}

}
