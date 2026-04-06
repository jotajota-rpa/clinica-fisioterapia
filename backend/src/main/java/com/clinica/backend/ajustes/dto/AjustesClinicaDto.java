package com.clinica.backend.ajustes.dto;

import lombok.Data;

@Data
public class AjustesClinicaDto {

    private String nombre;
    private String cifNif;
    private String direccion;
    private String telefono;
    private String email;
    private String logoUrl;
    private String serieFacturacion;
}
