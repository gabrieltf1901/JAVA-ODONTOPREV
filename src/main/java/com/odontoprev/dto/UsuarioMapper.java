package com.odontoprev.dto;

import com.odontoprev.config.EntityMapper;
import com.odontoprev.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> { }
