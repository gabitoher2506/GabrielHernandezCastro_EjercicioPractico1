/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EjercicioPractico1.Controller;
import com.EjercicioPractico1.Domain.Estudiantes;
import com.EjercicioPractico1.Service.EstudiantesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    // Inyecta el servicio de estudiantes
    private final EstudiantesService estudianteService;

    public EstudianteController(EstudiantesService estudianteService) {
        this.estudianteService = estudianteService;
    }

    // Manejar la solicitud para mostrar la lista de estudiantes
    @GetMapping("/")
    public String listarEstudiantes(Model model) {
        List<Estudiantes> estudiantes = estudianteService.listarEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "estudiantes/lista"; // Nombre de la vista para mostrar la lista de estudiantes
    }

    // Manejar la solicitud para mostrar el formulario de creación de un nuevo estudiante
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        Estudiantes estudiante = new Estudiantes();
        model.addAttribute("estudiante", estudiante);
        return "estudiantes/formulario"; // Nombre de la vista para el formulario de creación
    }

    // Manejar la solicitud para guardar un nuevo estudiante
    @PostMapping("/nuevo")
    public String crearEstudiante(@ModelAttribute("estudiante") Estudiantes estudiante) {
        estudianteService.crearEstudiante(estudiante);
        return "redirect:/estudiantes/"; // Redirige a la lista de estudiantes después de guardar
    }

    // Manejar la solicitud para mostrar el formulario de edición de un estudiante
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Estudiantes estudiante = estudianteService.obtenerEstudiantePorId(id);
        model.addAttribute("estudiante", estudiante);
        return "estudiantes/formulario"; // Nombre de la vista para el formulario de edición
    }

    // Manejar la solicitud para actualizar un estudiante
    @PostMapping("/editar/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiantes estudiante) {
        estudianteService.actualizarEstudiante(id, estudiante);
        return "redirect:/estudiantes/"; // Redirige a la lista de estudiantes después de actualizar
    }

    // Manejar la solicitud para eliminar un estudiante
    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return "redirect:/estudiantes/"; // Redirige a la lista de estudiantes después de eliminar
    }
}
