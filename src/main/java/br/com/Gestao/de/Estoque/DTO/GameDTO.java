package br.com.Gestao.de.Estoque.DTO;

import java.util.List;
import java.util.stream.Collectors;

import br.com.Gestao.de.Estoque.Model.Game;

public class GameDTO {

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
	
	public GameDTO(Game game) {

		this.id = game.getId();
		this.NomeDoJogo = game.getNomeDoJogo();
		this.Descricao = game.getDescricao();
		this.Preco = game.getPreco();
		this.quantidadeEstoque = game.getQuantidadeEstoque();
	}

	public static List<GameDTO> CONVERT(List<Game> jogos) {
		
		return jogos.stream().map(GameDTO::new).collect(Collectors.toList());
	}

}
