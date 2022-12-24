package com.example.evaluacion.controller

import com.example.evaluacion.model.Register
//import com.example.proyectdg.model.Register
import com.example.evaluacion.service.RegisterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/register")

class RegisterController {
    @Autowired
    lateinit var registerService: RegisterService

    @PostMapping
    fun save (@RequestBody @Valid register: Register):Register{
        return registerService.save(register)
    }

    @GetMapping
    fun list ():List<Register>{
        return registerService.list()
    }

    @PutMapping
    fun update (@RequestBody register:Register):ResponseEntity<Register>{
        return ResponseEntity(registerService.update(register), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody register:Register): ResponseEntity<Register>{
        return ResponseEntity(registerService.updateName(register), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return registerService.delete(id)
    }
}