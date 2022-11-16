package entities;

public class Auth {
	String usuario, senha;
	boolean status;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean getStatus() {
		return status;

	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
