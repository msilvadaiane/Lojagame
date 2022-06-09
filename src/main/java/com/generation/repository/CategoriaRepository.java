package com.generation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.stereotype.Repository;

import com.generation.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	

public List<Categoria> findAllByTipoContainingIgnoreCase(@Param("tipo")String tipo);

public static HeadersBuilder<BodyBuilder> badRequest() {
	// TODO Auto-generated method stub
	return null;
}


}
