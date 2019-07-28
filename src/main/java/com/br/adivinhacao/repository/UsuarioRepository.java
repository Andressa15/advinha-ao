package com.br.adivinhacao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.adivinhacao.models.Usuario;
@Repository
public interface UsuarioRepository  extends CrudRepository<Usuario, Integer>{

}
