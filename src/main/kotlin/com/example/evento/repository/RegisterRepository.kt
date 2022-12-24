package com.example.evaluacion.repository

import com.example.evaluacion.model.Register
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface RegisterRepository:JpaRepository<Register, Long?> {
    fun findById(id:Long?):Register?
}