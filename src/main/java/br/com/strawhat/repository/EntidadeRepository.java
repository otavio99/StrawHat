package br.com.strawhat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.strawhat.model.Entidade;

@Repository
public interface EntidadeRepository extends JpaRepository<Entidade, Integer> {

}