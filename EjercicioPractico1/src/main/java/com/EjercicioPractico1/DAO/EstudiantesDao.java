/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EjercicioPractico1.DAO;

import com.EjercicioPractico1.Domain.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiantesDao extends JpaRepository<Estudiantes, Long> {
    // No es necesario agregar métodos aquí, heredarás los métodos CRUD de JpaRepository
}