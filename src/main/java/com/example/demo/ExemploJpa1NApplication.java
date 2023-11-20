package com.example.demo;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class ExemploJpa1NApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExemploJpa1NApplication.class, args);
	}
//	@Primary
//	@Bean
	public CommandLineRunner inserindoAluno(RepositorioAluno repositorioAluno) {
		return (args) -> {
			try {
				Aluno aluno = new Aluno();
				aluno.nome = "Melo";
				aluno.cpf = "1234567890";
				aluno.rg = "01234546";
				aluno = repositorioAluno.save(aluno);
				System.out.println("Aluno salvo");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}

//	@Primary
	@Bean
	public CommandLineRunner inserindoTelefone(RepositorioAluno repositorioAluno,
			RepositorioTelefone repositorioTelefone) {
		return (args) -> {
			try {
				Optional<Aluno> aluno = repositorioAluno.findById(1L);
				if (aluno.isPresent()) {
					for (int i = 1; i < 21; i++) {
						Telefone telefone = new Telefone();
						telefone.ddd = "81";
						telefone.numero = ""+i;
						telefone.operadora = "tim";
						telefone.aluno = aluno.get();
						telefone = repositorioTelefone.save(telefone);
					}
					System.out.println("Telefone salvo");
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}
	
//	@Bean
	public CommandLineRunner listarAlunos(RepositorioAluno repositorioAluno,
			RepositorioTelefone repositorioTelefone) {
		return (args) -> {
			try {
				for (Aluno a : repositorioAluno.findAll()) {
//					a.telefones = repositorioTelefone.findAllByAlunoAlunoId(a.alunoId);
					System.out.println(a.toString());
//					for (Telefone t : a.telefones) {
//						System.out.println(t.numero);
//					}
//					for (Telefone t : repositorioTelefone.findAllByAlunoAlunoId(a.alunoId)) {
//						System.out.println(t.numero);
//					}
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}
	
	@Bean
	public CommandLineRunner listarTelefones(RepositorioAluno repositorioAluno,
			RepositorioTelefone repositorioTelefone) {
		return (args) -> {
			try {
				for (Telefone a : repositorioTelefone.findAll()) {
					System.out.println(a.toString());
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}
}
