import axios from "axios";

export const apiAjustesClinica = axios.create({
    baseURL: "http://localhost:8080/api",
    timeout: 3000,
    headers: {
        'Content-Type': 'application/json'
    }
})