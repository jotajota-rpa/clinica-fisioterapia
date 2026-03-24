import { useParams, useNavigate } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { apiAjustesClinica } from '../../services/Axios';
import type { AjustesClinicaDTO } from '../../interfaces/InterfacesApis';
import { FormField } from '../../components/forms/FormField';

function AjustesClinica() {

    return (
        <div className="flex h-screen w-full items-center justify-center bg-gray-100 min-w-[300px]">
        <form className="flex flex-col items-center justify-center bg-white rounded-2xl shadow-xl shadow-black/50 w-full max-w-md p-10">
            <h1 className="font-bold p-4 m-2 text-xl text-center">Configuración Ajustes Clínica</h1>

            <FormField label="CIF / NIF" placeholder="Introduce el CIF..." />
            <FormField label="Nombre Clínica" placeholder="Ej: Fisioterapia Relax" />
            <FormField label="Dirección" placeholder="Ej: Calle Júpiter" />
            <FormField label="Teléfono" placeholder="900112233" />
            <FormField label="Correo Eléctronico" placeholder="clinica@email.com" />
            <FormField label="Serie de Facturación" placeholder="FXX" />


            <button className="bg-green-500 text-white font-bold m-2 py-3 px-5 rounded-xl shadow-md transition-all duration-300 ease-in-out hover:bg-gray-900 hover:shadow-black/40 active:scale-95 active:shadow-inner">
              Guardar Ajustes
            </button>
        </form>
        </div>
    )
}

export default AjustesClinica