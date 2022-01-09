package wallet.model;

import java.util.ArrayList;
import java.util.Date;

import wallet.dao.ReceitaDao;

public class Receita {
	
	private int idReceita;
	private double valorReceita;
	private Date dataRecebimento;
	private Date dataRecebimentoEsperado;
	private String descricao;
	private String conta;
	private String tipoReceita;
	
	public Receita() {
		
	}	
	
	
	public Receita(double valorReceita, Date dataRecebimento, 
			Date dataRecebimentoEsperado, String descricao,
			String conta, String tipoReceita) {
		this.valorReceita = valorReceita;
		this.dataRecebimento = dataRecebimento;
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
		this.descricao = descricao;
		this.conta = conta;
		this.tipoReceita = tipoReceita;
	}


	public Receita(int idReceita, double valorReceita, Date dataRecebimento, 
			Date dataRecebimentoEsperado, String descricao, String conta, 
			String tipoReceita) {
		this.idReceita = idReceita;
		this.valorReceita = valorReceita;
		this.dataRecebimento = dataRecebimento;
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
		this.descricao = descricao;
		this.conta = conta;
		this.tipoReceita = tipoReceita;
		
	}


	public int getIdReceita() {
		return idReceita;
	}


	public void setIdReceita(int idReceita) {
		this.idReceita = idReceita;
	}


	public double getValorReceita() {
		return valorReceita;
	}


	public void setValorReceita(double valorReceita) {
		this.valorReceita = valorReceita;
	}


	public Date getDataRecebimento() {
		return dataRecebimento;
	}


	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}


	public Date getDataRecebimentoEsperado() {
		return dataRecebimentoEsperado;
	}


	public void setDataRecebimentoEsperado(Date dataRecebimentoEsperado) {
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getConta() {
		return conta;
	}


	public void setConta(String conta) {
		this.conta = conta;
	}


	public String getTipoReceita() {
		return tipoReceita;
	}


	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}
	
	public void salvar() {
		new ReceitaDao().cadastrarReceita(this);
	}
	
	public void excluir(int idReceita) {
		new ReceitaDao().ExcluirReceita(idReceita);
	}
	
	public Receita buscarReceitaPorId(int idReceita) {
		return new ReceitaDao().BuscarReceitaPorId(idReceita);
	}
	
	public ArrayList<Receita> buscarReceitaPorTipo(String tipoReceita){
		return new ReceitaDao().buscarReceitasPorTipo(tipoReceita);
	}
	
	public ArrayList<Receita> buscarReceitaPorPeriodo(String dataInicio, String dataFim){
		return new ReceitaDao().buscarReceitasPorPeriodo(dataInicio, dataFim);
	}
	
	public ArrayList<Receita> listarReceitas(){	
		return new ReceitaDao().ListarReceitas();
	}
	
}
