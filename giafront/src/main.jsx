import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import MaterialList from "./pages/MaterialList.jsx";
import SupplierList from "./pages/SupplierList.jsx";
import MaterialForm from "./pages/MaterialForm.jsx";

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<MaterialList />} />
            <Route path={"/materials"} element={<MaterialList />} />
            <Route path={"/materials/:id"} element={<MaterialList />} />
            <Route path={"/materials/new"} element={<MaterialForm />} />
            <Route path={"/materials/:id/edit"} element={<MaterialForm />} />
            <Route path={"/materials/:id/delete"} element={<MaterialList />} />
            <Route path={"/materials/supplier/:supplierId"} element={<MaterialList />} />
            <Route path={"/suppliers"} element={<SupplierList />} />
        </Routes>
    </BrowserRouter>
  </StrictMode>,
)
