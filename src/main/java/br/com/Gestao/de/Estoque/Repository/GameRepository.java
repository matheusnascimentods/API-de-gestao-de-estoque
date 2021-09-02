package br.com.Gestao.de.Estoque.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Gestao.de.Estoque.Model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

	List<Game> findByQuantidadeEstoqueGreaterThan(Integer quantidade);
	
}
