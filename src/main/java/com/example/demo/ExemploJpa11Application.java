package com.example.demo;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExemploJpa11Application {

	public static void main(String[] args) {
		SpringApplication.run(ExemploJpa11Application.class, args);
	}

	
//	@Bean
	public CommandLineRunner inserindoProfessores(RepositorioProfessor repositorio) {
		return (args) -> {
			try {
				//criar um objeto, carregar dados no objeto, salvar o objeto
				for (int i = 2; i <= 100; i++) {
					Professor professor = new Professor();
					professor.nome = "Melo" + i;
					professor.cpf = "" + i;
					professor.rg = "" + i;
					professor.matricula = i;
					repositorio.save(professor);
					System.out.println("Professor cadastrado");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}

	
//	@Bean
	public CommandLineRunner listarProfessores(RepositorioProfessor repositorio) {
		return (args) -> {
			try {
				for (Professor p : repositorio.findAll()) {
					System.out.println(p.nome);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}
	
//	@Bean
	public CommandLineRunner atualizarProfessor(RepositorioProfessor repositorio) {
		return (args) -> {
			try {
				//lógica: pesquisar, atualizar os dados, salvar
				Optional<Professor> prof = repositorio.findById(1L);
				if (prof.isPresent()) {
					Professor p = prof.get();
					p.nome = "Novo nome";
					repositorio.save(p);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}
	
//	@Bean
	public CommandLineRunner deleteProfessor(RepositorioProfessor repositorio) {
		return (args) -> {
			try {
				//lógica: pesquisar, remover
				Optional<Professor> prof = repositorio.findById(1L);
				if (prof.isPresent()) {
					Professor p = prof.get();
					repositorio.delete(p);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}

	
	@Bean
	public CommandLineRunner listarProfessoresPorCpf(RepositorioProfessor repositorio) {
		return (args) -> {
			try {
				for (Professor p : repositorio.findByCpf("2")) {
					System.out.println(p.nome);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}
	
	
	
	
	
	
//	@Bean
	public CommandLineRunner inserindoDisciplinas(DisciplinaRepository repositorio,
			RepositorioEndereco repositorioEndereco) {
		return (args) -> {
			try {
				for (int i = 1; i < 100; i++) {

					Disciplina disciplina = new Disciplina();
					disciplina.nome = "Backend" + i;
					disciplina.ementa = "Ementa da disciplina" + i;
					disciplina.duracaoHoras = 60;
					disciplina.bibliografia = "Livros de ..." + i;
					repositorio.save(disciplina);
					System.out.println("Disciplina cadastrada");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}

//	@Bean
	public CommandLineRunner alterarDisciplina(DisciplinaRepository repositorio,
			RepositorioEndereco repositorioEndereco) {
		return (args) -> {
			try {
				Optional<Disciplina> obj = repositorio.findById(1L);
				if (obj.isPresent()) {
					Disciplina discEncontrada = obj.get();
					discEncontrada.nome = "Novo nome";
					repositorio.save(discEncontrada);
				}
				for (Disciplina disc : repositorio.findAll()) {
					System.out.println(disc.id + " " + disc.nome);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}

//	@Bean
	public CommandLineRunner removerDisciplina(DisciplinaRepository repositorio,
			RepositorioEndereco repositorioEndereco) {
		return (args) -> {
			try {
				Optional<Disciplina> obj = repositorio.findById(1L);
				if (obj.isPresent()) {
					Disciplina discEncontrada = obj.get();
					repositorio.delete(discEncontrada);
				}
				for (Disciplina disc : repositorio.findAll()) {
					System.out.println(disc.id + " " + disc.nome);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}

//	@Bean
	public CommandLineRunner listarDisciplinas(DisciplinaRepository repositorio,
			RepositorioEndereco repositorioEndereco) {
		return (args) -> {
			try {
				for (Disciplina disc : repositorio.findAll()) {
					System.out.println(disc.id + " " + disc.nome);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}

//	@Bean
	public CommandLineRunner inserindoAlunoEndereco(RepositorioAluno repositorioAluno,
			RepositorioEndereco repositorioEndereco) {
		return (args) -> {
			try {
				Aluno aluno = new Aluno();
				aluno.nome = "Melo";
				aluno.cpf = "1234567890";
				aluno.rg = "01234546";
				Endereco endereco = new Endereco();
				endereco.logradouro = "Rua da Lama";
				endereco.numero = "123";
				endereco.bairro = "Prado";
				endereco.cidade = "Recife";
				endereco.uf = "PE";
				endereco.cep = "123456-789";
				endereco.pais = "Brasil";
				endereco.pontoreferencia = "Perto da rua do buraco";
				endereco.complemento = "Chamar Tonha";
				aluno.endereco = endereco;
				aluno = repositorioAluno.save(aluno);
				System.out.println("Aluno salvo");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}

//	@Bean
	public CommandLineRunner listarAluno(RepositorioAluno repositorioAluno, RepositorioEndereco repositorioEndereco) {
		return (args) -> {

			for (Aluno obj : repositorioAluno.findAll()) {
				System.out.println(obj.endereco.logradouro);
			}

		};
	}

}
