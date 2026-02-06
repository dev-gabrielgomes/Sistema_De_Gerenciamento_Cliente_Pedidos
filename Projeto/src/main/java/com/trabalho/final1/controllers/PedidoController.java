package com.trabalho.final1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.final1.entities.Pedido;
import com.trabalho.final1.services.PedidoService;


@RestController
@RequestMapping(value="/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService service;

	@GetMapping
	public List<Pedido> procuraTodos() {	
		return service.procuraTodos();
	}
	
	@GetMapping(value = "/{id}")	
	   public Pedido procuraPorId (@PathVariable Integer id) {	
			return service.procuraPorId(id);
		}
	
	@PostMapping
	public Pedido adicionaPedido (@RequestBody Pedido pedido) {
		//String response = service.adicionaPedido(pedido);
		return service.adicionaPedido(pedido);
				
	}
	
	@PutMapping (value= "/{id}")
	public String editarPedido( @PathVariable Integer id, @RequestBody Pedido pedido) {
		
		String response = service.editarPedido(id, pedido);
		return response;
	}
	
	@DeleteMapping(value = "/{id}")
	public void excluirPedido (@PathVariable Integer id) {
		service.excluirPedido(id);
	}

}
