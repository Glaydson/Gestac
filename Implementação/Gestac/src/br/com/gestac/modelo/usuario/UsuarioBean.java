package br.com.gestac.modelo.usuario;

import br.com.gestac.persistencia.UsuarioDAO;

public class UsuarioBean {

	public UsuarioBean() {
		Usuario usuario1 = new Usuario();
		usuario1.setLogin("usuario1");
		usuario1.setSenha("senha");
		usuario1.setTipo(TipoUsuario.GESTOR);
		UsuarioDAO.adicionar(usuario1);

	}
	
	public static String obterUsuarioLogado(String login){
		return UsuarioDAO.buscarPeloLogin(login);
	}

}
