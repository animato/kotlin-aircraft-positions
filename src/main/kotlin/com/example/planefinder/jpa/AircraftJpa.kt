package com.example.planefinder.jpa

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.Instant

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@Entity
data class AircraftJpa(
    @Id
    @GeneratedValue
    var id: Long,
    var callsign: String,
    var squawk: String,
    var reg: String,
    var flightno: String,
    var route: String,
    var type: String,
    var category: String,
    var altitude: Int,
    var heading: Int,
    var speed: Int,

    var vertRate: Int,
    var selectedAltitude: Int,

    var isOnGround: Boolean,
    var lastSeenTime: Instant

) {

}