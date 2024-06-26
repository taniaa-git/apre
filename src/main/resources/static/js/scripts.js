document.getElementById('user-form').addEventListener('submit', function (e) {
    e.preventDefault();

    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const role = document.getElementById('role').value;

    const user = {
        username: username,
        email: email,
        password: password,
        role: role
    };

    fetch('/api/users/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        return response.json();
    })
    .then(data => {
        alert('Usuario creado correctamente: ' + data.username);
    })
    .catch(error => {
        alert('Hubo un problema con la creación del usuario: ' + error.message);
    });
});
