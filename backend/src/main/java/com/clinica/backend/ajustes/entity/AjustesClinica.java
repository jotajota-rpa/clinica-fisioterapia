package com.clinica.backend.ajustes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "ajustes_clinica")
public class AjustesClinica {

    @Id
    private int id = 1;

    @Size(max = 100)
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Size(max = 20)
    @Column(name = "cif_nif", nullable = false)
    private String cifNif;

    @Size(max = 255)
    private String direccion;

    @Size(max = 20)
    private String telefono;

    @Size(max = 100)
    private String email;

    @Size(max = 500)
    @Column(name = "logo_url")
    private String logoUrl;

    @Size(max = 20)
    @Column(name = "serie_facturacion")
    private String serieFacturacion = "F26";
}
