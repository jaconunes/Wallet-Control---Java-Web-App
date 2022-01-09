package wallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import wallet.model.Conta;

public class ContaDao {
		
	public void cadastrarConta(Conta conta) {
		
		String sql = "INSERT INTO CONTA VALUES (null,?,?,?)";
		PreparedStatement pStatement = null;
		Connection conn = null;			
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setDouble(1, conta.getSaldo());
			pStatement.setString(2, conta.getTipoConta());
			pStatement.setString(3, conta.getInstituicaoFinanceira());		
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
	
	public ArrayList<Conta> ListarContas(){	

		String sql = "SELECT * FROM CONTA";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Conta conta = null;
		ArrayList<Conta> contas = null;
		try {			
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();			
			if (rs != null) {
				contas = new ArrayList<Conta>();
				while (rs.next()) {
					conta = new Conta();
					conta.setIdConta(rs.getInt("idConta"));
					conta.setSaldo(rs.getDouble("saldo"));
					conta.setTipoConta(rs.getString("tipoConta"));
					conta.setInstituicaoFinanceira(rs.getString("instituicaoFinanceira"));
					contas.add(conta);					
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
		return contas;
	}	
	
	
	public Conta BuscarContaPorId(int id) {
		String sql = "SELECT * FROM CONTA WHERE idConta = ?";
		ResultSet rs = null;
		PreparedStatement pStatement = null;
		Connection conn = null;
		Conta conta = null;
		try {			
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			if (rs != null && rs.next()) {
				conta = new Conta();
				conta.setIdConta(rs.getInt("idConta"));
				conta.setSaldo(rs.getDouble("saldo"));
				conta.setTipoConta(rs.getString("tipoConta"));
				conta.setInstituicaoFinanceira(rs.getString("instituicaoFinanceira"));
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
		
		return conta;		
	}
	
	
	public void AlterarConta(Conta conta) {
		String sql = "UPDATE CONTA SET saldo = ?, tipoConta = ?, "
				+ "instituicaoFinanceira = ? WHERE idConta = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		try {			
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setDouble(1, conta.getSaldo());
			pStatement.setString(2, conta.getTipoConta());
			pStatement.setString(3, conta.getInstituicaoFinanceira());
			pStatement.setInt(4, conta.getIdConta());
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
	
	
	public void ExcluirConta(int idConta) {
		String sql = "DELETE FROM CONTA WHERE idConta = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		try {			
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, idConta);
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
