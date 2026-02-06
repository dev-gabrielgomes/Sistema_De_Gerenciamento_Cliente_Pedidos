package com.trabalho.final1.services;

import java.util.List;
import java.util.NoSuchElementException; // 1. IMPORTADO PARA TRATAR ERROS
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.final1.entities.Cliente;
import com.trabalho.final1.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> procuraTodos() {	
		 return repository.findAll();
	}
	
	public Cliente procuraPorId(Integer id) {	
        
		return repository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + id));
	}
	
	public Cliente adicionaCliente(Cliente cliente) {
        
		 return repository.save(cliente);
	}
	
    
	public Cliente editarCliente(Integer id, Cliente cliente) {
        
        
		Cliente clienteExistente = repository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + id));
		
       
		clienteExistente.setNome(cliente.getNome());
		clienteExistente.setEmail(cliente.getEmail());
		clienteExistente.setNumero(cliente.getNumero());
		
        
		return repository.save(clienteExistente);
	}
	
	public void excluirCliente(Integer id) {	
        
		Cliente clienteParaExcluir = repository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + id));
		
        repository.delete(clienteParaExcluir);
	}
}