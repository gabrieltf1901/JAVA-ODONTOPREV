package com.odontoprev.odontoprev.repository;

import com.odontoprev.odontoprev.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}
