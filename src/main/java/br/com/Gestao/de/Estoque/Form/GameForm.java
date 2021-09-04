package br.com.Gestao.de.Estoque.Form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.Gestao.de.Estoque.Model.Game;

public class GameForm {
	
	@NotEmpty @NotNull
	private String NomeDoJogo;
	
	@NotEmpty @NotNull
	private String Descricao;

	private double Preco;

	private int quantidadeEstoque;

	public Game CONVERT() {
		
		return new Game(NomeDoJogo, Descricao, Preco, quantidadeEstoque);
	
	}

	public String getNomeDoJogo() {
	
		return NomeDoJogo;
	
	}

	public void setNomeDoJogo(String nomeDoJogo) {
	
		NomeDoJogo = nomeDoJogo;
	
	}

	public String getDescricao() {
	
		return Descricao;

	}

	public void setDescricao(String descricao) {
	
		Descricao = descricao;
	
	}

	public double getPreco() {
	
		return Preco;
	
	}

	public void setPreco(double preco) {
	
		Preco = preco;
	
	}

	public int getQuantidadeEstoque() {
	
		return quantidadeEstoque;
	
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
	
		this.quantidadeEstoque = quantidadeEstoque;
	
	}
	
}
