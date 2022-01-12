package wallet.model;

import java.util.ArrayList;
import java.util.Date;
import wallet.dao.ContaDao;
import wallet.dao.DespesaDao;

/**
 * 
 * Classe model que representa o objeto Despesa.
 * 
 * @author jaconunes
 *
 */

public class Despesa {

	/** Propriedade do tipo int idDespesa. */
	private int idDespesa;

	/** Propriedade do tipo double valor. */
	private double valor;

	/** Propriedade do tipo Date dataPagamento. */
	private Date dataPagamento;

	/** Propriedade do tipo Date dataPagamentoEsperado. */
	private Date dataPagamentoEsperado;

	/** Propriedade do tipo String tipoDespesa. */
	private String tipoDespesa;

	/** Propriedade do tipo int codigoConta. */
	private int codigoConta;

	/**
	 * Construtor padrão da classe Despesa.
	 */
	public Despesa() {

	}

	/**
	 * Construtor padrão recebendo todas as proriedades, exceto a propriedade do
	 * tipo int idDespesa.
	 * 
	 * @param valor
	 * @param dataPagamento
	 * @param dataPagamentoEsperado
	 * @param tipoDespesa
	 * @param codigoConta
	 */
	public Despesa(double valor, Date dataPagamento, Date dataPagamentoEsperado, String tipoDespesa, int codigoConta) {
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.dataPagamentoEsperado = dataPagamentoEsperado;
		this.tipoDespesa = tipoDespesa;
		this.codigoConta = codigoConta;
	}

	/**
	 * Construtor padrão recebendo todas as proriedades.
	 * 
	 * @param idDespesa
	 * @param valor
	 * @param dataPagamento
	 * @param dataPagamentoEsperado
	 * @param tipoDespesa
	 * @param codigoConta
	 */
	public Despesa(int idDespesa, double valor, Date dataPagamento, Date dataPagamentoEsperado, String tipoDespesa,
			int codigoConta) {
		this.idDespesa = idDespesa;
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.dataPagamentoEsperado = dataPagamentoEsperado;
		this.tipoDespesa = tipoDespesa;
		this.codigoConta = codigoConta;
	}

	/**
	 * Retorna a proriedade idDespesa.
	 * 
	 * @return idDespesa
	 */
	public int getIdDespesa() {
		return idDespesa;
	}

	/**
	 * Configura a proriedade idDespesa.
	 * 
	 * @param idDespesa
	 */
	public void setIdDespesa(int idDespesa) {
		this.idDespesa = idDespesa;
	}

	/**
	 * Retorna a proriedade valor.
	 * 
	 * @return valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * Configura a proriedade valor.
	 * 
	 * @param valor
	 */
	public void setValorDespesa(double valor) {
		this.valor = valor;
	}

	/**
	 * Retorna a proriedade dataPagamento.
	 * 
	 * @return dataPagamento
	 */
	public Date getDataPagamento() {
		return dataPagamento;
	}

	/**
	 * Configura a proriedade dataPagamento.
	 * 
	 * @param dataPagamento
	 */
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	/**
	 * Retorna a proriedade dataPagamentoEsperado.
	 * 
	 * @return dataPagamentoEsperado
	 */
	public Date getDataPagamentoEsperado() {
		return dataPagamentoEsperado;
	}

	/**
	 * Configura a proriedade dataPagamentoEsperado.
	 * 
	 * @param dataPagamentoEsperado
	 */
	public void setDataPagamentoEsperado(Date dataPagamentoEsperado) {
		this.dataPagamentoEsperado = dataPagamentoEsperado;
	}

	/**
	 * Retorna a proriedade tipoDespesa.
	 * 
	 * @return tipoDespesa
	 */
	public String getTipoDespesa() {
		return tipoDespesa;
	}

	/**
	 * Configura a proriedade tipoDespesa.
	 * 
	 * @param tipoDespesa
	 */
	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	/**
	 * Retorna a proriedade codigoConta.
	 * 
	 * @return codigoConta
	 */
	public int getCodigoConta() {
		return codigoConta;
	}

	/**
	 * Configura a proriedade codigoConta.
	 * 
	 * @param codigoConta
	 */
	public void setCodigoConta(int codigoConta) {
		this.codigoConta = codigoConta;
	}

	/**
	 * Método para salvar um objeto Despesa no banco de dados.
	 */
	public void salvar() {
		new DespesaDao().cadastrarDespesa(this);
	}

	/**
	 * Método para excluir no banco de dados um objeto Despesa.
	 * 
	 * @param idDespesa
	 */
	public void excluir(int idDespesa) {
		new DespesaDao().ExcluirDespesa(idDespesa);
	}

	/**
	 * Método para buscar no banco de dados uma lista de objetos Despesa.
	 * 
	 * @return List Despesa
	 */
	public ArrayList<Despesa> listarDespesas() {
		return new DespesaDao().ListarDespesas();
	}

	/**
	 * Método para buscar no banco de dados uma lista de objetos Despesa pelo id.
	 * 
	 * @param tipoDespesa
	 * @return List Despesa
	 */
	public ArrayList<Despesa> buscarDespesasPorTipo(String tipoDespesa) {
		return new DespesaDao().buscarDespesasPorTipo(tipoDespesa);
	}

	/**
	 * Método para buscar no banco de dados uma lista de objetos Despesa em um
	 * período de datas.
	 * 
	 * @param dataInicio
	 * @param dataFim
	 * @return List Despesa
	 */
	public ArrayList<Despesa> buscarDespesasPorPeriodo(String dataInicio, String dataFim) {
		return new DespesaDao().buscarDespesasPorPeriodo(dataInicio, dataFim);
	}

	/**
	 * Método para buscar no banco de dados um objeto Despesa pelo id.
	 * 
	 * @param idDespesa
	 * @return Despesa
	 */
	public Despesa buscarDespesaPorId(int idDespesa) {
		return new DespesaDao().BuscarDespesaPorId(idDespesa);
	}

	/**
	 * Método para buscar no banco de dados um objeto Conta pelo id e retornar o
	 * nome da Instituição.
	 * 
	 * @param codigoConta
	 * @return Nome Instituição
	 */
	public String buscarContaPorCodigo(int codigoConta) {
		Conta conta = new Conta().buscarContaPorId(codigoConta);
		return conta.getInstituicaoFinanceira();
	}

	/**
	 * Método para debitar saldo de uma Conta buscada no banco de dados pelo id.
	 * Retorna positivo ou negativo
	 * 
	 * @param codConta
	 * @param valor
	 * @return retorno
	 */
	public Boolean debitarSaldoConta(int codConta, double valor) {
		Boolean retorno = null;
		Conta conta = new Conta().buscarContaPorId(codConta);
		if (conta.getSaldo() > valor) {
			double novoSaldoConta = conta.getSaldo() - valor;
			conta.setSaldo(novoSaldoConta);
			new ContaDao().AlterarConta(conta);
			retorno = true;
		} else {
			retorno = false;
		}

		return retorno;

	}
}
