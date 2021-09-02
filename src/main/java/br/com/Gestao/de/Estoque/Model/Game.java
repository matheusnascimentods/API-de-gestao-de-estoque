package br.com.Gestao.de.Estoque.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String NomeDoJogo;
	
	private String Descricao;
	
	private double Preco;
	
	private int quantidadeEstoque;

	public Long getId() {

		return id;
	
	}

	public void setId(Long id) {
	
		this.id = id;
	
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

	public Game() {}

	public Game(String nomeDoJogo, String descricao, double preco, int quantidadeEstoque) {
		
		this.NomeDoJogo = nomeDoJogo;
		this.Descricao = descricao;
		this.Preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	
	}

}
