package aplicacao;

import negocio.dao.FabricaDao;
import negocio.dao.VendedorDao;
import negocio.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {

				
		VendedorDao vendedorDao = FabricaDao.criarVendedorDao();
		
		Vendedor vendedor = vendedorDao.filtrarPorId(3);
		
		System.out.println(vendedor);
	}

}
