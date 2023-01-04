package aplicacao;

import negocio.dao.DepartamentoDao;
import negocio.dao.FabricaDao;
import negocio.entidades.Departamento;

public class Programa2 {

	public static void main(String[] args) {
		
		DepartamentoDao departamentoDao = FabricaDao.criarDepartamentoDao();

		/*System.out.println("=== TESTE 1: departamento inserir ===");
		Departamento dep = new Departamento(null, "Foods");
		departamentoDao.inserir(dep);
		System.out.println("Departamento " + dep.getNome() + " inserido!");
		
		System.out.println("\n=== TESTE 2: departamento atualizar ===");
		dep.setNome("Fruits");
		dep.setId(7);
		departamentoDao.atualizar(dep);*/
		
		/*System.out.println("\n=== TESTE 3: departamento deletar ===");
		departamentoDao.deletePorId(12);*/
		
		System.out.println("\n=== TESTE 4: departamento filtrar ===");
		Departamento dep = new Departamento();
		dep = departamentoDao.filtrarPorId(2);
		
		System.out.println(dep);
		
	}

}
