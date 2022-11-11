package biblioteca;

public class Periodicos {
	int codigo,issn;
	String autor,titulo, editora, tipo, anopublicação;
	public Periodicos(int codigo, String autor, String titulo, String editora, String tipo, String anopublicação,
			int issn) {
		super();
		this.codigo = codigo;
		this.autor = autor;
		this.titulo = titulo;
		this.editora = editora;
		this.tipo = tipo;
		this.anopublicação = anopublicação;
		this.issn = issn;
	}
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
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getAnopublicação() {
		return anopublicação;
	}
	public void setAnopublicação(String anopublicação) {
		this.anopublicação = anopublicação;
	}
	public int getIssn() {
		return issn;
	}
	public void setIssn(int issn) {
		this.issn = issn;
	}
	@Override
	public String toString() {
		return codigo + "," + issn + "," + autor + "," + titulo + "," + editora + "," + tipo + "," + anopublicação;
	}
	
	
	
	
	
}
