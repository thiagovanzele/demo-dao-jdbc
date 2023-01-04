package aplicacao;

import java.util.ArrayList;
import java.util.List;

import negocio.dao.DepartamentoDao;
import negocio.dao.FabricaDao;
import negocio.entidades.Departamento;

public class Programa2 {

	public static void main(String[] args) {
		
		DepartamentoDao departamentoDao = FabricaDao.criarDepartamentoDao();

		/*System.out.println("=== TESTE 1: departamento inserir ===");
		Departamento dep = new Departamento(null, "Cakes");
		departamentoDao.inserir(dep);
		System.out.println("Departamento " + dep.getNome() + " inserido!");*/
		
		System.out.println("\n=== TESTE 2: departamento atualizar ===");
		Departamento dep = departamentoDao.filtrarPorId(7);
		dep.setNome("Chocolates");
		departamentoDao.atualizar(dep);
		
		
		
		System.out.println("\n=== TESTE 3: departamento filtrarPorId ===");
		dep = departamentoDao.filtrarPorId(2);
		
		System.out.println(dep);
		
		System.out.println("\n=== TESTE 4: departamento filtrarTodos ===");
		List<Departamento> list = new ArrayList<>();
		list = departamentoDao.filtrarTodos();
		for (Departamento dp : list) {
			System.out.println(dp);
		}
		
		System.out.println("\n=== TESTE 5: departamento deletar ===");
		departamentoDao.deletePorId(17);
		
	}

}
