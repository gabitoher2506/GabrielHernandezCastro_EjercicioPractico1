
package com.EjercicioPractico1.Service.impl;

import com.EjercicioPractico1.DAO.EstudiantesDao;
import com.EjercicioPractico1.Domain.Estudiantes;
import com.EjercicioPractico1.Service.EstudiantesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EstudiantesServiceImpl implements EstudiantesService {

    @Autowired
    private EstudiantesDao estudiantesDao;

    @Override
    public List<Estudiantes> listarEstudiantes() {
        return estudiantesDao.findAll();
    }

    @Override
    public Estudiantes obtenerEstudiantePorId(Long id) {
        return estudiantesDao.findById(id).orElse(null);
    }

    @Override
    public Estudiantes crearEstudiante(Estudiantes estudiantes) {
        return estudiantesDao.save(estudiantes);
    }

    @Override
    public Estudiantes actualizarEstudiante(Long id, Estudiantes estudiantes) {
        if (estudiantesDao.existsById(id)) {
            estudiantes.setId(id);
            return estudiantesDao.save(estudiantes);
        }
        return null;
    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudiantesDao.deleteById(id);
    }
}
