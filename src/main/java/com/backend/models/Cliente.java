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
@Table(name = "Cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cliente;
	
	@Column(name="nome")
	private String name;
	@Column(name="cpf")
	private int cpf;
	@Column(name="telefone")
	private int telefone;
	@Column(name="email")
	private String email;
	@Column(name="senha")
	private String senha;
	
	@OneToMany(mappedBy = "cliente", orphanRemoval=true)
	@Cascade(value= {CascadeType.ALL})
	private List<Passagem> passagens = new ArrayList<>();
	
	public Cliente() {
		
	}

	public Cliente(String name, int cpf, int telefone, String email, String senha) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", name=" + name + ", cpf=" + cpf + ", telefone=" + telefone
				+ ", email=" + email + ", senha=" + senha + "]";
	}

	

	

	
}
