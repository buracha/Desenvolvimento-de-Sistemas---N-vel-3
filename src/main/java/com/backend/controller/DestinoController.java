package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.backend.models.Destino;
import com.backend.repositories.DestinoRepository;

@RestController
public class DestinoController {
	@Autowired
	DestinoRepository repo;
	
	//localhost:8080/destinos
		@GetMapping("destinos")
		public List <Destino> getAllDestinos(){
			List <Destino> destinos = repo.findAll();
			return destinos;
		}
		
		//localhost:8080/destinos/1
		@GetMapping("/destinos/{id_destino}")
		public Destino getDestinos(@PathVariable int id_destino){
			Destino destino = repo.findById(id_destino).get();
			return destino;
		}
		
		//localhost:8080/destino/create
		@PostMapping("/destino/create")
		@ResponseStatus(code = HttpStatus.CREATED)
		public void postDestino(@RequestBody Destino destino){
			repo.save(destino);
		}
		
		@PutMapping("/destino/update/{id_destino}")
		public Destino updateDestino(@PathVariable int id_destino) {
		   Destino destino = repo.findById(id_destino).get();
		   destino.setLugar("Foz do Iguaçu");
		   destino.setTipo("Nascional");
		   destino.setPreco(500);
		   repo.save(destino);
		   return destino;
			
		}
		
		@DeleteMapping("/destino/delete/{id_destino}")
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		public void removeDestino(@PathVariable int id_destino) {
			Destino destino = repo.findById(id_destino).get();
			repo.delete(destino);
		}
}
