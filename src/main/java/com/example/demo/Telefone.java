package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "telefone")
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "telefoneId")
	public Long telefoneId;
	@Column(name = "ddd", columnDefinition = "VARCHAR(3)", nullable = false)
	public String ddd;
	@Column(name = "numero", columnDefinition = "VARCHAR(10)", nullable = false)
	public String numero;
	@Column(name = "operadora", columnDefinition = "VARCHAR(20)", nullable = true)
	public String operadora;
	@ManyToOne
    @JoinColumn(name="aluno_id", nullable=false)
    public Aluno aluno;
}
