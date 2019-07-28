package com.br.adivinhacao.services;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.adivinhacao.models.NumeroSortiado;
import com.br.adivinhacao.models.Usuario;
import com.br.adivinhacao.repository.SortiadoRepository;
import com.br.adivinhacao.repository.UsuarioRepository;

@Service
public class NumeroSorteado {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@SuppressWarnings("unused")
	@Autowired
	private SortiadoRepository sortiadoRopository;


	public String salvarJogo(Usuario usuario) {

		NumeroSortiado numeroSorteado = new NumeroSortiado();
		Random random = new Random();
		int sorteado = random.nextInt(2);
		String resultado="";


		if(usuario.getNumeroSortiado() == sorteado) {
			numeroSorteado.setNumero(sorteado);
			numeroSorteado.setUsuario(usuario);
			usuarioRepository.save(usuario);

			resultado= "Parabéns"+"Numero jogado "+ usuario.getNumeroSortiado()+" numero sortiado" + sorteado;
		}else {
			resultado= "Tenta de novo" + "Numero jogado "+ usuario.getNumeroSortiado()+" numero sortiado" + sorteado;
		}
		return resultado;
	}
}
