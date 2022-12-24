package com.example.evaluacion.service
import com.example.evaluacion.model.Conference
import com.example.evaluacion.model.MemberEvent
import com.example.evaluacion.repository.ConferenceRepository
import com.example.evaluacion.repository.MemberEventRepository
//import com.example.proyectdg.model.Event
//import com.example.proyectdg.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class MemberEventService {
    @Autowired
    lateinit var memberEventRepository: MemberEventRepository
    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

    fun save(memberEvent:MemberEvent): MemberEvent {
        try{
            val response=memberEventRepository.save(memberEvent)
            ?:throw Exception("ID no existe")
            response.apply {
                code =  memberEventRepository.setRandomNumber(memberEvent.code)
            }
            memberEventRepository.save(response)
            //llama a funcion para actualiza
            return response
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


    fun list ():List<MemberEvent>{
        return memberEventRepository.findAll()
    }

    fun listConferences(assistantId:Long?): List<MemberEvent>? {
        return memberEventRepository.listConferences(assistantId)
    }

    fun update(memberEvent:MemberEvent):MemberEvent{
        try{
            memberEventRepository.findById(memberEvent.id)
                ?: throw Exception ("El Id no existe")
            return memberEventRepository.save(memberEvent)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(memberEvent:MemberEvent): MemberEvent {
        try {
            val response = memberEventRepository.findById(memberEvent.id)
                ?: throw Exception("ID no existe")
            response.apply {
                assisted = memberEvent.assisted
            }
            conferenceAttendees(memberEvent)
            return memberEventRepository.save(response)

        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun conferenceAttendees (memberEvent: MemberEvent){
        val totalCalculated = memberEventRepository.sumAttendees(memberEvent.conferenceId)
        val conferenceResponse = conferenceRepository.findById(memberEvent.conferenceId)
        conferenceResponse.apply {
            totalAttendees=totalCalculated
        }
        conferenceRepository.save(conferenceResponse)
    }

    fun delete (id: Long?):Boolean?{
        memberEventRepository.findById(id) ?:
        throw  Exception()
        memberEventRepository.deleteById(id!!)
        return true
    }

}