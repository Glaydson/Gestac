package br.com.gestac.modelo.usuario;

public enum TipoUsuario {

	GESTOR("Gestor"), ADMINISTRATIVO("Administrativo"), FUNCIONARIO(
			"Funcion�rio");

	String tipoUsuario;

	private TipoUsuario(String tipo) {
		this.tipoUsuario = tipo;
	}

}
