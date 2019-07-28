package com.br.adivinhacao.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.br.adivinhacao.models.Usuario;
import com.br.adivinhacao.services.NumeroSorteado;
import com.br.adivinhacao.services.UsuarioService;
@Controller
public class NumeroSortido {
	@Autowired
	private NumeroSorteado numeroSorteado;

	@Autowired
	private UsuarioService usuariorService;

	@GetMapping("/")
	public ModelAndView mapiarHome() {
		ModelAndView modelAndView = new ModelAndView("entrada.html");
		modelAndView.addObject("ganhadores", usuariorService.ganhadores());
		return modelAndView;
	}

	@GetMapping("/jogar")
	public ModelAndView mapiarJogar() {
		ModelAndView modelAndView = new ModelAndView("jogar.html");
		return modelAndView;
	}

	@PostMapping("/jogar")
	public ModelAndView salvarGanhador(@Valid Usuario usuario, BindingResult bindingJogador) {
		ModelAndView modelAndView = new ModelAndView("jogar.html");

		List<String> mensagens = new ArrayList<String>();
		List<String> erros = new ArrayList<String>();

		if(bindingJogador.hasErrors()) {

			for (ObjectError objectError : bindingJogador.getAllErrors()) {
				erros.add(objectError.getDefaultMessage());
				modelAndView.addObject("erros", erros);			

			}

		}else {
			mensagens.add(numeroSorteado.salvarJogo(usuario));
			modelAndView.addObject("mensagens", mensagens);
		}
		return modelAndView;
	}
}