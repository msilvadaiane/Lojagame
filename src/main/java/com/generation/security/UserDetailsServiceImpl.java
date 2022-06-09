package com.generation.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.model.Usuario;
import com.generation.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundExceotion {
		
		Optional<Usuario> usuario = userRepository.findByUsuario(userName);
		
		usuario.orElseThrow(()-> new UsernameNotFoundException(userName + "not found"));
		
		return usuario.map(UserDetailsImpl::new).get();
		
		
	}
	

}
