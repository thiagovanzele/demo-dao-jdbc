package aplicacao;

import java.util.Date;
import java.util.List;

import negocio.dao.FabricaDao;
import negocio.dao.VendedorDao;
import negocio.entidades.Departamento;
import negocio.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {

				
		VendedorDao vendedorDao = FabricaDao.criarVendedorDao();
		
		System.out.println("=== TEST 1: vendedor filtrarPorId ===");
		Vendedor vendedor = vendedorDao.filtrarPorId(3);
		
		System.out.println(vendedor);
		
		System.out.println("\n=== TEST 2: vendedor filtrarPorDepartamento ===");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> list = vendedorDao.filtrarPorDepartamento(departamento);
		for (Vendedor obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: vendedor filtrarTudo ===");
		list = vendedorDao.filtrarTodos();
		for (Vendedor obj : list) {
			System.out.println(obj);
		}
		
		/*System.out.println("\n=== TEST 4: vendedor inserir ===");
		Vendedor novoVendedor = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departamento);
		vendedorDao.inserir(novoVendedor);
		System.out.println("Inserido!  Novo id = " + novoVendedor.getId());*/
		
		System.out.println("\n=== TEST 5: vendedor atualizar ===");
		vendedor = vendedorDao.filtrarPorId(1);
		vendedor.setNome("Marta Waine");
		vendedor.setEmail("marta@gmail.com");
		vendedorDao.atualizar(vendedor);
		System.out.println("Vendedor atualizado!");

	}

}
