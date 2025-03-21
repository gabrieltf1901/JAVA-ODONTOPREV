package com.odontoprev.odontoprev.repository;

import com.odontoprev.odontoprev.model.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {
}
