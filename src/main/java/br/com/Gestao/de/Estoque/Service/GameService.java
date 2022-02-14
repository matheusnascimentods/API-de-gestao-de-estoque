package br.com.Gestao.de.Estoque.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Gestao.de.Estoque.DTO.GameDTO;
import br.com.Gestao.de.Estoque.Form.GameForm;
import br.com.Gestao.de.Estoque.Form.GameFormUpdate;

public interface GameService {

	ResponseEntity<GameDTO> Create(GameForm form, UriComponentsBuilder URIbuilder);
	
	List<GameDTO> ReadAll();
	
	List<GameDTO> ReadAllAvaible();
	
	ResponseEntity<GameDTO> ReadById(@PathVariable Long id);
	
	ResponseEntity<GameDTO> Update(@RequestBody GameFormUpdate form, @PathVariable Long id);
	
	ResponseEntity<String> Delete(@PathVariable Long id);
	
}
