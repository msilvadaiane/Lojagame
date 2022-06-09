package com.generation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.generation.model.Usuario;

@Repository
public interface UsuarioRepository {
	
	public Optional<Usuario> findByUsuario(String usuario);
	
	public List<Usuario> findAllByUsuarioContainingIgnoreCase (String usuario);
	
	

}
