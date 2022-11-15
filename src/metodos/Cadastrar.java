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

		Livros li = new Livros();
		
		int issn, ano;
		String autor, titulo, editora, es;
		char tipo;
		int codigo = 1;

		do {
			System.out.println("Voce iniciou o cadastro de item");
			System.out.println("Digite o nome do autor:");
			autor = sc.nextLine();
			li.setAutor(autor);
			
			System.out.println("Digite o titulo:");
			titulo = sc.nextLine();
			li.setTitulo(titulo);
			
			System.out.println("Digite a editora:");
			editora = sc.nextLine();
			li.setEditora(editora);
			
			System.out.println("Digite o tipo [L] livro [P] periodico:");
			tipo = sc.next().toUpperCase().charAt(0);
			li.setTipo(tipo);
			System.out.println(li.getTipo());
			System.out.println("Digite o ano de publicação:");
			ano = sc.nextInt();
			while (ano < 1900 || ano > 2030) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				ano = sc.nextInt();
			}
			li.setAnopublicacao(ano);
			
			System.out.println("Digite o issn:");
			issn = sc.nextInt();
			while (issn > 99999999 || issn < 10000000) {
				System.out.println("Valor invalido");
				System.out.println("Digite novamente");
				issn = sc.nextInt();
			}
			li.setIssn(issn);
			
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//				Gerar o codigo unico;
				String line = br.readLine();
				while (line != null) {

					codigo++;
					line = br.readLine();

				}
				li.setCodigo(codigo);

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
