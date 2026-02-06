package com.trabalho.final1.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.trabalho.final1.entities.Cliente;
import com.trabalho.final1.entities.ItemPedido;
import com.trabalho.final1.entities.Pedido;
import com.trabalho.final1.entities.Produto;
import com.trabalho.final1.repository.ClienteRepository; 
import com.trabalho.final1.repository.PedidoRepository;
import com.trabalho.final1.repository.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	public List<Pedido> procuraTodos() {	
		 return repository.findAll();
	}
	
	public Pedido procuraPorId(Integer id) {	
		return repository.findById(id).get();
	}
	
	@Transactional
	public Pedido adicionaPedido(Pedido pedido) {
	    
	   
	    if (pedido.getCliente() == null || pedido.getCliente().getId() == null) {
	        throw new RuntimeException("ID do Cliente é obrigatório para um novo pedido.");
	    }
	    
	    Integer clienteId = pedido.getCliente().getId();
	    Cliente clienteReal = clienteRepository.findById(clienteId)
	        .orElseThrow(() -> new RuntimeException("Cliente com ID " + clienteId + " não encontrado."));
	    
	   
	    pedido.setCliente(clienteReal);
	    
	   
	    if (pedido.getItens() != null) {
	        for (ItemPedido item : pedido.getItens()) {         
	           
	           
	            item.setPedido(pedido); 
	            
	           
	            Produto produtoReal = produtoRepository.findById(item.getProduto().getId())
	                .orElseThrow(() -> new RuntimeException("Produto com ID " + item.getProduto().getId() + " não encontrado."));
	            
	         
	            item.setProduto(produtoReal); 
	        }
	    }
	    
	   
	    return repository.save(pedido);
	}
	
	public String editarPedido(Integer id, Pedido pedido) {
		Pedido response = repository.findById(id).get();
		
		response.setCliente(pedido.getCliente());
		response.setItens(pedido.getItens());
		response.setQuantidadeTotal(pedido.getQuantidadeTotal());
		
		
		repository.save(response);
		return " Pedido editado com sucesso!";		
		
	}
	
	public void excluirPedido(Integer id) {	
		Pedido response = repository.findById(id).get();
		repository.delete(response);
	}
}