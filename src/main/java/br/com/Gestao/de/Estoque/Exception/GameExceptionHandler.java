package br.com.Gestao.de.Estoque.Exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GameExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	private List<ApiError> handle(MethodArgumentNotValidException ex) {

		List<ApiError> erro = new ArrayList<>();
		
		ApiError error = new ApiError("Os campos 'NomeDoJogo' e 'Descricao nao podem ser nulos'",
		LocalDateTime.now(), 
		HttpStatus.BAD_REQUEST.value());
		
		erro.add(error);
		
		return erro;
		
	}	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmptyResultDataAccessException.class)
	private List<ApiError> NotFoud(EmptyResultDataAccessException ex){
		
		List<ApiError> DetalhesDoErro = new ArrayList<>();
		
		ApiError notFoudError = new ApiError("Jogo não encontrado",
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value());
		
		DetalhesDoErro.add(notFoudError);
		
		return DetalhesDoErro;
		
	}	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	private List<ApiError> NotFoud(NoSuchElementException ex){
		
		List<ApiError> DetalhesDoErro = new ArrayList<>();
		
		ApiError notFoudError = new ApiError("Jogo não encontrado",
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value());
		
		DetalhesDoErro.add(notFoudError);
		
		return DetalhesDoErro;
		
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	private List<ApiError> NotFoud(EntityNotFoundException ex){
		
		List<ApiError> DetalhesDoErro = new ArrayList<>();
		
		ApiError notFoudError = new ApiError("Jogo não encontrado",
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value());
		
		DetalhesDoErro.add(notFoudError);
		
		return DetalhesDoErro;
		
	}
	
}
