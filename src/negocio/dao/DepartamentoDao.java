package negocio.dao;

import java.util.List;

import negocio.entidades.Departamento;

public interface DepartamentoDao {

	void inserir(Departamento obj);
	void atualizar(Departamento obj);
	void deletePorId(Integer id);
	Departamento filtrarPorId(Integer id);
	List <Departamento> filtrarTodos();
}
