import React, { useState } from 'react';
import {getMaterials, getMaterial,deleteMaterial,getMaterialsBySupplier} from "../api/materialsApi";
import { useNavigate } from "react-router-dom";


export default function MaterialList() {

    const navigate = useNavigate();

    const path = window.location.pathname;
    const idMatch = path.match(/\/materials\/(\d+)/);
    const deleteMatch = path.match(/\/materials\/(\d+)\/delete/);
    const supplierMatch = path.match(/\/materials\/supplier\/(\d+)/);
    const id = idMatch ? idMatch[1] : null;

    const [materials, setMaterials] = useState([]);
    const [error, setError] = useState(null);

    if(supplierMatch) {
        getMaterialsBySupplier(supplierMatch[1]).then(setMaterials).catch(e => setError(e.message));
    }else {

        if (deleteMatch) {
            deleteMaterial(deleteMatch[1]).then(() => {
                navigate("/materials");
            }).catch(e => setError(e.message));

            if (id) {
                getMaterial(id).then(material => setMaterials([material])).catch(e => setError(e.message));
            } else {
                getMaterials().then(setMaterials).catch(e => setError(e.message));
            }

        }
    }

    return (
        <div className="MaterialList">
            <h1>Material List</h1>
            {error && <div className="error" style={{color: 'red', marginBottom: '1em'}}>{error}</div>}
            <button onClick={() => {navigate("/materials/new")}}>Create New Material</button>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>materialType</th>
                    <th>Unit Price</th>
                    <th>Quantity in stock</th>
                    <th>Min quantity</th>
                    <th>Quantity in package</th>
                    <th>Measurement</th>
                </tr>
                </thead>
                <tbody>
                {materials.map(material => (
                    <tr key={material.id}>
                        <td>{material.id}</td>
                        <td>{material.name}</td>
                        <td>{material.materialType}</td>
                        <td>{material.unitPrice}</td>
                        <td>{material.quantityInStock}</td>
                        <td>{material.minQuantity}</td>
                        <td>{material.quantityInPackage}</td>
                        <td>{material.measurement}</td>
                        <td>
                            <button onClick={() => {navigate(`/materials/${material.id}/edit`)}}>Edit</button>
                            <button onClick={() => {navigate(`/materials/${material.id}/delete`)}}>Delete</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}
