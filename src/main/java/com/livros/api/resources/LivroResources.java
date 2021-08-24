package com.livros.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livros.api.models.Livro;
import com.livros.api.repository.LivroRepository;

@RestController
@RequestMapping("/api")
public class LivroResources {
	
	@Autowired
	LivroRepository livroRepository;
	
	@GetMapping("/livros")
	List<Livro> listaLivros() {
		return livroRepository.findAll();
		
	}
	
	@GetMapping("/livro/{id}")
	public Livro listarUnicoLivro(@PathVariable(value = "id") long id) {
		return livroRepository.findById(id);
		
	}
	
	@PostMapping("/livro")
	public Livro salvaLivro(@RequestBody Livro livro) {
		return livroRepository.save(livro);
		
	}
	
	
	
	
	
	
	
	
}
