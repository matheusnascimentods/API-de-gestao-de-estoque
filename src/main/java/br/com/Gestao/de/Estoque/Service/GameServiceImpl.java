package br.com.Gestao.de.Estoque.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Gestao.de.Estoque.DTO.GameDTO;
import br.com.Gestao.de.Estoque.Form.GameForm;
import br.com.Gestao.de.Estoque.Form.GameFormUpdate;
import br.com.Gestao.de.Estoque.Model.Game;
import br.com.Gestao.de.Estoque.Repository.GameRepository;

@Service
public class GameServiceImpl implements GameService{

	GameRepository repository;

	@Autowired
	public GameServiceImpl(GameRepository repository) {
		
		this.repository = repository;
	
	}
	
	@Override
	public ResponseEntity<GameDTO> Create(GameForm form, UriComponentsBuilder URIbuilder) {
		
		Game game = form.CONVERT();
		repository.save(game);
		
		URI uri = URIbuilder.path("/Jogos/{id}")
				.buildAndExpand(game.getId()).toUri();
		
	
		return ResponseEntity.created(uri).body(new GameDTO(game));
	}

	@Override
	public List<GameDTO> ReadAll() {
		
		List<GameDTO> AllGames = GameDTO.CONVERT(repository.findAll());	
		
		return AllGames;
	
	}
	
	@Override
	public List<GameDTO> ReadAllAvaible() {
		
		return GameDTO.CONVERT(repository.findByQuantidadeEstoqueGreaterThan(0));
	
	}
	
	@Override
	public ResponseEntity<GameDTO> ReadById(Long id) {
		
		Optional<Game> SearchedGame = repository.findById(id);
		
		if (SearchedGame.get().getQuantidadeEstoque() > 0){
			
			return ResponseEntity.ok().body(new GameDTO(SearchedGame.get()));
			
		}else {
			
			return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(new GameDTO(SearchedGame.get()));
		
		}

	}

	@Override
	public ResponseEntity<GameDTO> Update(GameFormUpdate form, Long id) {
	
		Game game = form.Update(id, repository);
		return ResponseEntity.ok().body(new GameDTO(game));
	
	}

	@Override
	public ResponseEntity<String> Delete(Long id) {
	
		repository.deleteById(id);
		return ResponseEntity.ok().body("Exclusão concluída com exito");
	
	}
	
}