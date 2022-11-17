package entities;

public class Livros {
	private int codigo;
	private String autor, titulo, issn, fatorImpacto, editora, anopublicação;
	private char tipo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public String getAnopublicação() {
		return anopublicação;
	}

	public void setAnopublicação(String anopublicação) {
		this.anopublicação = anopublicação;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return codigo + "," + autor + "," + titulo + "," + tipo + "," + issn;
	}

}
