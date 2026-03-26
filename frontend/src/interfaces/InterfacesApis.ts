export interface AjusteClinica {
    id: number
    cifNif: string
    nombre: string
    direccion: string
    telefono: string
    email: string
    logoUrl: string
    serieFacturacion: string
}

export type AjustesClinicaDTO = Omit<AjusteClinica, 'id'> & { id?: number }