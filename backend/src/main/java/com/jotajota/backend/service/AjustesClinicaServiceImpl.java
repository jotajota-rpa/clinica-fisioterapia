package com.jotajota.backend.service;

import com.jotajota.backend.dto.AjustesClinicaDto;
import com.jotajota.backend.entity.AjustesClinica;
import com.jotajota.backend.repository.IAjustesClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class AjustesClinicaServiceImpl implements IAjustesClinicaService{

    @Autowired
    private IAjustesClinicaRepository repository;

    @Value("${ruta.storage.root}")
    private String rootPath;

    @Override
    public Optional<AjustesClinica> obtenerAjustes() {
        return repository.findById(1);
    }

    @Override
    public AjustesClinica insertarOactualizarDatos(AjustesClinicaDto dto) {
        AjustesClinica ajustes = repository.findById(1).orElse(new AjustesClinica());

        ajustes.setId(1);
        ajustes.setNombre(dto.getNombre());
        ajustes.setCifNif(dto.getCifNif());
        ajustes.setDireccion(dto.getDireccion());
        ajustes.setTelefono(dto.getTelefono());
        ajustes.setEmail(dto.getEmail());
        ajustes.setSerieFacturacion(dto.getSerieFacturacion());

        return repository.save(ajustes);
    }

    @Override
    public String guardarLogoEnDisco(MultipartFile archivo) throws IOException {
        String nombreLogo = "logo.png";
        Path rutaDestino = Paths.get(rootPath, "ajustes", "imagenes", nombreLogo);

        // Manejo físico del archivo
        Files.createDirectories(rutaDestino.getParent());
        Files.copy(archivo.getInputStream(), rutaDestino, StandardCopyOption.REPLACE_EXISTING);

        // Buscamos el registro, si no existe, lo creamos vacío solo con el ID y la URL
        AjustesClinica ajustes = repository.findById(1).orElse(new AjustesClinica());
        ajustes.setId(1);
        ajustes.setLogoUrl("ajustes/imagenes/" + nombreLogo);

        repository.save(ajustes);

        return ajustes.getLogoUrl();
    }

    @Override
    public boolean existeAjustes(int id) {
        return repository.existsById(id);
    }

}
