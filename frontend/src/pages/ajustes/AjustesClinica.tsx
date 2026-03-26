import React, { useEffect, useState } from 'react';
import { apiAjustesClinica } from '../../services/Axios';
import type { AjustesClinicaDTO } from '../../interfaces/InterfacesApis';
import { FormField } from '../../components/forms/FormField';


function AjustesClinica() {
    const ajustesIniciales: AjustesClinicaDTO = {
        id: 1,
        cifNif: '',
        nombre: '',
        direccion: '',
        telefono: '',
        email: '',
        logoUrl: '',
        serieFacturacion: ''
    } as AjustesClinicaDTO

    const [ajustes, setAjustes] = useState<AjustesClinicaDTO>(ajustesIniciales)

    useEffect(() => {
        const cargarAjustes = async () => {

            try {
                const { data } = await apiAjustesClinica.get('/ajustes')
                setAjustes(data || ajustesIniciales)
            } catch (err) {
                console.error('Error cargando local:', err)
                setAjustes(ajustesIniciales)
            }
        }
        cargarAjustes()
    }, [])

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target
        setAjustes({
            ...ajustes,
            [name]: value
        } as AjustesClinicaDTO)
    }

    const handleSubmit = async (e: React.BaseSyntheticEvent) => {
        e.preventDefault()
        const metodo = ajustes.id ? 'put' : 'post'

        try {
            await apiAjustesClinica[metodo]('/ajustes/save-or-update', ajustes)
            alert('Guardado correctamente')
        } catch (error) {
            console.error(error)
        }
    }

    return (
        <div className="flex h-screen items-center justify-center min-w-75">
            <div className="flex flex-col items-center rounded-2xl max-w-md">
                <h1 className="font-bold p-4 text-xl text-center">Configuración Ajustes Clínica</h1>

                <FormField label="CIF / NIF" name="cifNif" placeholder="Introduce el CIF..." value={ajustes.cifNif} onChange={handleChange}/>
                <FormField label="Nombre Clínica" name= "nombre" placeholder="Ej: Fisioterapia Relax" value={ajustes.nombre} onChange={handleChange}/>
                <FormField label="Dirección" name="direccion" placeholder="Ej: Calle Júpiter" value={ajustes.direccion} onChange={handleChange}/>
                <FormField label="Teléfono" name="telefono" placeholder="900112233" value={ajustes.telefono} onChange={handleChange}/>
                <FormField label="Correo Eléctronico" name="email" placeholder="clinica@email.com" value={ajustes.email} onChange={handleChange}/>
                <FormField label="Serie de Facturación" name="serieFacturacion" placeholder="FXX" value={ajustes.serieFacturacion} onChange={handleChange}/>


                <button type='button' onClick={handleSubmit}
                    className="bg-green-500 text-white font-bold m-2 py-3 px-5 rounded-xl shadow-md transition-all duration-300 ease-in-out hover:bg-gray-900 hover:shadow-black/40 active:scale-95 active:shadow-inner">
                    Guardar Ajustes
                </button>
            </div>
        </div>
    )
}

export default AjustesClinica