package com.generation.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.model.Categoria;
import com.generation.repository.CategoriaRepository;

@RestController
@RequestMapping ("/categorias")
@CrossOrigin (origins= "*", allowedHeaders="*")
public class CategoriaController
{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>>  getAll()
	{
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id)
	{
		return categoriaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.badRequest().build());
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Categoria>> getByDescricao (@PathVariable String tipo)
	{
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.findAllByTipoContainingIgnoreCase(tipo));
		
	}
	
	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@Valid @RequestBody Categoria categoria)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
		
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@Valid @RequestBody Categoria categoria)
	
	{
		if (categoria.getId() == null || !categoriaRepository.existsById(categoria.getId()))
				return ResponseEntity.badRequest().build();
		
		return categoriaRepository.findById(categoria.getId())
				.map(resposta -> ResponseEntity.ok(categoriaRepository.save(categoria)))
				.orElse(ResponseEntity.badRequest().build());
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Categoria> delCategoria(@PathVariable Long id)
	{
		if (categoriaRepository.existsById(id))
		{
			categoriaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		
	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	
		
		
	}
	

}
