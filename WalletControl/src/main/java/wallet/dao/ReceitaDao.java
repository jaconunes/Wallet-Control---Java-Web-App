package wallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import wallet.model.Receita;

/**
 * Classe DAO que representa a classe Receita e faz as devidas conexões com o
 * banco de dados.
 * 
 * @author jaconunes
 *
 */

public class ReceitaDao {

	/**
	 * Método faz conexão com o banco de dados e realiza o cadastro de um objeto
	 * Receita.
	 * 
	 * @param receita
	 */
	public void cadastrarReceita(Receita receita) {

		String sql = "INSERT INTO RECEITA VALUES (null,?,?,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection conn = null;

		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setDouble(1, receita.getValorReceita());
			pStatement.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(receita.getDataRecebimento()));
			pStatement.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(receita.getDataRecebimentoEsperado()));
			pStatement.setString(4, receita.getDescricao());
			pStatement.setInt(5, receita.getCodigoConta());
			pStatement.setString(6, receita.getTipoReceita());
			pStatement.execute();

		} catch (Exception e) {
			System.out.println("Deu erro aqui!");
			e.printStackTrace();

		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	/**
	 * Método faz conexão com o banco de dados e realiza a consulta pelo id
	 * retornando um objeto Receita.
	 * 
	 * @param id
	 * @return Receita
	 */
	public Receita BuscarReceitaPorId(int id) {
		String sql = "SELECT * FROM RECEITA WHERE idReceita = ?";
		ResultSet rs = null;
		PreparedStatement pStatement = null;
		Connection conn = null;
		Receita receita = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			if (rs != null && rs.next()) {
				receita = new Receita();
				receita.setIdReceita(rs.getInt("idReceita"));
				receita.setValorReceita(rs.getDouble("valorReceita"));
				receita.setDataRecebimento(rs.getDate("dataRecebimento"));
				receita.setDataRecebimentoEsperado(rs.getDate("dataRecebimentoEsperado"));
				receita.setDescricao(rs.getString("descricao"));
				receita.setCodigoConta(rs.getInt("codigoConta"));
				receita.setTipoReceita(rs.getString("tipoReceita"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return receita;
	}

	/**
	 * Método faz conexão com o banco de dados e retorna uma lista de objetos
	 * Receita.
	 */
	public ArrayList<Receita> ListarReceitas() {
		String sql = "SELECT * FROM RECEITA";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Receita receita = null;
		ArrayList<Receita> receitas = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if (rs != null) {
				receitas = new ArrayList<Receita>();
				while (rs.next()) {
					receita = new Receita();
					receita.setIdReceita(rs.getInt("idReceita"));
					receita.setValorReceita(rs.getDouble("valorReceita"));
					receita.setDataRecebimento(rs.getDate("dataRecebimento"));
					receita.setDataRecebimentoEsperado(rs.getDate("dataRecebimentoEsperado"));
					receita.setDescricao(rs.getString("descricao"));
					receita.setCodigoConta(rs.getInt("codigoConta"));
					receita.setTipoReceita(rs.getString("tipoReceita"));
					receitas.add(receita);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return receitas;
	}

	/**
	 * Método faz conexão com o banco de dados, consulta pelo tipo e retorna uma
	 * lista de objetos Receita.
	 * 
	 * @param tipoReceita
	 * @return List Receita
	 */
	public ArrayList<Receita> buscarReceitasPorTipo(String tipoReceita) {
		String sql = "SELECT * FROM RECEITA WHERE tipoReceita = ?";
		ResultSet rs = null;
		PreparedStatement pStatement = null;
		Connection conn = null;
		Receita receita = null;
		ArrayList<Receita> receitas = null;

		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, tipoReceita);
			rs = pStatement.executeQuery();
			if (rs != null) {
				receitas = new ArrayList<Receita>();
				while (rs.next()) {
					receita = new Receita();
					receita.setIdReceita(rs.getInt("idReceita"));
					receita.setValorReceita(rs.getDouble("valorReceita"));
					receita.setDataRecebimento(rs.getDate("dataRecebimento"));
					receita.setDataRecebimentoEsperado(rs.getDate("dataRecebimentoEsperado"));
					receita.setDescricao(rs.getString("descricao"));
					receita.setCodigoConta(rs.getInt("codigoConta"));
					receita.setTipoReceita(rs.getString("tipoReceita"));
					receitas.add(receita);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return receitas;
	}

	/**
	 * Método faz conexão com o banco de dados, consulta por periodo de datas e
	 * retorna uma lista de objetos Receita.
	 * 
	 * @param dataInicio
	 * @param dataFim
	 * @return List Receita
	 */
	public ArrayList<Receita> buscarReceitasPorPeriodo(String dataInicio, String dataFim) {
		String sql = "SELECT * FROM RECEITA WHERE (dataRecebimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "')";
		ResultSet rs = null;
		PreparedStatement pStatement = null;
		Connection conn = null;
		Receita receita = null;
		ArrayList<Receita> receitas = null;

		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if (rs != null) {
				receitas = new ArrayList<Receita>();
				while (rs.next()) {
					receita = new Receita();
					receita.setIdReceita(rs.getInt("idReceita"));
					receita.setValorReceita(rs.getDouble("valorReceita"));
					receita.setDataRecebimento(rs.getDate("dataRecebimento"));
					receita.setDataRecebimentoEsperado(rs.getDate("dataRecebimentoEsperado"));
					receita.setDescricao(rs.getString("descricao"));
					receita.setCodigoConta(rs.getInt("codigoConta"));
					receita.setTipoReceita(rs.getString("tipoReceita"));
					receitas.add(receita);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return receitas;
	}

	/**
	 * Método faz conexão com o banco de dados e faz a exclusão de um objeto Receita
	 * pelo id.
	 * 
	 * @param idReceita
	 */
	public void ExcluirReceita(int idReceita) {
		String sql = "DELETE FROM RECEITA WHERE idReceita = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, idReceita);
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	/**
	 * Método faz conexão com o banco de dados e faz a alteração de um objeto
	 * Receita pelo id.
	 * 
	 * @param receita
	 */
	public void AlterarReceita(Receita receita) {
		String sql = "UPDATE RECEITA SET valorReceita = ?, dataRecebimento = ?, "
				+ "dataRecebimentoEsperado = ?, descricao = ?, codigoConta = ?, "
				+ "tipoReceita = ? WHERE idReceita = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setDouble(1, receita.getValorReceita());
			pStatement.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(receita.getDataRecebimento()));			
			pStatement.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(receita.getDataRecebimentoEsperado()));
			pStatement.setString(4, receita.getDescricao());
			pStatement.setInt(5, receita.getCodigoConta());
			pStatement.setString(6, receita.getTipoReceita());
			pStatement.setInt(7, receita.getIdReceita());
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
