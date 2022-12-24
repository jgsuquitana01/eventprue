package com.example.evaluacion.service

import com.example.evaluacion.model.Register
import com.example.evaluacion.repository.RegisterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class RegisterService {
    @Autowired
    lateinit var registerRepository: RegisterRepository

    fun save (register: Register):Register{
        return registerRepository.save(register)
    }
    fun list ():List<Register>{
        return registerRepository.findAll()
    }

    fun update(register:Register):Register{
        try{
            registerRepository.findById(register.id)
                ?: throw Exception ("El Id no existe")
            return registerRepository.save(register)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(register:Register): Register {
        try{
            val response = registerRepository.findById(register.id)
                ?: throw Exception("ID no existe")
            response.apply {
                cargo=register.cargo
            }
            return registerRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        registerRepository.findById(id) ?:
        throw  Exception()
        registerRepository.deleteById(id!!)
        return true
    }
}