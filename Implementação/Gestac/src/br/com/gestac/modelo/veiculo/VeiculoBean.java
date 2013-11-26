package br.com.gestac.modelo.veiculo;

import java.util.ArrayList;
import java.util.List;

import br.com.gestac.modelo.funcionario.Funcionario;
import br.com.gestac.modelo.funcionario.FuncionarioBean;
import br.com.gestac.modelo.usuario.TipoUsuario;
import br.com.gestac.modelo.usuario.UsuarioBean;
import br.com.gestac.persistencia.VeiculoDAO;
import br.com.gestac.util.Util;

public class VeiculoBean {

	private static final String BRANCO = "";
	private Veiculo veiculo;
	private String tipoVeiculo;

	public VeiculoBean() {
		adicionarVeiculos();
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String registrarEntrada() {

		return "resultadoRegistrarEntrada";

	}

	public String obterVeiculoInclusao(String login) {
		String tipoUsuario = UsuarioBean.obterTipoUsuario(login);

		if (tipoUsuario.equals(TipoUsuario.GESTOR.toString())) {
			veiculo = new VeiculoEmpresa();
			this.setTipoVeiculo("Empresa");
		} else {
			veiculo = new VeiculoFuncionario();
			if (tipoUsuario.equals(TipoUsuario.ADMINISTRATIVO)) {
				this.setTipoVeiculo("Deficiente");
			} else {
				this.setTipoVeiculo("Funcionário");
			}
		}
		return "registrarVeiculo";

	}

	/**
	 * Registra um novo veículo no sistema
	 * 
	 * @return
	 * @throws Exception
	 *             Caso ocorram erros na validação do novo veículo, ou o
	 *             funcionário ao qual pertence o veículo já possua 2 veículos
	 *             registrados.
	 */
	public String registrarVeiculo() throws Exception {
		validar();
		if (veiculo instanceof VeiculoFuncionario) {
			String login = Util.obterUsuarioLogado(TipoUsuario.FUNCIONARIO);
			Funcionario func = FuncionarioBean.obterFuncionarioPeloLogin(login);
			if (func.getVeiculos().size() == 2) {
				throw new Exception(
						"Limite de veículos por funcionário excedido!");
			}
			FuncionarioBean.adicionarVeiculo(func, veiculo);
		}
		VeiculoDAO.adicionar(veiculo);

		return "veiculoRegistrado";
	}

	public Veiculo buscarVeiculoPelaPlaca(String placas) throws Exception {
		return VeiculoDAO.buscarPelaPlaca(placas);
	}

	private void validar() throws Exception {
		List<String> erros = new ArrayList<String>();
		if (veiculo.getCor().equals(BRANCO)) {
			erros.add("Cor não preenchida");
		}
		if (veiculo.getMarca().equals(BRANCO)) {
			erros.add("Marca não preenchida");
		}
		if (erros.size() != 0) {
			throw new Exception(erros.toString());
		}
	}

	/**
	 * Adiciona alguns veículos para teste.
	 */
	public static void adicionarVeiculos() {
		Veiculo veiculo1 = new VeiculoFuncionario();
		veiculo1.setCor("Preta");
		veiculo1.setMarca("Chevrolet");
		veiculo1.setModelo("Cruze");
		veiculo1.setPlacas("HHH-3030");
		Funcionario func = FuncionarioBean.buscarPelaMatricula(1);
		((VeiculoFuncionario) veiculo1).setFuncionario(func);
		VeiculoDAO.adicionar(veiculo1);

		Veiculo veiculo2 = new VeiculoFuncionario();
		veiculo2.setCor("Azul");
		veiculo2.setMarca("Fiat");
		veiculo2.setModelo("Palio");
		veiculo2.setPlacas("HHH-4040");
		Funcionario func2 = FuncionarioBean.buscarPelaMatricula(2);
		((VeiculoFuncionario) veiculo1).setFuncionario(func2);
		VeiculoDAO.adicionar(veiculo2);

		Veiculo veiculo3 = new VeiculoEmpresa();
		veiculo3.setCor("Branco");
		veiculo3.setMarca("Ford");
		veiculo3.setModelo("KA");
		veiculo3.setPlacas("HHH-5050");
		VeiculoDAO.adicionar(veiculo3);

	}
}
