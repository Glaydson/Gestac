package br.com.gestac.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.com.gestac.modelo.usuario.Usuario;

public class UsuarioDAO {
	private static List<Usuario> usuarios = new ArrayList<Usuario>();

	public static void adicionar(Usuario usuario) {
		usuarios.add(usuario);
	}

	public static String buscarPeloLogin(String login) {
		String tipo = null;
		for (Usuario u : usuarios) {
			if (u.getLogin().equals(login)) {
				tipo = u.getTipo().toString();
			}

		}
		return tipo;
	}

}
