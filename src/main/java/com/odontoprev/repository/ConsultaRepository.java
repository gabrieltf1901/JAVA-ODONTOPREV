package com.odontoprev.repository;

import com.odontoprev.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByUsuarioIdAndDataHoraAfter(Long usuarioId, LocalDateTime dataHora);

    List<Consulta> findByProfissionalIdAndDataHoraBetween(Long profissionalId,
                                                          LocalDateTime inicio,
                                                          LocalDateTime fim);
}
