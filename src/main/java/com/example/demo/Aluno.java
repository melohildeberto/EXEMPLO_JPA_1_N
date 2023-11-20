package com.example.demo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alunoId")
	public Long alunoId;
	@Column(name = "nome", columnDefinition="VARCHAR(60)", nullable = false)
	public String nome;
	@Column(name = "cpf", columnDefinition="VARCHAR(11)", unique = true, nullable = false)
	public String cpf;
	@Column(name = "rg", columnDefinition="VARCHAR(10)", nullable = false)
	public String rg;
	@OneToMany(mappedBy="aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Telefone> telefones;
}
