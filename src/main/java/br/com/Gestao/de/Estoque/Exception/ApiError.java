package br.com.Gestao.de.Estoque.Exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {

	private String msg;
	private int code;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

	public ApiError(String msg, LocalDateTime timestamp, int code) {
		
		this.msg = msg;
	    this.timestamp = timestamp;
	    this.code = code;
	
	}
	
}
