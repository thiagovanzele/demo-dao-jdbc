package negocio.dao;

import db.DB;
import negocio.dao.impl.DepartamentoDaoJdbc;
import negocio.dao.impl.VendedorDaoJdbc;

public class FabricaDao {

	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJdbc(DB.getConnection());
	}
	
	public static DepartamentoDao criarDepartamentoDao() {
		return new DepartamentoDaoJdbc(DB.getConnection());
	}
}
