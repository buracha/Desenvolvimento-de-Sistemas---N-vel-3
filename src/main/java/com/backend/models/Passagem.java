package com.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Passagem")
public class Passagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_passagem;
	
	@Column(name="data")
	private String dataPassagem;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "id_destino")
	private Destino destino;
	
	@Column(name="preco")
	private int preco;

	
	public Passagem() {
		
	}


	public Passagem(Cliente cliente, Destino destino, String dataPassagem, int preco) {
		super();
		this.cliente = cliente;
		this.destino = destino;
		this.dataPassagem = dataPassagem;
		this.preco = preco;
	}


	public int getId_passagem() {
		return id_passagem;
	}


	public void setId_passagem(int id_passagem) {
		this.id_passagem = id_passagem;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Destino getDestino() {
		return destino;
	}


	public void setDestino(Destino destino) {
		this.destino = destino;
	}


	public String getDataPassagem() {
		return dataPassagem;
	}


	public void setDataPassagem(String dataPassagem) {
		this.dataPassagem = dataPassagem;
	}
	
	public int getPreco() {
		return preco;
	}
	
	public void setPreco(int preco) {
		this.preco = preco;
	}


	@Override
	public String toString() {
		return "Passagem [id_passagem=" + id_passagem + ", dataPassagem=" + dataPassagem + ", cliente=" + cliente
				+ ", destino=" + destino + ", preco=" + preco + "]";
	}
	
	
}
