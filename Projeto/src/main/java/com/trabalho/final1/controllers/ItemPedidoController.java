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


import com.trabalho.final1.entities.ItemPedido;
import com.trabalho.final1.services.ItemPedidoService;

@RestController
@RequestMapping(value="/itempedido")
public class ItemPedidoController {
	
	@Autowired
	private ItemPedidoService service;

	@GetMapping
	public List<ItemPedido> procuraTodos() {	
		return service.procuraTodos();
	}
	
	@GetMapping(value = "/{id}")	
	   public ItemPedido procuraPorId (@PathVariable Integer id) {	
			return service.procuraPorId(id);
		}
	
	@PostMapping
	public String adicionaItemPedido (@RequestBody ItemPedido itempedido) {
		//String response = service.adicionaItemPedido(itempedido);
		return service.adicionaItemPedido(itempedido);
				
	}
	
	@PutMapping (value= "/{id}")
	public String editarItemPedido( @PathVariable Integer id, @RequestBody ItemPedido itempedido) {
		
		String response = service.editarItemPedido(id, itempedido);
		return response;
	}
	
	@DeleteMapping(value = "/{id}")
	public void excluirItemPedido (@PathVariable Integer id) {
		service.excluirItemPedido(id);
	}
}
