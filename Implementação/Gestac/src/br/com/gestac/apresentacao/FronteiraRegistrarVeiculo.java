package br.com.gestac.apresentacao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gestac.modelo.usuario.TipoUsuario;
import br.com.gestac.modelo.usuario.UsuarioBean;
import br.com.gestac.modelo.veiculo.Veiculo;
import br.com.gestac.modelo.veiculo.VeiculoBean;
import br.com.gestac.util.Util;

@ManagedBean
@SessionScoped
public class FronteiraRegistrarVeiculo {

	private VeiculoBean bean = new VeiculoBean();
	private UsuarioBean beanUsuario = new UsuarioBean();

	public String iniciarRegistrarVeiculo() {
		String login = Util.obterUsuarioLogado(TipoUsuario.GESTOR);
		return bean.obterVeiculoInclusao(login);
	}

	public String registrarVeiculo() {
		try {
			return bean.registrarVeiculo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public VeiculoBean getBean() {
		return bean;
	}

	public void setBean(VeiculoBean bean) {
		this.bean = bean;
	}

	public Veiculo buscarVeiculoPelaPlaca(String placas) {
		Veiculo v = null;
		try {
			v = bean.buscarVeiculoPelaPlaca(placas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}
}
