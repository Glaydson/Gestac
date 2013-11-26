package br.com.gestac.modelo.usuario;

import br.com.gestac.persistencia.UsuarioDAO;

public class UsuarioBean {

	public UsuarioBean() {
		adicionarUsuarios();
	}

	public static void adicionarUsuarios() {
		Usuario usuario1 = new Usuario();
		usuario1.setLogin("usuario1");
		usuario1.setSenha("senha1");
		usuario1.setTipo(TipoUsuario.GESTOR);
		UsuarioDAO.adicionar(usuario1);

		Usuario usuario2 = new Usuario();
		usuario2.setLogin("usuario2");
		usuario2.setSenha("senha2");
		usuario2.setTipo(TipoUsuario.ADMINISTRATIVO);
		UsuarioDAO.adicionar(usuario2);

		Usuario usuario3 = new Usuario();
		usuario3.setLogin("usuario3");
		usuario3.setSenha("senha3");
		usuario3.setTipo(TipoUsuario.FUNCIONARIO);
		UsuarioDAO.adicionar(usuario3);

		Usuario usuario4 = new Usuario();
		usuario4.setLogin("usuario4");
		usuario4.setSenha("senha4");
		usuario4.setTipo(TipoUsuario.FUNCIONARIO);
		UsuarioDAO.adicionar(usuario4);
	}

	public static String obterTipoUsuario(String login) {

		return UsuarioDAO.obterTipoUsuario(login);
	}

	public static Usuario buscarPeloLogin(String login) {
		return UsuarioDAO.buscarPeloLogin(login);
	}

}
