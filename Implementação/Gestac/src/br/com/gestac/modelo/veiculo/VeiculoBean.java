package br.com.gestac.modelo.veiculo;

import br.com.gestac.modelo.usuario.TipoUsuario;
import br.com.gestac.modelo.usuario.UsuarioBean;

public class VeiculoBean {
	public Veiculo obterVeiculoInclusao(String login) {
		Veiculo veiculo = null;
		String tipoUsuario = UsuarioBean.obterUsuarioLogado(login);
		if (tipoUsuario.equals(TipoUsuario.GESTOR.toString())) {
			veiculo = new VeiculoEmpresa();
		} else {
			veiculo = new VeiculoFuncionario();
		}

		return veiculo;
	}

}
