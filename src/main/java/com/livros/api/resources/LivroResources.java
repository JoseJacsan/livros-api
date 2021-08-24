package com.livros.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livros.api.models.Livro;
import com.livros.api.repository.LivroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="API REST DE LIVROS")
@CrossOrigin(origins = "*")
public class LivroResources {
	
	@Autowired
	LivroRepository livroRepository;
	
	@GetMapping("/livros")
	@ApiOperation(value="Retorna uma lista de livros")
	List<Livro> listaLivros() {
		return livroRepository.findAll();
		
	}
	
	@GetMapping("/livro/{id}")
	@ApiOperation(value="Retorna um produto único")
	public Livro listarUnicoLivro(@PathVariable(value = "id") long id) {
		return livroRepository.findById(id);
		
	}
	
	@PostMapping("/livro")
	@ApiOperation(value="Salva um livro")
	public Livro salvaLivro(@RequestBody Livro livro) {
		return livroRepository.save(livro);
		
	}
	
	@DeleteMapping("/livro")
	@ApiOperation(value="Deleta um livro")
	public void deletaLivro(@RequestBody Livro livro) {
		livroRepository.delete(livro);
	}
	
	@PutMapping("/livro")
	@ApiOperation(value="Atualiza um livro")
	public Livro atualizaLivro(@RequestBody Livro livro) {
		return livroRepository.save(livro);
	}
	
	
	
	
	
}
