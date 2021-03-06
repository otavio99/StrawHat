package br.com.strawhat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.strawhat.model.Batismo;

@Repository
public interface BatismoRepository extends JpaRepository<Batismo, Integer> {

}