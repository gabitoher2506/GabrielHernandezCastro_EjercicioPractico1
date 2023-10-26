function editarEstudiante(id) {
    window.location.href = '/estudiantes/editar/' + id;
}

// Función para confirmar y luego redireccionar para eliminar el estudiante
function eliminarEstudiante(id) {
    if (confirm('¿Estás seguro de que deseas eliminar este estudiante?')) {
        // Si el usuario confirma, redirecciona para eliminar el estudiante
        window.location.href = '/estudiantes/eliminar/' + id;
    }
}