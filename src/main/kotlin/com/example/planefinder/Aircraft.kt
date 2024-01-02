package com.example.planefinder

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Aircraft(
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

    var isOnGround: Boolean

) {

}