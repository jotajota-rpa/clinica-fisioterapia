package com.jotajota.backend.service;

import com.jotajota.backend.dto.AjustesClinicaDto;
import com.jotajota.backend.entity.AjustesClinica;
import com.jotajota.backend.repository.IAjustesClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public AjustesClinica actualizarDatos(AjustesClinicaDto dto) {
        AjustesClinica ajustes = repository.findById(1).orElse(new AjustesClinica());

        ajustes.setId(1);
        ajustes.setNombreComercial(dto.getNombreComercial());
        ajustes.setCifNif(dto.getCifNif());
        ajustes.setDireccion(dto.getDireccion());
        ajustes.setTelefono(dto.getTelefono());
        ajustes.setEmail(dto.getEmail());
        ajustes.setSerieFacturacion(dto.getSerieFacturacion());

        return repository.save(ajustes);
    }

    @Override
    public String actualizarLogo(MultipartFile archivo) throws IOException {
        String nombreLogo = "logo.png";
        // Obtenemos la ruta relativa
        Path rutaDestino = Paths.get(rootPath, "ajustes", "imagenes", nombreLogo);

        // Traemos el unico registro que hay
        AjustesClinica ajustes = repository.findById(1).orElseThrow(() -> new RuntimeException("No hay ajustes"));

        // Se crea el directorio si no lo hay por defecto
        // Copia la imagen a la carpeta sustituyendola si ya la hay
        Files.createDirectories(rutaDestino.getParent());
        Files.copy(archivo.getInputStream(), rutaDestino, StandardCopyOption.REPLACE_EXISTING);

        // Guardamos la ruta en la bbdd
        ajustes.setLogoUrl("ajustes/imagenes/" + nombreLogo);
        repository.save(ajustes);

        return ajustes.getLogoUrl();
    }

}
