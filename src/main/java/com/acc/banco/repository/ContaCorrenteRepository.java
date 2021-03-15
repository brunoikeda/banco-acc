package com.acc.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acc.banco.model.ContaCorrente;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

    @Query("UPDATE ContaCorrente c SET c.saldo = c.saldo + ?1 WHERE c.id =?2")
    void setFixedSaldoFor (double quantidade, Long id);

    @Query(value = "SEELCT * FROM ContaCorrente WHERE id = :id", nativeQuery = true)
    ContaCorrente fidByIdContaCorrente(Long id);
	
}
