package wallet.model;

import java.util.ArrayList;

import wallet.dao.ContaDao;

public class Conta {
	
	private int idConta;
	private double saldo;
	private String tipoConta;
	private String instituicaoFinanceira;
	
	
	public Conta() {
		
	}


	public Conta(double saldo, String tipoConta, String instituicaoFinanceira) {
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.instituicaoFinanceira = instituicaoFinanceira;
	}


	public Conta(int idConta, double saldo, String tipoConta, String instituicaoFinanceira) {
		this.idConta = idConta;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.instituicaoFinanceira = instituicaoFinanceira;
	}


	public int getIdConta() {
		return idConta;
	}


	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public String getTipoConta() {
		return tipoConta;
	}


	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}


	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}


	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}
	
	public ArrayList<Conta> listarContas(){	
		return new ContaDao().ListarContas();
	}

}
