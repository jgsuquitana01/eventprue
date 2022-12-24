package com.example.evaluacion.model

import java.sql.Time
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name="conference")

class Conference {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotNull
    @NotBlank
    var tittle: String? = null
    @NotNull
    var speaker: String?=null
    @NotNull
    var hours: Time?=null
    @Column (name="total_attendees")
    var totalAttendees: Long?=null
    @Column(name="event_id")
    @NotNull
    var eventId: Long?=null
}