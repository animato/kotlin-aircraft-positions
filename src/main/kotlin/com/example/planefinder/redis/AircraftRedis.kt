package com.example.planefinder.redis

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.time.Instant

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@RedisHash
data class AircraftRedis(
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