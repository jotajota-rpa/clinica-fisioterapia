import { useParams, useNavigate } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { apiAjustesClinica } from '../../services/Axios';
import type { AjustesClinicaDTO } from '../../interfaces/InterfacesApis';
import { FormField } from '../../components/forms/FormField';

function AjustesClinica() {
    return (
        <form className="">
            <h1>Configuración</h1>

            <FormField label="Caaa / NIF" placeholder="Introduce el CIF..." />
            <FormField label="Nombre Clínica" placeholder="Ej: Fisioterapia Relax" />


            <button type="submit">
              Guardar Ajustes
            </button>
        </form>
    )
 }

export default AjustesClinica