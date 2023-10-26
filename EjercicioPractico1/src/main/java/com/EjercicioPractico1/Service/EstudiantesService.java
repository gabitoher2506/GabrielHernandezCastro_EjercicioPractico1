/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EjercicioPractico1.Service;

import com.EjercicioPractico1.Domain.Estudiantes;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface EstudiantesService {

    List<Estudiantes> listarEstudiantes();

    Estudiantes obtenerEstudiantePorId(Long id);

    Estudiantes crearEstudiante(Estudiantes estudiantes);

    Estudiantes actualizarEstudiante(Long id, Estudiantes estudiantes);

    void eliminarEstudiante(Long id);

}
