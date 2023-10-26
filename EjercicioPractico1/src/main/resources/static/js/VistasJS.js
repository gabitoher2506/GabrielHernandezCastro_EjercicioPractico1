function eliminarEstudiante(id) {
    if (confirm("¿Estás seguro de que deseas eliminar este estudiante?")) {
        $.ajax({
            type: "GET",
            url: "/estudiantes/eliminar/" + id,
            success: function () {
                location.reload(); 
            },
            error: function () {
                alert("Error al eliminar al estudiante.");
            }
        });
    }
}

function editarEstudiante(id) {
    $.ajax({
        type: "GET",
        url: "/estudiantes/editar/" + id,
        success: function (data) {
            $('#nombre').val(data.nombre);
            $('#identificacion').val(data.identificacion);
            $('#nivelCursado').val(data.nivelCursado);
            $('#edad').val(data.edad);
            $('#altura').val(data.altura);
            $('#peso').val(data.peso);
            $('#genero').val(data.genero);
        },
        error: function () {
            alert("Error al cargar los datos del estudiante para editar.");
        }
    });
}