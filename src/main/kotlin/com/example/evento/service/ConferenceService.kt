package com.example.evaluacion.service

import com.example.evaluacion.model.Conference
import com.example.evaluacion.repository.ConferenceRepository
//import com.example.proyectdg.model.Conference
//import com.example.proyectdg.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class ConferenceService {
    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

    fun save (conference: Conference):Conference{
        return conferenceRepository.save(conference)
    }
    fun list ():List<Conference>{
        return conferenceRepository.findAll()
    }

    fun update(conference:Conference):Conference{
        try{
            conferenceRepository.findById(conference.id)
                ?: throw Exception ("El Id no existe")
            return conferenceRepository.save(conference)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(conference:Conference): Conference {
        try{
            val response = conferenceRepository.findById(conference.id)
                ?: throw Exception("ID no existe")
            response.apply {
                speaker=conference.speaker
            }
            return conferenceRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        conferenceRepository.findById(id) ?:
        throw  Exception()
        conferenceRepository.deleteById(id!!)
        return true
    }
}