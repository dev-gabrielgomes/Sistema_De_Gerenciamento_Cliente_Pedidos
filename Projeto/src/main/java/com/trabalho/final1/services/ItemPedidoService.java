package com.trabalho.final1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.trabalho.final1.entities.ItemPedido;
import com.trabalho.final1.repository.ItemPedidoRepository;



@Service
public class ItemPedidoService {

	
	@Autowired
	private ItemPedidoRepository repository;
	
	public List<ItemPedido> procuraTodos() {	
		 return repository.findAll();
	}
	
	public ItemPedido procuraPorId(Integer id) {	
		return repository.findById(id).get();
	}
	
	public String adicionaItemPedido(ItemPedido itempedido) {
		 repository.save(itempedido);
		 return " ItemPedido adicionado com sucesso!";
		
	}
	
	public String editarItemPedido(Integer id, ItemPedido itempedido) {
		ItemPedido response = repository.findById(id).get();
		
		response.setPedido(itempedido.getPedido());
		response.setProduto(itempedido.getProduto());
		response.setQuantidade(itempedido.getQuantidade());
		
		
		repository.save(response);
		return " ItemPedido editado com sucesso!";		
		
	}
	
	public void excluirItemPedido(Integer id) {	
		ItemPedido response = repository.findById(id).get();
		repository.delete(response);
	}
}
