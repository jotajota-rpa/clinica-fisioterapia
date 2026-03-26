package com.jotajota.backend.service;

import com.jotajota.backend.dto.AjustesClinicaDto;
import com.jotajota.backend.entity.AjustesClinica;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface IAjustesClinicaService {
    Optional<AjustesClinica> obtenerAjustes();
    String guardarLogoEnDisco(MultipartFile archivo) throws IOException;
    AjustesClinica insertarOactualizarDatos(AjustesClinicaDto dto);
    boolean existeAjustes(int id);
}
