$(document).ready(function () {
    // Cargar citas existentes al cargar la página
    loadAppointments();

    // Manejar el envío del formulario de citas
    $('#appointment-form').on('submit', function (e) {
        e.preventDefault();

        const userId = $('#user_id').val();
        const appointmentDate = $('#appointment_date').val();
        const purpose = $('#purpose').val();

        const appointment = {
            user_id: userId,
            appointment_date: appointmentDate,
            purpose: purpose
        };

        $.ajax({
            url: '/api/appointments',
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
            url: '/api/appointments',
            type: 'GET',
            success: function (data) {
                const appointmentsTable = $('#appointments-table tbody');
                appointmentsTable.empty();

                data.forEach(function (appointment) {
                    const row = `<tr>
                                    <td>${appointment.id}</td>
                                    <td>${appointment.user_id}</td>
                                    <td>${appointment.appointment_date}</td>
                                    <td>${appointment.purpose}</td>
                                </tr>`;
                    appointmentsTable.append(row);
                });
            },
            error: function (error) {
                alert('Hubo un problema al cargar las citas: ' + error.responseText);
            }
        });
    }
});