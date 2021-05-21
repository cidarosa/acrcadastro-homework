package com.acrdev.acrcadastro.dto;

import java.io.Serializable;
import java.time.Instant;

import com.acrdev.acrcadastro.entities.Client;

public class ClienteDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	// atribudos de Client
	private Long id;
	private String name;
	private String cpf;
	private Double income;
	private Instant birthDate;
	private Integer children;

	public ClienteDTO() {
	}

	public ClienteDTO(Long id, String name, String cpf, Double income, Instant birthDate, Integer children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}

	public ClienteDTO(Client entity) {

		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.income = entity.getIncome();
		this.birthDate = entity.getBirthDate();
		this.children = entity.getChildren();

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getIncome() {
		return income;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public Integer getChildren() {
		return children;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

}
