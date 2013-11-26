package br.com.gestac.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.com.gestac.modelo.usuario.TipoUsuario;
import br.com.gestac.modelo.usuario.Usuario;

public class UsuarioDAO {

	private static List<Usuario> usuarios = new ArrayList<Usuario>();

	public static void adicionar(Usuario usuario) {
		usuarios.add(usuario);
	}

	public static String obterTipoUsuario(String login) {

		TipoUsuario tipoUsuario = null;
		for (Usuario u : usuarios) {
			if (u.getLogin().equals(login)) {
				tipoUsuario = u.getTipo();
				break;
			}
		}
		return tipoUsuario.name();
	}

	public static Usuario buscarPeloLogin(String login) {
		Usuario usuario = null;
		for (Usuario u : usuarios) {
			if (u.getLogin().equals(login)) {
				usuario = u;
				break;
			}
		}
		return usuario;
	}

}
