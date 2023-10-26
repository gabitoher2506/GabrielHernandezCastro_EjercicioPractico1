package com.EjercicioPractico1.Controller;

import com.EjercicioPractico1.Domain.Estudiantes;
import com.EjercicioPractico1.Service.EstudiantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudiantesService estudiantesService;

    @GetMapping("/lista")
    public String listarEstudiantes(Model model) {
        List<Estudiantes> estudiantes = estudiantesService.listarEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "lista-estudiantes"; // Nombre de la vista Thymeleaf
    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("estudiante", new Estudiantes());
        return "formulario-crear-estudiante"; // Nombre de la vista Thymeleaf
    }

    @PostMapping("/crear")
    public String crearEstudiante(@ModelAttribute Estudiantes estudiante) {
        estudiantesService.crearEstudiante(estudiante);
        return "redirect:/estudiantes/lista";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Estudiantes estudiante = estudiantesService.obtenerEstudiantePorId(id);
        model.addAttribute("estudiante", estudiante);
        return "formulario-editar-estudiante"; // Nombre de la vista Thymeleaf
    }

    @PostMapping("/editar/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute Estudiantes estudiante) {
        estudiantesService.actualizarEstudiante(id, estudiante);
        return "redirect:/estudiantes/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudiantesService.eliminarEstudiante(id);
        return "redirect:/estudiantes/lista";
    }
}
