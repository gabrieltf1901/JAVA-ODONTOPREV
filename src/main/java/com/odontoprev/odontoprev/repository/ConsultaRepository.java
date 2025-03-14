package com.odontoprev.odontoprev.repository;

import com.odontoprev.odontoprev.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
