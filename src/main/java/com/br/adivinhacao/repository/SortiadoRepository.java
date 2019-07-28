package com.br.adivinhacao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.adivinhacao.models.NumeroSortiado;
@Repository
public interface SortiadoRepository extends CrudRepository<NumeroSortiado, Integer> {

}
