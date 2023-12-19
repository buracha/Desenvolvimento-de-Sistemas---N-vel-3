package com.backend.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Destino")
public class Destino {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_destino;
	
	@Column(name="lugar")
	private String lugar;
	@Column(name="tipo")
	private String tipo;
	@Column(name="preco")
	private int preco;
	
	@OneToMany(mappedBy = "destino", orphanRemoval=true)
	@Cascade(value= {CascadeType.ALL})
	private List<Passagem> passagens = new ArrayList<>();
	
	public Destino() {
		
	}
	
	public Destino(String lugar, String tipo, int preco) {
		super();
		this.lugar = lugar;
		this.tipo = tipo;
		this.preco = preco;
	}

	public int getId_destino() {
		return id_destino;
	}

	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Destino [id_destino=" + id_destino + ", lugar=" + lugar + ", tipo=" + tipo + ", preco=" + preco + "]";
	}
	
	
	
}
