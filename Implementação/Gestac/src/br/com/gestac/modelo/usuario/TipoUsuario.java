package br.com.gestac.modelo.usuario;

public enum TipoUsuario {

	GESTOR("Gestor"), ADMINISTRATIVO("Administrativo"), FUNCIONARIO(
			"Funcionário");

	String tipoUsuario;

	private TipoUsuario(String tipo) {
		this.tipoUsuario = tipo;
	}

}
