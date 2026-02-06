package com.trabalho.final1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // 1. IMPORTADO
import org.springframework.http.ResponseEntity; // 2. IMPORTADO
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.final1.entities.Cliente;
import com.trabalho.final1.services.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;

	@GetMapping
	public ResponseEntity<List<Cliente>> procuraTodos() {	
		return ResponseEntity.ok(service.procuraTodos());
	}
	
	@GetMapping(value = "/{id}")	
	public ResponseEntity<Cliente> procuraPorId (@PathVariable Integer id) {	
		return ResponseEntity.ok(service.procuraPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> adicionaCliente (@RequestBody Cliente cliente) {
		Cliente novoCliente = service.adicionaCliente(cliente);
       
		return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
	}
	
 
	@PutMapping (value= "/{id}")
	public ResponseEntity<Cliente> editarCliente( @PathVariable Integer id, @RequestBody Cliente cliente) {
		
      
		Cliente clienteAtualizado = service.editarCliente(id, cliente);
        
     
		return ResponseEntity.ok(clienteAtualizado);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluirCliente (@PathVariable Integer id) {
		service.excluirCliente(id);
       
		return ResponseEntity.noContent().build();
	}
}