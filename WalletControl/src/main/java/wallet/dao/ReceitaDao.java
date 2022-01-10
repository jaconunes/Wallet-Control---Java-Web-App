package wallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import wallet.model.Receita;

public class ReceitaDao {
	
	public void cadastrarReceita(Receita receita) {
		
		String sql = "INSERT INTO RECEITA VALUES (null,?,?,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection conn = null;		
		SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");  
        String strDataRecebimento = formatoData.format(receita.getDataRecebimento());
        String strDataRecebimentoEsperado = formatoData.format(receita.getDataRecebimentoEsperado());
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setDouble(1, receita.getValorReceita());
			pStatement.setString(2, strDataRecebimento);
			pStatement.setString(3, strDataRecebimentoEsperado);
			pStatement.setString(4, receita.getDescricao());
			pStatement.setInt(5, receita.getCodigoConta());
			pStatement.setString(6, receita.getTipoReceita());			
			pStatement.execute();
			
		} catch (Exception e) {
			System.out.println("Deu erro aqui!");
			e.printStackTrace();
			
		} finally {
			try {
				if(pStatement != null) 
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
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
				if(pStatement != null) 
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}			
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return receita;		
	}
	
	public ArrayList<Receita> ListarReceitas(){	
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
				if(pStatement != null) 
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}			
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return receitas;
	}	
	
	public ArrayList<Receita> buscarReceitasPorTipo(String tipoReceita){
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
				if(pStatement != null) 
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}			
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		
		return receitas;
	}

	public ArrayList<Receita> buscarReceitasPorPeriodo(String dataInicio, String dataFim){
		String sql = "SELECT * FROM RECEITA WHERE (dataRecebimento BETWEEN '"+ dataInicio +"' AND '"+ dataFim + "')" ;		
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
				if(pStatement != null) 
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}			
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		
		return receitas;
	}
	
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
				if(pStatement != null) 
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}			
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void AlterarReceita(Receita receita) {
		String sql = "UPDATE RECEITA SET valorReceita = ?, dataRecebimento = ?, "
				+ "dataRecebimentoEsperado = ?, descricao = ?, codigoConta = ?, "
				+ "tipoReceita = ? WHERE idReceita = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");  
        String strDataRecebimento = formatoData.format(receita.getDataRecebimento());
        String strDataRecebimentoEsperado = formatoData.format(receita.getDataRecebimentoEsperado());
		try {			
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setDouble(1, receita.getValorReceita());
			pStatement.setString(2, strDataRecebimento);
			pStatement.setString(3, strDataRecebimentoEsperado);
			pStatement.setString(4, receita.getDescricao());
			pStatement.setInt(5, receita.getCodigoConta());
			pStatement.setString(6, receita.getTipoReceita());
			pStatement.setInt(7, receita.getIdReceita());
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStatement != null) 
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}			
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
