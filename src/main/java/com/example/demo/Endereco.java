package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enderecoId")
	public Long enderecoId;
	@Column(name = "logradouro", columnDefinition="VARCHAR(60)", nullable = false)
	public String logradouro;
	@Column(name = "numero", columnDefinition="VARCHAR(20)", nullable = false)
	public String numero;
	@Column(name = "complemento", columnDefinition="VARCHAR(60)", nullable = true)
	public String complemento;
	@Column(name = "bairro", columnDefinition="VARCHAR(40)", nullable = false)
	public String bairro;
	@Column(name = "cidade", columnDefinition="VARCHAR(40)", nullable = false)
	public String cidade;
	@Column(name = "uf", columnDefinition="VARCHAR(2)", nullable = false)
	public String uf;
	@Column(name = "pais", columnDefinition="VARCHAR(20)", nullable = false)
	public String pais;
	@Column(name = "cep", columnDefinition="VARCHAR(10)", nullable = false)
	public String cep;
	@Column(name = "pontoreferencia", columnDefinition="VARCHAR(60)", nullable = true)
	public String pontoreferencia;
}
