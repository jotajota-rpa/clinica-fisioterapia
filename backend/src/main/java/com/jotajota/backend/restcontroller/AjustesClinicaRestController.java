package com.jotajota.backend.restcontroller;

import com.jotajota.backend.dto.AjustesClinicaDto;
import com.jotajota.backend.entity.AjustesClinica;
import com.jotajota.backend.service.IAjustesClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/ajustes")
public class AjustesClinicaRestController {
    @Autowired
    private IAjustesClinicaService service;

    @GetMapping
    private ResponseEntity<AjustesClinica> obtener(){
        // Si existe, devuelve 200 OK con los datos, si no 404
        return service.obtenerAjustes()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/actualizar-datos")
    public ResponseEntity<?> actualizar(@RequestBody AjustesClinicaDto dto) {
        try {
            AjustesClinica resultado = service.actualizarDatos(dto);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PostMapping(value = "/actualizar-logo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> subirLogo(@RequestParam("archivo") MultipartFile archivo) {
        try {
            String rutaImagen = service.actualizarLogo(archivo);

            // Devolvemos un mensaje de éxito con la nueva ruta
            return ResponseEntity.ok().body("Logo actualizado con éxito: " + rutaImagen);

        } catch (IOException e) {
            // Si algo falla con el disco duro, avisamos
            return ResponseEntity.internalServerError().body("Error al guardar el archivo: " + e.getMessage());
        }
    }
}

