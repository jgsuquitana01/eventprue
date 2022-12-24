package com.example.evaluacion.controller

import com.example.evaluacion.model.MemberEvent
//import com.example.proyectdg.model.MemberEvent
import com.example.evaluacion.service.MemberEventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/member_event")

class MemberEventController {
    @Autowired
    lateinit var memberEventService: MemberEventService

    @PostMapping
    fun save (@RequestBody @Valid memberEvent: MemberEvent):MemberEvent{
        return memberEventService.save(memberEvent)
    }

    @GetMapping("/conferences/{assistantId}")
    fun listConferences (@PathVariable("assistantId") assistantId: Long ):ResponseEntity<*>{
        return ResponseEntity(memberEventService.listConferences(assistantId), HttpStatus.OK)
    }

    @GetMapping
    fun list ():List<MemberEvent>{
        return memberEventService.list()
    }

    @PutMapping
    fun update (@RequestBody memberEvent:MemberEvent):ResponseEntity<MemberEvent>{
        return ResponseEntity(memberEventService.update(memberEvent), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody memberEvent:MemberEvent): ResponseEntity<MemberEvent>{
        return ResponseEntity(memberEventService.updateName(memberEvent), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return memberEventService.delete(id)
    }
}