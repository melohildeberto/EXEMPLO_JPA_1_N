package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Disciplina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name = "nome", columnDefinition="VARCHAR(60)", nullable = false)
	public String nome;
	@Column(name = "ementa", columnDefinition="VARCHAR(250)", nullable = false)
	public String ementa;
	@Column(name = "duracaohoras")
	public int duracaoHoras;
	@Column(name = "bibliografia", columnDefinition="VARCHAR(500)", nullable = false)
	public String bibliografia; 
}
