package br.com.Gestao.de.Estoque.Service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Gestao.de.Estoque.DTO.GameDTO;
import br.com.Gestao.de.Estoque.Form.GameForm;
import br.com.Gestao.de.Estoque.Repository.GameRepository;
import br.com.Gestao.de.Estoque.Model.Game;

@Service
public class GameService {

	GameRepository repository;

	@Autowired
	public GameService(GameRepository repository) {
		
		this.repository = repository;
	
	}
	
	public ResponseEntity<GameDTO> POST(GameForm form, UriComponentsBuilder URIbuilder){
		
		Game game = form.CONVERT();
		
		repository.save(game);
		
		URI uri = URIbuilder.path("/Jogos/{id}").buildAndExpand(game.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new GameDTO(game));
		
	}
	
	public List<GameDTO> GETall(){
		
		List<Game> game = repository.findAll();
		
		List<GameDTO> gameDTO = GameDTO.CONVERT(game);
		
		return gameDTO;
		
	}
	
	public List<GameDTO> GETavaibleGAMES(){
		
		List<Game> JogosDisponiveis = repository.findByQuantidadeEstoqueGreaterThan(0);
		
		return GameDTO.CONVERT(JogosDisponiveis);
		
	}
	
}
