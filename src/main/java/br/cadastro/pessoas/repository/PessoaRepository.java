package br.cadastro.pessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.cadastro.pessoas.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
}
