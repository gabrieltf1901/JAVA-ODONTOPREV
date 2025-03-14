package com.odontoprev.odontoprev.repository;

import com.odontoprev.odontoprev.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
