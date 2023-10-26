package com.EjercicioPractico1.Controller;

import com.EjercicioPractico1.Domain.Estudiantes;
import com.EjercicioPractico1.Service.EstudiantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudiantesService estudiantesService;

    // Listar todos los estudiantes
    @GetMapping("/lista")
    public String listarEstudiantes(Model model) {
        List<Estudiantes> estudiantes = estudiantesService.listarEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "lista-estudiantes"; // Nombre de la vista Thymeleaf
    }

    // Mostrar el formulario de creación de estudiante
    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("estudiante", new Estudiantes());
        return "formulario-crear-estudiante"; // Nombre de la vista Thymeleaf
    }

    // Procesar el formulario de creación de estudiante
    @PostMapping("/crear")
    public String crearEstudiante(@ModelAttribute Estudiantes estudiante) {
        estudiantesService.crearEstudiante(estudiante);
        return "redirect:/estudiantes/lista";
    }

    // Mostrar el formulario de edición de estudiante
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Estudiantes estudiante = estudiantesService.obtenerEstudiantePorId(id);
        model.addAttribute("estudiante", estudiante);
        return "formulario-editar-estudiante"; // Nombre de la vista Thymeleaf
    }

    // Procesar el formulario de edición de estudiante
    @PostMapping("/editar/{id}")
    public String editarEstudiante(@PathVariable Long id, @ModelAttribute Estudiantes estudiante) {
        estudiantesService.actualizarEstudiante(id, estudiante);
        return "redirect:/estudiantes/lista";
    }

    // Eliminar un estudiante
    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudiantesService.eliminarEstudiante(id);
        return "redirect:/estudiantes/lista";
    }
}
