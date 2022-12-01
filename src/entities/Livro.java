package entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import metodos.Biblioteca;

public class Livro {
	private int codigo;
	private char tipo;
	private String autor;
	private String titulo;
	private String fatorImpacto;
	private String editora;
	private int anoPublicacao;
	private String issn;

	public Livro(int codigo, char tipo, String autor, String titulo, String issn, String fatorImpacto, String editora,
			int anoPublicacao) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.autor = autor;
		this.titulo = titulo;
		this.fatorImpacto = fatorImpacto;
		this.editora = editora;
		this.anoPublicacao = anoPublicacao;
		this.issn = issn;
	}

	public Livro() {
		this.setCodigo();
	}

	public List<Livro> valores() throws FileNotFoundException, IOException {
		var path = "C:\\GitHub\\Biblioteca\\CSV";

		List<Livro> Livros = new ArrayList<>();
		try (BufferedReader lineReader = new BufferedReader(new FileReader(path + "\\Livros.csv"))) {
			String line = lineReader.readLine();
			while (line != null) {
				line = lineReader.readLine();
				if (line == null || line.isEmpty()) {
					break;
				}
				String[] vect = line.replaceAll("\"", "").split(";");
				Livro Livro = new Livro(Integer.parseInt(vect[0]), vect[1].charAt(0), vect[2], vect[3], vect[4],
						vect[5], vect[6], Integer.parseInt(vect[7]));
				Livros.add(Livro);

			}
			return Livros;
		}
	}

	public void persisteDados(List<Livro> livros) {
		var path = "C:\\GitHub\\Biblioteca\\CSV";

		try {
			FileWriter local = new FileWriter(path + "\\Livros.csv");
			PrintWriter pw = new PrintWriter(local);

			for (int i = 0; i < livros.size(); i++) {
				pw.println(livros.get(i).toString());
				pw.flush();
			}

			pw.close();
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	
	public Livro getLivroCode(List<Livro> livros, String nomeLivroString) {
		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getTitulo() == nomeLivroString)
				return livros.get(i);
		}

		return null;
	}

	// Código,Nome,Titulo,Editora,fatorimpacto,Tipo,AnoPublicação,issn
	public void cadastroItem(List<Livro> livros, List<ItensEmprestimo> itensEmprestimos,
			List<Funcionario> funcionarios, List<Aluno> alunos, List<Emprestimo> emprestimos) {
		Scanner sc = new Scanner(System.in);

		Livro livro = new Livro();

		String es;

		System.out.println("Voce iniciou o cadastro de item");
		do {
			System.out.println("Digite o nome do autor:");
			this.setAutor(sc.nextLine());

			System.out.println("Digite o titulo:");
			this.setTitulo(sc.nextLine());

			System.out.println("Digite a editora:");
			this.setEditora(sc.nextLine());
			System.out.println("Digite o fator de impacto:");
			this.setFatorImpacto(sc.nextLine());

			System.out.println("Digite o tipo [L] livro [P] periodico:");
			this.setTipo(sc.next().toUpperCase().charAt(0));

			System.out.println("Digite o ano de publicação:");
			this.setAnoPublicacao(sc.nextInt());
			while (this.getAnoPublicacao() < 1900 || this.getAnoPublicacao() > 2030) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				this.setAnoPublicacao(sc.nextInt());
			}
			System.out.println("Digite o issn:");
			this.setIssn(sc.next());

			livros.add(livro);

			// escolha de cadastrar novamente;
			System.out.println("Deseja cadastrar mais um iten?");
			System.out.println("[S] Sim [N] Não");
			es = sc.next();
			while (!es.equalsIgnoreCase("s") && !es.equalsIgnoreCase("n")) {
				System.out.println("valor Invalido");
				System.out.println("Digite novamente");
				es = sc.next();
			}
		} while (es.equalsIgnoreCase("s"));
		Biblioteca.inicio(funcionarios, itensEmprestimos, livros, emprestimos, alunos);
		sc.close();
		//enquanto true o código é rodado
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo() {
		Random cod = new Random();
		this.codigo = cod.nextInt(10000000, 99999999);
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getFatorImpacto() {
		return fatorImpacto;
	}

	public void setFatorImpacto(String fatorImpacto) {
		this.fatorImpacto = fatorImpacto;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	@Override
	public String toString() {
		return codigo + ";" + tipo + ";" + autor + ";" + titulo
				+ ";" + issn + ";" + editora + ";" + anoPublicacao;
	}

}