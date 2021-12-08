package br.cadastro.pessoas.resource;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.cadastro.pessoas.model.Pessoa;
import br.cadastro.pessoas.repository.PessoaRepository;

@RestController
@RequestMapping("/api")
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping("/pessoa")
	public List<Pessoa> ListPessoas() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/pessoa/{id}")
	public Pessoa ListPessoaById(@PathVariable Long id) {
		return pessoaRepository.findById(id).get();
	}
	
	@PostMapping("/pessoa")
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa save(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@DeleteMapping("/pessoa/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}
	
	@PutMapping("/pessoa/{id}")
	public Pessoa update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		Pessoa pessoaAtual = pessoaRepository.findById(id).get();
		BeanUtils.copyProperties(pessoa, pessoaAtual, "id");
		return pessoaRepository.save(pessoaAtual);
	}
	
}
