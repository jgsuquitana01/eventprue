package com.example.evaluacion.controller

import com.example.evaluacion.model.Event
//import com.example.proyectdg.model.Event
import com.example.evaluacion.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/event")

class EventController {
    @Autowired
    lateinit var eventService: EventService

    @PostMapping
    fun save (@RequestBody @Valid event: Event):Event{
        return eventService.save(event)
    }

    @GetMapping
    fun list ():List<Event>{
        return eventService.list()
    }

    @PutMapping
    fun update (@RequestBody event:Event):ResponseEntity<Event>{
        return ResponseEntity(eventService.update(event), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody event:Event): ResponseEntity<Event>{
        return ResponseEntity(eventService.updateName(event), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return eventService.delete(id)
    }
}