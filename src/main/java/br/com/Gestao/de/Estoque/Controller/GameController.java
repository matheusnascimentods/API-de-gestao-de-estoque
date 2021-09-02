package br.com.Gestao.de.Estoque.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Gestao.de.Estoque.DTO.GameDTO;
import br.com.Gestao.de.Estoque.Form.GameForm;
import br.com.Gestao.de.Estoque.Repository.GameRepository;
import br.com.Gestao.de.Estoque.Service.GameService;

@RestController
@RequestMapping("Jogos")
public class GameController {
	
	@Autowired
	GameRepository repository;
	
	@Autowired
	GameService gameService = new GameService(repository);
	
	@GetMapping("/ViewAllGames")
	public List<GameDTO> GetAll(){
		
		return gameService.GETall();
		
	}
	
	@GetMapping("/ViewAvailableGames")
	public List<GameDTO> GetAvaible(){
		
		return gameService.GETavaibleGAMES();
		
	}
	
	@GetMapping("/FindById/{id}")
	public ResponseEntity<GameDTO> GetByID(@PathVariable Long id){
		
		return gameService.GETbyID(id);
		
	}
	
	
	@PostMapping("/AddGame")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<GameDTO> Post(@RequestBody GameForm gameForm, UriComponentsBuilder uriBuilder) {
		
		return gameService.POST(gameForm, uriBuilder);
		
	}

}
