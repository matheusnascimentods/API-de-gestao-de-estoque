package br.com.Gestao.de.Estoque.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Gestao.de.Estoque.DTO.GameDTO;
import br.com.Gestao.de.Estoque.Form.GameForm;
import br.com.Gestao.de.Estoque.Form.GameFormUpdate;
import br.com.Gestao.de.Estoque.Repository.GameRepository;
import br.com.Gestao.de.Estoque.Model.Game;

@Service
public class GameService {

	GameRepository repository;

	@Autowired
	public GameService(GameRepository repository) {
		
		this.repository = repository;
	
	}
	
	public ResponseEntity<GameDTO> Post(GameForm form, UriComponentsBuilder URIbuilder){
		
		Game game = form.CONVERT();
		
		repository.save(game);
		
		URI uri = URIbuilder.path("/Jogos/{id}").buildAndExpand(game.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new GameDTO(game));
		
	}
	
	public List<GameDTO> GetAll(){
		
		List<Game> game = repository.findAll();
		
		List<GameDTO> gameDTO = GameDTO.CONVERT(game);
		
		return gameDTO;
		
	}
	
	public List<GameDTO> GetAvaibleGames(){
		
		List<Game> JogosDisponiveis = repository.findByQuantidadeEstoqueGreaterThan(0);
		
		return GameDTO.CONVERT(JogosDisponiveis);
		
	}

	public ResponseEntity<GameDTO> GetByID(@PathVariable Long id){
		
		Optional<Game> jogoBuscado = repository.findById(id);
		
		if (jogoBuscado.get().getQuantidadeEstoque() > 0){
			
			return ResponseEntity.ok().body(new GameDTO(jogoBuscado.get()));
			
		}else {
			
			return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(new GameDTO(jogoBuscado.get()));
	
		}
		
	}

	public ResponseEntity<GameDTO> Update(@RequestBody GameFormUpdate form, @PathVariable Long id){
		
		Game game = form.Update(id, repository);
		
		return ResponseEntity.ok().body(new GameDTO(game));
		
	}

	public ResponseEntity<String> Delete(@PathVariable Long id){
		
		repository.deleteById(id);
		
		return ResponseEntity.ok().body("Exclusao concluida com exito");
		
	}
	
}
