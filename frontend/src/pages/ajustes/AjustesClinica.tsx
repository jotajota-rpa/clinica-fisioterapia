import { useParams, useNavigate } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { apiAjustesClinica } from '../../services/Axios';
import type { AjustesClinicaDTO } from '../../interfaces/InterfacesApis';
import { FormField } from '../../components/forms/FormField';

function AjustesClinica() {
    return (
        <form className="p-10 flex flex-col items-center bg-gray-50 min-h-screen">
          <div className="w-full max-w-lg bg-white p-8 rounded-2xl shadow-xl border border-gray-100">
            <h1 className="text-2xl font-bold text-gray-800 mb-6">Configuración</h1>

            {/* Contenedor para dar espacio entre los campos */}
            <div className="flex flex-col gap-2">
              <FormField label="CIF / NIF" placeholder="Introduce el CIF..." />
              <FormField label="Nombre Clínica" placeholder="Ej: Fisioterapia Relax" />
            </div>

            <button
              type="submit"
              className="w-full mt-8 bg-green-600 text-white py-3 px-6 rounded-lg font-semibold hover:bg-green-700 active:transform active:scale-[0.98] transition-all shadow-md shadow-green-100"
            >
              Guardar Ajustes
            </button>
          </div>
        </form>
    )
 }

export default AjustesClinica