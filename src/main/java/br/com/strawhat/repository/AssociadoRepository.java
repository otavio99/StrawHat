package br.com.strawhat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.strawhat.model.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Integer> {

}