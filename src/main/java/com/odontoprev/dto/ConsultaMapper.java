package com.odontoprev.dto;

import com.odontoprev.config.EntityMapper;
import com.odontoprev.model.Consulta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ConsultaMapper extends EntityMapper<ConsultaDTO, Consulta> {

    @Mapping(source = "usuario.id", target = "usuarioId")
    @Mapping(source = "profissional.id", target = "profissionalId")
    ConsultaDTO toDto(Consulta consulta);

    @Mapping(source = "usuarioId", target = "usuario.id")
    @Mapping(source = "profissionalId", target = "profissional.id")
    Consulta toEntity(ConsultaDTO dto);
}
