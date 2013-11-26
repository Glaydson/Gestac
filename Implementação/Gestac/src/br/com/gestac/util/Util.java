package br.com.gestac.util;

import br.com.gestac.modelo.usuario.TipoUsuario;

public class Util {

	public static String obterUsuarioLogado(TipoUsuario tipo) {
		String login = null;
		if (tipo.equals(TipoUsuario.GESTOR)) {
			login = "usuario1";
		}
		if (tipo.equals(TipoUsuario.ADMINISTRATIVO)) {
			login = "usuario2";
		}
		if (tipo.equals(TipoUsuario.FUNCIONARIO)) {
			login = "usuario3";
		}
		return login;
	}
}
