package br.com.gestac.apresentacao;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import br.com.gestac.modelo.usuario.TipoUsuario;
import br.com.gestac.modelo.usuario.UsuarioBean;
import br.com.gestac.modelo.veiculo.Veiculo;
import br.com.gestac.modelo.veiculo.VeiculoBean;
import br.com.gestac.util.Util;

@ManagedBean
@SessionScoped
public class FronteiraRegistrarVeiculo {

	private VeiculoBean beanVeiculos = new VeiculoBean();
	private UsuarioBean beanUsuarios = new UsuarioBean();

	public String iniciarRegistrarVeiculo() {
		String login = Util.obterUsuarioLogado(TipoUsuario.GESTOR);
		return beanVeiculos.obterVeiculoInclusao(login);
	}

	public String listarVeiculos() {
		return beanVeiculos.listarVeiculos();
	}

	public String registrarVeiculo() {
		try {
			return beanVeiculos.registrarVeiculo();
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}
		return null;
	}

	public VeiculoBean getBeanVeiculos() {
		return beanVeiculos;
	}

	public void setBeanVeiculos(VeiculoBean bean) {
		this.beanVeiculos = bean;
	}

	public Veiculo buscarVeiculoPelaPlaca(String placas) {
		Veiculo v = null;
		try {
			v = beanVeiculos.buscarVeiculoPelaPlaca(placas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}
}
