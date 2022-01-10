package wallet.model;

import java.util.ArrayList;
import java.util.Date;
import wallet.dao.ContaDao;
import wallet.dao.ReceitaDao;

/**
 * 
 * Classe model que representa o objeto Receita.
 * 
 * @author jaconunes
 *
 */

public class Receita {

	/** Propriedade do tipo int idReceita. */
	private int idReceita;

	/** Propriedade do tipo double valorReceita. */
	private double valorReceita;

	/** Propriedade do tipo Date dataRecebimento. */
	private Date dataRecebimento;

	/** Propriedade do tipo Date dataRecebimentoEsperado. */
	private Date dataRecebimentoEsperado;

	/** Propriedade do tipo String descricao. */
	private String descricao;

	/** Propriedade do tipo int codigoConta. */
	private int codigoConta;

	/** Propriedade do tipo String tipoReceita. */
	private String tipoReceita;

	/**
	 * Construtor padrão da classe Receita.
	 */
	public Receita() {

	}

	/**
	 * Construtor padrão recebendo todas as proriedades, exceto a propriedade do
	 * tipo int idReceita.
	 * 
	 * @param valorReceita
	 * @param dataRecebimento
	 * @param dataRecebimentoEsperado
	 * @param descricao
	 * @param codigoConta
	 * @param tipoReceita
	 */
	public Receita(double valorReceita, Date dataRecebimento, Date dataRecebimentoEsperado, String descricao,
			int codigoConta, String tipoReceita) {
		this.valorReceita = valorReceita;
		this.dataRecebimento = dataRecebimento;
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
		this.descricao = descricao;
		this.codigoConta = codigoConta;
		this.tipoReceita = tipoReceita;
	}

	/**
	 * Construtor padrão recebendo todas as proriedades.
	 * 
	 * @param idReceita
	 * @param valorReceita
	 * @param dataRecebimento
	 * @param dataRecebimentoEsperado
	 * @param descricao
	 * @param codigoConta
	 * @param tipoReceita
	 */
	public Receita(int idReceita, double valorReceita, Date dataRecebimento, Date dataRecebimentoEsperado,
			String descricao, int codigoConta, String tipoReceita) {
		this.idReceita = idReceita;
		this.valorReceita = valorReceita;
		this.dataRecebimento = dataRecebimento;
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
		this.descricao = descricao;
		this.codigoConta = codigoConta;
		this.tipoReceita = tipoReceita;

	}

	/**
	 * Retorna a proriedade idReceita.
	 * 
	 * @return idReceita
	 */
	public int getIdReceita() {
		return idReceita;
	}

	/**
	 * Configura a proriedade idReceita.
	 * 
	 * @param idReceita
	 */
	public void setIdReceita(int idReceita) {
		this.idReceita = idReceita;
	}

	/**
	 * Retorna a proriedade valorReceita.
	 * 
	 * @return valorReceita
	 */
	public double getValorReceita() {
		return valorReceita;
	}

	/**
	 * Configura a proriedade valorReceita.
	 * 
	 * @param valorReceita
	 */
	public void setValorReceita(double valorReceita) {
		this.valorReceita = valorReceita;
	}

	/**
	 * Retorna a proriedade dataRecebimento.
	 * 
	 * @return dataRecebimento
	 */
	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	/**
	 * Configura a proriedade dataRecebimento.
	 * 
	 * @param dataRecebimento
	 */
	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	/**
	 * Retorna a proriedade dataRecebimentoEsperado.
	 * 
	 * @return dataRecebimentoEsperado
	 */
	public Date getDataRecebimentoEsperado() {
		return dataRecebimentoEsperado;
	}

	/**
	 * Configura a proriedade dataRecebimentoEsperado.
	 * 
	 * @param dataRecebimentoEsperado
	 */
	public void setDataRecebimentoEsperado(Date dataRecebimentoEsperado) {
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
	}

	/**
	 * Retorna a proriedade descricao.
	 * 
	 * @return descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Configura a proriedade descricao.
	 * 
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	 * Retorna a proriedade tipoReceita.
	 * 
	 * @return tipoReceita
	 */
	public String getTipoReceita() {
		return tipoReceita;
	}

	/**
	 * Configura a proriedade tipoReceita.
	 * 
	 * @param tipoReceita
	 */
	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	/**
	 * Método para salvar o objeto Receita no banco de dados.
	 */
	public void salvar() {
		new ReceitaDao().cadastrarReceita(this);
	}

	/**
	 * Método para excluir o objeto Receita do banco de dados.
	 * 
	 * @param idReceita
	 */
	public void excluir(int idReceita) {
		new ReceitaDao().ExcluirReceita(idReceita);
	}

	/**
	 * Método para buscar no banco de dados um objeto Receita pelo id.
	 * 
	 * @param idReceita
	 * @return Objeto Receita
	 */
	public Receita buscarReceitaPorId(int idReceita) {
		return new ReceitaDao().BuscarReceitaPorId(idReceita);
	}

	/**
	 * Método para buscar no banco de dados uma lista de objetos Receita pelo tipo.
	 * 
	 * @param tipoReceita
	 * @return List Receita
	 */
	public ArrayList<Receita> buscarReceitaPorTipo(String tipoReceita) {
		return new ReceitaDao().buscarReceitasPorTipo(tipoReceita);
	}

	/**
	 * Método para buscar no banco de dados uma lista de objetos Receita por período
	 * entre datas.
	 * 
	 * @param dataInicio
	 * @param dataFim
	 * @return List Receita
	 */
	public ArrayList<Receita> buscarReceitaPorPeriodo(String dataInicio, String dataFim) {
		return new ReceitaDao().buscarReceitasPorPeriodo(dataInicio, dataFim);
	}

	/**
	 * Método para buscar no banco de dados uma lista de objetos Receita.
	 * 
	 * @return List Receita
	 */
	public ArrayList<Receita> listarReceitas() {
		return new ReceitaDao().ListarReceitas();
	}

	/**
	 * Método para buscar Conta no banco de dados pelo id e retornar o nome da
	 * Instituição.
	 * 
	 * @param codigoConta
	 * @return Nome Instituição Financeira
	 */
	public String buscarContaPorCodigo(int codigoConta) {
		Conta conta = new Conta().buscarContaPorId(codigoConta);
		return conta.getInstituicaoFinanceira();
	}

	/**
	 * Método para adicionar saldo em conta vinculada a Receita.
	 * 
	 * @param codConta
	 * @param valor
	 */
	public void adicionaSaldoConta(int codConta, double valor) {
		Conta conta = new Conta().buscarContaPorId(codConta);
		double novoSaldoConta = conta.getSaldo() + valor;
		conta.setSaldo(novoSaldoConta);
		new ContaDao().AlterarConta(conta);
	}
}
