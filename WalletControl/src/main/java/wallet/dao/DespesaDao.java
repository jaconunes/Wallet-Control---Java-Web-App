package wallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import wallet.model.Despesa;

public class DespesaDao {
	
		public void cadastrarDespesa(Despesa despesa) {
			
			String sql = "INSERT INTO DESPESA VALUES (null,?,?,?,?,?)";
			PreparedStatement pStatement = null;
			Connection conn = null;		
			SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");  
	        String strDataPagamento = formatoData.format(despesa.getDataPagamento());
	        String strDataPagamentoEsperado = formatoData.format(despesa.getDataPagamentoEsperado());
			
			try {
				conn = new MySqlConnection().getConnection();
				pStatement = conn.prepareStatement(sql);
				pStatement.setDouble(1, despesa.getValor());
				pStatement.setString(2, strDataPagamento);
				pStatement.setString(3, strDataPagamentoEsperado);
				pStatement.setString(4, despesa.getTipoDespesa());
				pStatement.setInt(5, despesa.getCodigoConta());						
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
	
		public ArrayList<Despesa> ListarDespesas(){	
			String sql = "SELECT * FROM DESPESA";
			ResultSet rs = null;
			Connection conn = null;
			PreparedStatement pStatement = null;
			Despesa despesa = null;
			ArrayList<Despesa> despesas = null;
			try {			
				conn = new MySqlConnection().getConnection();
				pStatement = conn.prepareStatement(sql);
				rs = pStatement.executeQuery();			
				if (rs != null) {
					despesas = new ArrayList<Despesa>();
					while (rs.next()) {
						despesa = new Despesa();
						despesa.setIdDespesa(rs.getInt("idDespesa"));
						despesa.setValorDespesa(rs.getDouble("valor"));
						despesa.setDataPagamento(rs.getDate("dataPagamento"));
						despesa.setDataPagamentoEsperado(rs.getDate("dataPagamentoEsperado"));
						despesa.setTipoDespesa(rs.getString("tipoDespesa"));
						despesa.setCodigoConta(rs.getInt("codigoConta"));
						
						despesas.add(despesa);					
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
			return despesas;
		}
		
		public ArrayList<Despesa> buscarDespesasPorTipo(String tipoDespesa){
			String sql = "SELECT * FROM DESPESA WHERE tipoDespesa = ?";
			ResultSet rs = null;
			PreparedStatement pStatement = null;
			Connection conn = null;
			Despesa despesa = null;
			ArrayList<Despesa> despesas = null;
			
			try {			
				conn = new MySqlConnection().getConnection();
				pStatement = conn.prepareStatement(sql);
				pStatement.setString(1, tipoDespesa);
				rs = pStatement.executeQuery();		
				if (rs != null) {
					despesas = new ArrayList<Despesa>();
					while (rs.next()) {
						despesa = new Despesa();
						despesa.setIdDespesa(rs.getInt("idDespesa"));
						despesa.setValorDespesa(rs.getDouble("valor"));
						despesa.setDataPagamento(rs.getDate("dataPagamento"));
						despesa.setDataPagamentoEsperado(rs.getDate("dataPagamentoEsperado"));
						despesa.setTipoDespesa(rs.getString("tipoDespesa"));
						despesa.setCodigoConta(rs.getInt("codigoConta"));
						
						despesas.add(despesa);					
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
			
			return despesas;
		}
		
		public ArrayList<Despesa> buscarDespesasPorPeriodo(String dataInicio, String dataFim){
			String sql = "SELECT * FROM DESPESA WHERE (dataPagamento BETWEEN '"+ dataInicio +"' AND '"+ dataFim + "')" ;		
			ResultSet rs = null;
			PreparedStatement pStatement = null;
			Connection conn = null;
			Despesa despesa = null;
			ArrayList<Despesa> despesas = null;
			
			try {			
				conn = new MySqlConnection().getConnection();
				pStatement = conn.prepareStatement(sql);
				rs = pStatement.executeQuery();		
				if (rs != null) {
					despesas = new ArrayList<Despesa>();
					while (rs.next()) {
						despesa = new Despesa();
						despesa.setIdDespesa(rs.getInt("idDespesa"));
						despesa.setValorDespesa(rs.getDouble("valor"));
						despesa.setDataPagamento(rs.getDate("dataPagamento"));
						despesa.setDataPagamentoEsperado(rs.getDate("dataPagamentoEsperado"));
						despesa.setTipoDespesa(rs.getString("tipoDespesa"));
						despesa.setCodigoConta(rs.getInt("codigoConta"));
						
						despesas.add(despesa);				
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
			
			return despesas;
		}
		
		public Despesa BuscarDespesaPorId(int id) {
			String sql = "SELECT * FROM DESPESA WHERE idDespesa = ?";
			ResultSet rs = null;
			PreparedStatement pStatement = null;
			Connection conn = null;
			Despesa despesa = null;
			try {			
				conn = new MySqlConnection().getConnection();
				pStatement = conn.prepareStatement(sql);
				pStatement.setInt(1, id);
				rs = pStatement.executeQuery();
				if (rs != null && rs.next()) {
					despesa = new Despesa();
					despesa.setIdDespesa(rs.getInt("idDespesa"));
					despesa.setValorDespesa(rs.getDouble("valor"));
					despesa.setDataPagamento(rs.getDate("dataPagamento"));
					despesa.setDataPagamentoEsperado(rs.getDate("dataPagamentoEsperado"));
					despesa.setTipoDespesa(rs.getString("tipoDespesa"));
					despesa.setCodigoConta(rs.getInt("codigoConta"));
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
			
			return despesa;		
		}
		
		public void AlterarDespesa(Despesa despesa) {
			SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
			String sql = "UPDATE DESPESA SET valor = '" + despesa.getValor()
					+ "', dataPagamento = '" + formatoData.format(despesa.getDataPagamento())
					+ "', dataPagamentoEsperado = '" + formatoData.format(despesa.getDataPagamentoEsperado())
					+ "', tipoDespesa = '" + despesa.getTipoDespesa()
					+ "',  codigoConta = '" + despesa.getCodigoConta()
					+ "'  WHERE idDespesa = '" + despesa.getIdDespesa()
					+ "';";
			PreparedStatement pStatement = null;
			Connection conn = null;
			try {			
				conn = new MySqlConnection().getConnection();
				pStatement = conn.prepareStatement(sql);
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
		
		public void ExcluirDespesa(int idDespesa) {
		String sql = "DELETE FROM DESPESA WHERE idDespesa = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		try {			
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, idDespesa);
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
