package aplicacao;

import negocio.dao.DepartamentoDao;
import negocio.dao.FabricaDao;
import negocio.entidades.Departamento;

public class Programa2 {

	public static void main(String[] args) {
		
		DepartamentoDao departamentoDao = FabricaDao.criarDepartamentoDao();

		System.out.println("\n === TESTE 1: departamento inserir ===");
		Departamento dep = new Departamento(null, "Foods");
		departamentoDao.inserir(dep);
		System.out.println("Departamento " + dep.getNome() + " inserio!");
	}

}
