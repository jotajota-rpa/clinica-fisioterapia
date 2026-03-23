import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css'
import AjustesClinica from './pages/ajustes/AjustesClinica';

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
            <Route path="/" element={<AjustesClinica />} />
        </Routes>
    </BrowserRouter>

    </>
  )
}

export default App
