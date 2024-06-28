$(document).ready(function () {
    // Cargar citas existentes al cargar la página
    loadAppointments();

    // Manejar el envío del formulario de citas
    $('#appointment-form').on('submit', function (e) {
        e.preventDefault();

        const appointmentDate = $('#appointment_date').val();
        const purpose = $('#purpose').val();

        const appointment = {
            appointmentDate: appointmentDate,
            purpose: purpose
        };

        $.ajax({
            url: 'http://localhost:8081/api/appointments',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(appointment),
            success: function (data) {
                alert(data);
                loadAppointments(); // Recargar las citas después de crear una nueva
            },
            error: function (error) {
                alert('Hubo un problema al crear la cita: ' + error.responseText);
            }
        });
    });

    function loadAppointments() {
        $.ajax({
            url: 'http://localhost:8081/api/appointments',
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                console.log(data); // Verificar la respuesta
                if (Array.isArray(data)) {
                    data.forEach(function(appointment) {
                        var row = $('<tr>');
                        row.append($('<td>').text(appointment.appointmentDate));
                        row.append($('<td>').text(appointment.purpose));
                        $('#appointments-table tbody').append(row);
                    });
                } else {
                    console.error("La respuesta no es un arreglo:", data);
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('Hubo un problema al cargar las citas:', errorThrown);
            }
        });

    }
});
