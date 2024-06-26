$(document).ready(function () {
    $('#user-form').on('submit', function (e) {
        e.preventDefault();

        const username = $('#username').val();
        const email = $('#email').val();
        const password = $('#password').val();
        const role = $('#role').val();

        const user = {
            username: username,
            email: email,
            password: password,
            role: role
        };

        $.ajax({
            url: '/api/users',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(user),
            success: function (data) {
                alert(data);
            },
            error: function (error) {
                alert('Hubo un problema al crear el usuario: ' + error.responseText);
            }
        });
    });
});
