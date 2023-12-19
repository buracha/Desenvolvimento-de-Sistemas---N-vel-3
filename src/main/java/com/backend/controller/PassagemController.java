package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.backend.models.Passagem;
import com.backend.repositories.PassagemRepository;

@RestController
public class PassagemController {

	@Autowired
	PassagemRepository repo;
	//localhost:8080/passagens
	@GetMapping("/passagens")
	public List <Passagem> getAllPassagens(){
		List <Passagem> passagens = repo.findAll();
		return passagens;
	}
	
	//localhost:8080/clientes/1
	@GetMapping("/passagem/{id_passagem}")
	public Passagem getPassagem(@PathVariable int id_passagem){
		Passagem passagem = repo.findById(id_passagem).get();
		return passagem;
	}
	
		//localhost:8080/clientes/create
		@PostMapping("/passagem/create")
		@ResponseStatus(code = HttpStatus.CREATED)
		public void postPassagem(@RequestBody Passagem passagem){
			repo.save(passagem);
		}
		
		
		@DeleteMapping("/passagem/delete/{id_passagem}")
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		public void removePassagem(@PathVariable int id_passagem) {
			Passagem passagem = repo.findById(id_passagem).get();
			repo.delete(passagem);
		}
	
}
