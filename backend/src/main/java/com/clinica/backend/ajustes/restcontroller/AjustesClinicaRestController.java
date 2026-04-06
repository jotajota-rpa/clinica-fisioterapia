package com.clinica.backend.ajustes.restcontroller;

import com.clinica.backend.ajustes.dto.AjustesClinicaDto;
import com.clinica.backend.ajustes.entity.AjustesClinica;
import com.clinica.backend.ajustes.service.IAjustesClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/save-or-update")
    public ResponseEntity<?> actualizar(@RequestBody AjustesClinicaDto dto) {
        try {
            boolean yaExistia = service.existeAjustes(1);
            AjustesClinica resultado = service.insertarOactualizarDatos(dto);

            if (!yaExistia) {
                return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
            }

            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            System.err.println("Error crítico guardando los datos: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo procesar los datos. Inténtelo de nuevo.");
        }
    }

    @PostMapping(value = "/update-logo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> subirLogo(@RequestParam(value = "archivo", required = false) MultipartFile archivo) {
        try {
            if (archivo == null || archivo.isEmpty()) {
                return ResponseEntity.badRequest().body("No se ha seleccionado ningún archivo.");
            }

            String rutaImagen = service.guardarLogoEnDisco(archivo);
            return ResponseEntity.ok().body("Logo actualizado con éxito: " + rutaImagen);

        } catch (IOException e) {
            System.err.println("Error crítico guardando la imagén: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo procesar la imagén. Inténtelo de nuevo.");
        }
    }
}

