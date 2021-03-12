package com.acc.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acc.banco.model.ContaCorrente;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

	
}
