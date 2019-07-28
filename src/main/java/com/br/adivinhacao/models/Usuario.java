package com.br.adivinhacao.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@NotBlank(message = "nao pode ficar vazio")
	private String name;
	@NotNull
	@DecimalMin(value = "2",message = "nao pode ficar vazio")
	
	private int numeroSortiado  ;

	@OneToOne(cascade = {CascadeType.ALL})
	private JogoController jogoController;

	public Usuario() {
		super();
	}
	public int getNumeroSortiado() {
		return numeroSortiado;
	}
	public int setNumeroSortiado(@NotNull @DecimalMin(value = "2", message = "nao pode ficar vazio") int numeroSorteado) {
		return this.numeroSortiado = numeroSorteado;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
