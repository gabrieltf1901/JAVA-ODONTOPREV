package com.odontoprev.dto;

import com.odontoprev.config.EntityMapper;
import com.odontoprev.model.Profissional;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfissionalMapper extends EntityMapper<ProfissionalDTO, Profissional> {
}
