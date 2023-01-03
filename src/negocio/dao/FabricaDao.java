package negocio.dao;

import negocio.dao.impl.VendedorDaoJdbc;

public class FabricaDao {

	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJdbc();
	}
}
