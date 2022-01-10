package wallet.model;

import java.util.ArrayList;
import java.util.Date;

import wallet.dao.ContaDao;
import wallet.dao.DespesaDao;

public class Despesa {
	
	private int idDespesa;
	private double valor;
	private Date dataPagamento;
	private Date dataPagamentoEsperado;
	private String tipoDespesa;
	private int codigoConta;
	
	
	public Despesa() {
		
	}


	public Despesa(double valor, Date dataPagamento, Date dataPagamentoEsperado, String tipoDespesa,
			int codigoConta) {
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.dataPagamentoEsperado = dataPagamentoEsperado;
		this.tipoDespesa = tipoDespesa;
		this.codigoConta = codigoConta;
	}


	public Despesa(int idDespesa, double valor, Date dataPagamento, Date dataPagamentoEsperado,
			String tipoDespesa, int codigoConta) {
		this.idDespesa = idDespesa;
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.dataPagamentoEsperado = dataPagamentoEsperado;
		this.tipoDespesa = tipoDespesa;
		this.codigoConta = codigoConta;
	}


	public int getIdDespesa() {
		return idDespesa;
	}


	public void setIdDespesa(int idDespesa) {
		this.idDespesa = idDespesa;
	}


	public double getValor() {
		return valor;
	}


	public void setValorDespesa(double valor) {
		this.valor = valor;
	}


	public Date getDataPagamento() {
		return dataPagamento;
	}


	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}


	public Date getDataPagamentoEsperado() {
		return dataPagamentoEsperado;
	}


	public void setDataPagamentoEsperado(Date dataPagamentoEsperado) {
		this.dataPagamentoEsperado = dataPagamentoEsperado;
	}


	public String getTipoDespesa() {
		return tipoDespesa;
	}


	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}


	public int getCodigoConta() {
		return codigoConta;
	}


	public void setCodigoConta(int codigoConta) {
		this.codigoConta = codigoConta;
	}
	
	public void salvar() {
		new DespesaDao().cadastrarDespesa(this);
	}
	
	public void excluir(int idDespesa) {
		new DespesaDao().ExcluirDespesa(idDespesa);
	}
	
	public ArrayList<Despesa> listarDespesas(){	
		return new DespesaDao().ListarDespesas();
	}
	
	public ArrayList<Despesa> buscarDespesasPorTipo(String tipoDespesa){
		return new DespesaDao().buscarDespesasPorTipo(tipoDespesa);
	}
	
	public ArrayList<Despesa> buscarDespesasPorPeriodo(String dataInicio, String dataFim){
		return new DespesaDao().buscarDespesasPorPeriodo(dataInicio, dataFim);
	}
	
	public Despesa buscarDespesaPorId(int idDespesa) {
		return new DespesaDao().BuscarDespesaPorId(idDespesa);
	}
	
	public String buscarContaPorCodigo(int codigoConta) {
		Conta conta = new Conta().buscarContaPorId(codigoConta);		
		return conta.getInstituicaoFinanceira();
	}
	
	public void debitarSaldoConta(int codConta, double valor) {
		Conta conta = new Conta().buscarContaPorId(codConta);
		double novoSaldoConta = conta.getSaldo() - valor;
		conta.setSaldo(novoSaldoConta);
		new ContaDao().AlterarConta(conta);		
	}
}
