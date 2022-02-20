package br.com.Gestao.de.Estoque.Controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Gestao.de.Estoque.DTO.GameDTO;
import br.com.Gestao.de.Estoque.Form.GameForm;
import br.com.Gestao.de.Estoque.Form.GameFormUpdate;
import br.com.Gestao.de.Estoque.Repository.GameRepository;
import br.com.Gestao.de.Estoque.Service.GameServiceImpl;

@RestController
@RequestMapping("Jogos")
public class GameController {
	
	@Autowired
	GameRepository repository;
	
	@Autowired
	GameServiceImpl gameService = new GameServiceImpl(repository);
	
	@PostMapping("/AddGame")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<GameDTO> Create(@RequestBody @Valid GameForm gameForm, UriComponentsBuilder uriBuilder) {
		
		return gameService.Create(gameForm, uriBuilder);
		
	}
	
	@GetMapping("/ViewAllGames")
	public List<GameDTO> ReadAll(){
		
		return gameService.ReadAll();
		
	}
	
	@GetMapping("/ViewAvailableGames")
	public List<GameDTO> ReadAllAvaible(){
		
		return gameService.ReadAllAvaible();
		
	}
	
	@GetMapping("/FindById/{id}")
	public ResponseEntity<GameDTO> ReadById(@PathVariable Long id){
		
		return gameService.ReadById(id);
		
	}

	@PatchMapping("/UpdateById/{id}") @Transactional
	public ResponseEntity<GameDTO> Update(@RequestBody GameFormUpdate form, @PathVariable Long id){
		
		return gameService.Update(form, id);
		
	}

	@DeleteMapping("/DeleteById/{id}") @Transactional
	public ResponseEntity<String> Delete(@PathVariable Long id){
		
		return gameService.Delete(id);
		
	}
	
}
