package com.trabalho.final1.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonBackReference
	@ManyToOne 
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	@ManyToOne 
	@JoinColumn(name = "produto_id")
	private Produto produto;
	private Integer quantidade;
	
	private ItemPedido() {}

	
	public Double getSubTotal() {
        if (produto != null && produto.getPreco() != null && quantidade != null) {
            return produto.getPreco() * quantidade;
        }
        return 0.0;
    }


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
}
