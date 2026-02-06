package com.trabalho.final1.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column; // Importar
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist; // Importar
import jakarta.persistence.PreUpdate; // Importar

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne 
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens;
	
	@Column(name = "valor_final")
	private Double valorFinal;
	
	@Column(name = "quantidade_total")
	private Integer quantidadeTotal;
	
	public Pedido() {
	}
	
   
	public Double somaValorDosItens() {
		if (itens == null || itens.isEmpty()) {
            return 0.0; 
		}
		return itens.stream().mapToDouble(ItemPedido::getSubTotal).sum();
	}
	
	@PrePersist
	@PreUpdate
	public void calcularTotais() {

        this.setValorFinal(somaValorDosItens());

        if (itens == null) {
            this.setQuantidadeTotal(0);
        } else {
            this.setQuantidadeTotal(
                itens.stream().mapToInt(ItemPedido::getQuantidade).sum()
            );
        }
    }
    
 
	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}
    
    // 6. GETTER QUE FALTAVA
    public Double getValorFinal() {
        return valorFinal;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Integer getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void setQuantidadeTotal(Integer quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}
}