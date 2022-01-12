package wallet.model;

import java.util.ArrayList;

import wallet.dao.ContaDao;

/**
 * Classe model que representa o objeto Conta.
 * 
 * @author jaconunes
 *
 */

public class Conta {

	/** Propriedade do tipo int idConta. */
	private int idConta;

	/** Propriedade do tipo double saldo. */
	private double saldo;

	/** Propriedade do tipo String tipoConta. */
	private String tipoConta;

	/** Propriedade do tipo String instituicaoFinanceira. */
	private String instituicaoFinanceira;

	/**
	 * Construtor padrão da classe Conta.
	 */
	public Conta() {

	}

	/**
	 * Construtor padrão da classe recebendo todas as propriedades, exceto o
	 * idConta.
	 * 
	 * @param saldo
	 * @param tipoConta
	 * @param instituicaoFinanceira
	 */
	public Conta(double saldo, String tipoConta, String instituicaoFinanceira) {
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	/**
	 * Construtor padrão da classe recebendo todas as propriedades.
	 * 
	 * @param idConta
	 * @param saldo
	 * @param tipoConta
	 * @param instituicaoFinanceira
	 */
	public Conta(int idConta, double saldo, String tipoConta, String instituicaoFinanceira) {
		this.idConta = idConta;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	/**
	 * Retorna a propriedade idConta.
	 * 
	 * @return idConta
	 */
	public int getIdConta() {
		return idConta;
	}

	/**
	 * Configura a propriedade idConta
	 * 
	 * @param idConta
	 */
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	/**
	 * Retorna a propriedade saldo.
	 * 
	 * @return saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Configura a propriedade saldo.
	 * 
	 * @param saldo
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * Retorna a propriedade tipoConta.
	 * 
	 * @return tipoConta
	 */
	public String getTipoConta() {
		return tipoConta;
	}

	/**
	 * Configura a propriedade tipoConta.
	 * 
	 * @param tipoConta
	 */
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	/**
	 * Retorna a propriedade instituicaoFinanceira.
	 * 
	 * @return instituicaoFinanceira
	 */
	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}

	/**
	 * Configura a propriedade instituicaoFinanceira.
	 * 
	 * @param instituicaoFinanceira
	 */
	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	/**
	 * Método para consultar no banco de dados e retornar uma lista de objetos
	 * Conta.
	 * 
	 * @return List conta
	 */
	public ArrayList<Conta> listarContas() {
		return new ContaDao().ListarContas();
	}

	/**
	 * Método para salvar um objeto Conta no banco de dados.
	 */
	public void salvar() {
		new ContaDao().cadastrarConta(this);
	}

	/**
	 * Método para excluir um objeto Conta no banco de dados pelo id. Retorna
	 * mensagem.
	 * 
	 * @param idConta
	 * @return mensagem
	 */
	public String excluir(int idConta) {
		String mensagem = new ContaDao().ExcluirConta(idConta);

		return mensagem;
	}

	/**
	 * Método para buscar e retornar um objeto Conta no banco de dados.
	 * 
	 * @param idConta
	 * @return Conta
	 */
	public Conta buscarContaPorId(int idConta) {
		return new ContaDao().BuscarContaPorId(idConta);
	}

	/**
	 * Método para transferir saldo entre dois objetos Conta.
	 * 
	 * @param idIdContaAtual
	 * @param idIdContaDestino
	 * @param saldoATransferir
	 */
	public void transferirSaldo(int idIdContaAtual, int idIdContaDestino, double saldoATransferir) {
		Conta contaAtual = new ContaDao().BuscarContaPorId(idIdContaAtual);
		Conta contaDestino = new ContaDao().BuscarContaPorId(idIdContaDestino);

		contaAtual.setSaldo(contaAtual.getSaldo() - saldoATransferir);
		contaDestino.setSaldo(contaDestino.getSaldo() + saldoATransferir);

		new ContaDao().AlterarConta(contaAtual);
		new ContaDao().AlterarConta(contaDestino);

	}
}
