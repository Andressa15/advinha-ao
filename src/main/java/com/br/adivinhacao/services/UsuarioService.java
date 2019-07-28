package com.br.adivinhacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.adivinhacao.models.Usuario;
import com.br.adivinhacao.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository  usuarioRepository;

	public String salvarJogador(Usuario usuario) {
		usuarioRepository.save(usuario);
		return "Salvado";
	}

	public Iterable<Usuario> ganhadores(){
		return usuarioRepository.findAll();
	}
}
