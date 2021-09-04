package br.com.Gestao.de.Estoque.Form;

import java.util.Optional;

import br.com.Gestao.de.Estoque.Model.Game;
import br.com.Gestao.de.Estoque.Repository.GameRepository;

public class GameFormUpdate {

	private double Preco;

	private int quantidadeEstoque;

	public Game Update(Long id, GameRepository gameRepo) {

		Optional<Game> game = gameRepo.findById(id);
		game.get().setPreco(this.Preco);
		game.get().setQuantidadeEstoque(this.quantidadeEstoque);
		return game.get();
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
