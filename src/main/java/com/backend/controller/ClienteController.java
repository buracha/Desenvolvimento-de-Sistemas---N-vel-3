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

import com.backend.models.Cliente;
import com.backend.repositories.ClienteRepository;


@RestController
public class ClienteController {
	
	@Autowired
	ClienteRepository repo;
	//localhost:8080/clientes
	@GetMapping("/clientes")
	public List <Cliente> getAllClientes(){
		List <Cliente> clientes = repo.findAll();
		return clientes;
	}
	
	//localhost:8080/clientes/1
	@GetMapping("/cliente/{id_cliente}")
	public Cliente getCliente(@PathVariable int id_cliente){
		Cliente cliente = repo.findById(id_cliente).get();
		return cliente;
	}
	
	//localhost:8080/clientes/create
	@PostMapping("/cliente/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void postCliente(@RequestBody Cliente cliente){
		repo.save(cliente);
	}
	
	@PutMapping("/cliente/update/{id_cliente}")
	public Cliente updateCliente(@PathVariable int id_cliente) {
	   Cliente cliente = repo.findById(id_cliente).get();
	   cliente.setName("John");
	   cliente.setCpf(321);
	   cliente.setTelefone(123);
	   cliente.setEmail("rttr");
	   cliente.setSenha("yjjy");
	   repo.save(cliente);
	   return cliente;
		
	}
	
	@DeleteMapping("/cliente/delete/{id_cliente}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeCliente(@PathVariable int id_cliente) {
		Cliente cliente = repo.findById(id_cliente).get();
		repo.delete(cliente);
	}
	
}
