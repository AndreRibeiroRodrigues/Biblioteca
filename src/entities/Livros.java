package entities;

public class Livros {
	private int codigo, issn;
	private String autor, titulo, editora, anopublicacao;
	private char tipo;

	public Livros(int codigo, String autor, String titulo, String editora,char tipo,  String anopublicacao, int issn) {
		super();
		this.codigo = codigo;
		this.autor = autor;
		this.titulo = titulo;
		this.editora = editora;
		this.tipo = tipo;
		this.anopublicacao = anopublicacao;
		this.issn = issn;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getIssn() {
		return issn;
	}

	public void setIssn(int issn) {
		this.issn = issn;
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

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAnopublicacao() {
		return anopublicacao;
	}

	public void setAnopublicacao(String anopublicacao) {
		this.anopublicacao = anopublicacao;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return codigo + "," + autor + "," + titulo + "," + editora + "," + tipo + "," + anopublicacao + "," + issn;
	}

}
