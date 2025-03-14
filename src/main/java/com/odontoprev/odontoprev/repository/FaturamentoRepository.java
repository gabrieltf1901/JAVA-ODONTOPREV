package com.odontoprev.odontoprev.repository;

import com.odontoprev.odontoprev.model.Faturamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturamentoRepository extends JpaRepository<Faturamento, Long> {
}