package wallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import wallet.model.Conta;

public class ContaDao {
		
	
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
}
