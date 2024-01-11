package com.example.aircraft.mongo

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@Document
data class AircraftMongo(
    @Id
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