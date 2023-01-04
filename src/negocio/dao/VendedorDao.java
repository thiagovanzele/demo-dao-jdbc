package negocio.dao;

import java.util.List;

import negocio.entidades.Departamento;
import negocio.entidades.Vendedor;

public interface VendedorDao {

	void inserir(Vendedor obj);
	void atualizar(Vendedor obj);
	void deletePorId(Integer id);
	Vendedor filtrarPorId(Integer id);
	List <Vendedor> filtrarTodos();
	List <Vendedor> filtrarPorDepartamento(Departamento departamento);
}
