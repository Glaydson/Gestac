package br.com.gestac.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.com.gestac.modelo.funcionario.Funcionario;
import br.com.gestac.modelo.veiculo.Veiculo;

public class FuncionarioDAO {

	private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	public static void adicionar(Funcionario funci) {
		funcionarios.add(funci);
	}

	public static Funcionario buscarPelaMatricula(int matricula) {
		Funcionario funcionario = null;
		for (Funcionario func : funcionarios) {
			if (func.getMatricula() == matricula) {
				funcionario = func;
				break;
			}
		}

		return funcionario;
	}

	public static Funcionario buscarPeloLogin(String login) {
		Funcionario funcionario = null;
		for (Funcionario func : funcionarios) {
			if (func.getUsuario().getLogin().equals(login)) {
				funcionario = func;
				break;
			}
		}
		return funcionario;

	}

	public static void adicionarVeiculo(Funcionario func, Veiculo veiculo) {
		func.getVeiculos().add(veiculo);
	}

}
