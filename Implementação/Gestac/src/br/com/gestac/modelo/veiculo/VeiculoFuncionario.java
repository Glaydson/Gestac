package br.com.gestac.modelo.veiculo;

import br.com.gestac.modelo.funcionario.Funcionario;

public class VeiculoFuncionario extends Veiculo {

	private Funcionario funcionario;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
