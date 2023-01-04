package negocio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import negocio.dao.DepartamentoDao;
import negocio.entidades.Departamento;

public class DepartamentoDaoJdbc implements DepartamentoDao {

	private Connection conn;

	public DepartamentoDaoJdbc(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(Departamento obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO  department " + "(Name) " + "VALUES (?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNome());

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Erro inesperado! Nenhuma linha foi alterada!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void atualizar(Departamento obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE department " + "SET Name = ? " + "WHERE id = ?");

			st.setString(1, obj.getNome());
			st.setInt(2, obj.getId());

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new DbException("Erro inesperado! Atualizacao nao concluida!");
			} else {
				System.out.println("Atualizacao concluida!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deletePorId(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM department " + "WHERE Id = ?");

			st.setInt(1, id);

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new DbException("Delete incompleto! O Id nao existe!");
			} else {
				System.out.println("Delete completo!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public Departamento filtrarPorId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT id, Name as DepName "
					+ "FROM department "
					+ "WHERE id = ?"); 

			st.setInt(1, id);

			rs = st.executeQuery();
			if (rs.next()) {
				Departamento dep = instanciarDepartamento(rs);
				return dep;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public List<Departamento> filtrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	private Departamento instanciarDepartamento(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("Id"));
		dep.setNome(rs.getString("DepName"));
		return dep;
	}

}
