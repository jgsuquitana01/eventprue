package com.example.evaluacion.controller

import com.example.evaluacion.model.Conference
//import com.example.proyectdg.model.Conference
import com.example.evaluacion.service.ConferenceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/conference")

class ConferenceController {
    @Autowired
    lateinit var conferenceService: ConferenceService

    @PostMapping
    fun save (@RequestBody @Valid conference: Conference):Conference{
        return conferenceService.save(conference)
    }

    @GetMapping
    fun list ():List<Conference>{
        return conferenceService.list()
    }

    @PutMapping
    fun update (@RequestBody conference:Conference):ResponseEntity<Conference>{
        return ResponseEntity(conferenceService.update(conference), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody conference:Conference): ResponseEntity<Conference>{
        return ResponseEntity(conferenceService.updateName(conference), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return conferenceService.delete(id)
    }
}