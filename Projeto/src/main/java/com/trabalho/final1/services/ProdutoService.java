package com.trabalho.final1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.final1.entities.Produto;
import com.trabalho.final1.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> procuraTodos() {	
		 return repository.findAll();
	}
	
	public Produto procuraPorId(Integer id) {	
		return repository.findById(id).get();
	}
	
	public String adicionaProduto(Produto produto) {
		 repository.save(produto);
		 return " Produto adicionado com sucesso!";
		
	}
	
	public String editarProduto(Integer id, Produto produto) {
		Produto response = repository.findById(id).get();
		
		response.setNome(produto.getNome());
		response.setPreco(produto.getPreco());
		
		
		repository.save(response);
		return " Produto editado com sucesso!";		
		
	}
	
	public void excluirProduto(Integer id) {	
		Produto response = repository.findById(id).get();
		repository.delete(response);
	}

}
