package com.generation.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.model.Produto;

@Repository
public interface ProdutoRepository {
	
	
	public List<Produto> findAllByDescricaoContainingIgnoreCase (@Param("descricao")String descricao);
	
	public List<Produto> findByPrecoLessThanList(BigDecimal preco);
	
	public List<Produto> findByPrecoGreaterThan (BigDecimal preco);

	public boolean existsById(Long id);

	public void deleteById(Long id);

	public Object findById(Long id);



	
	
	

}
