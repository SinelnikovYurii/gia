import api from './clientApi';

async function getMaterials() {
    return api.request('/materials');
}

async function getMaterial(id) {
    return api.request(`/materials/${id}`);
}

async function createMaterial(material) {
    return api.request('/materials', {
        method: 'POST',
        body: JSON.stringify(material),
    });
}

async function updateMaterial(id, material) {
    return api.request(`/materials/${id}`, {
        method: 'PUT',
        body: JSON.stringify(material),
    });
}

async function deleteMaterial(id) {
    return api.request(`/materials/${id}`, {
        method: 'DELETE',
    });
}

async function getMaterialsBySupplier(supplierId) {
    return api.request(`/materials/supplier/${supplierId}`);
}

export {
    getMaterials,
    getMaterial,
    createMaterial,
    updateMaterial,
    deleteMaterial,
    getMaterialsBySupplier
};
