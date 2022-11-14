package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import entities.Livros;

public class Cadastrar {

	public Scanner sc = new Scanner(System.in);

	public void cadastroItem() {
		String path = "C:\\GitHub\\Biblioteca\\CSV\\Livros.txt";

		int issnlivro, ano;
		String autorlivro, titulolivro, editoralivro, es;
		char tipolivro;
		int codigolivro = 1;

		do {
			System.out.println("Voce iniciou o cadastro de item");
			System.out.println("Digite o nome do autor:");
			autorlivro = sc.next();

			System.out.println("Digite o titulo:");
			sc.nextLine();
			titulolivro = sc.nextLine();

			System.out.println("Digite a editora:");
			editoralivro = sc.nextLine();

			System.out.println("Digite o tipo [L] livro [P] periodico:");
			tipolivro = sc.next().charAt(0);
			Character.toUpperCase(tipolivro);

			System.out.println("Digite o ano de publicação:");
			ano = sc.nextInt();
			while (ano < 1900 || ano > 2030) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				ano = sc.nextInt();
			}
			
			System.out.println("Digite o issn:");
			issnlivro = sc.nextInt();
			while (issnlivro > 99999999 || issnlivro < 10000000) {
				System.out.println("Valor invalido");
				System.out.println("Digite novamente");
				issnlivro = sc.nextInt();
			}

			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//				Gerar o codigo unico;
				String line = br.readLine();
				while (line != null) {

					codigolivro++;
					line = br.readLine();

				}
				Livros li = new Livros(codigolivro, autorlivro, titulolivro, editoralivro, tipolivro,
						ano, issnlivro);

				FileWriter adicionar = new FileWriter(path, true);
				PrintWriter pw = new PrintWriter(adicionar);

				pw.println(li.toString());
				pw.flush();
				pw.close();

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
