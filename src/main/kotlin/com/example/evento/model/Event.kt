package com.example.evaluacion.model

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name="event")

class Event {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotNull
    @NotBlank
    var description: String? = null
    @Column(name="start_date")
    @NotNull
    var startDate: Date?=null
    @Column(name="end_date")
    @NotNull
    var endDate: Date?=null
    @NotNull
    var city: String?=null
    @Column (name="total_attendees")
    var totalAttendees: Long?=null
}