package com.generation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name="tb_usuario")
public class Usuario {
	
	
	@Id
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	private Long id;
	
	@NotNull (message= "O nome é obrigatório")
	private String nome;
	
	@NotNull (message= "O Usuário é obrigatório")
	@Email (message= "O usuario deve ser um email valido")
	private String usuario;
	
	@NotBlank(message= "O atributo Senha é obrigatorio")
	@Size(min=8, message= "A Senha deve ter no minimo 8 caracteres")
	private String senha;
	
	private String foto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
	
	
	
	
	
	

}
