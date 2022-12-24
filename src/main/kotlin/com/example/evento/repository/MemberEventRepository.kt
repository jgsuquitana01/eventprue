package com.example.evaluacion.repository

import com.example.evaluacion.model.MemberEvent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository

interface MemberEventRepository:JpaRepository<MemberEvent, Long?> {
    fun findById(id:Long?):MemberEvent
    @Query(nativeQuery = true)
    fun setRandomNumber(@Param("code") code: Long?):Long?

    @Query(nativeQuery =true)//Va a leer jpa-named.....
    fun sumAttendees(@Param ("conferenceId") conferenceId: Long?): Long?

    @Query(nativeQuery =true)//Va a leer jpa-named.....
    fun listConferences(@Param ("assistantId") assistantId: Long?): List<MemberEvent>?
}