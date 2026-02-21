


async function request(path, options = {}) {
    const response = await fetch(`http://localhost:8080/api${path}`, {
        headers: {
            'Content-Type': 'application/json',
        },
        ...options,
    });
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }
    return response.json();



}


export default { request }