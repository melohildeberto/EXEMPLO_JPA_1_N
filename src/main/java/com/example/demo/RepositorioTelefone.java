package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RepositorioTelefone extends CrudRepository<Telefone, Long>{
	List<Telefone> findAllByAlunoAlunoId(Long id);
}
