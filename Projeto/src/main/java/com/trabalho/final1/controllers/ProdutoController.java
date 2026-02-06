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

import com.trabalho.final1.entities.Produto;
import com.trabalho.final1.services.ProdutoService;

@RestController
@RequestMapping(value="/produto")
public class ProdutoController {
	
	
	@Autowired
	private ProdutoService service;

	@GetMapping
	public List<Produto> procuraTodos() {	
		return service.procuraTodos();
	}
	
	@GetMapping(value = "/{id}")	
	   public Produto procuraPorId (@PathVariable Integer id) {	
			return service.procuraPorId(id);
		}
	
	@PostMapping
	public String adicionaProduto (@RequestBody Produto produto) {
		//String response = service.adicionaPedidos(produto);
		return service.adicionaProduto(produto);
				
	}
	
	@PutMapping (value= "/{id}")
	public String editarProduto( @PathVariable Integer id, @RequestBody Produto produto) {
		
		String response = service.editarProduto(id, produto);
		return response;
	}
	
	@DeleteMapping(value = "/{id}")
	public void excluirProduto (@PathVariable Integer id) {
		service.excluirProduto(id);
	}

}
