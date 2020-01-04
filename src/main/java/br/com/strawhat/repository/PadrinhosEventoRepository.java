package br.com.strawhat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.strawhat.model.PadrinhosEvento;

@Repository
public interface PadrinhosEventoRepository extends JpaRepository<PadrinhosEvento, Integer> {

}