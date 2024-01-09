package com.example.planefinder.neo4j

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import java.time.Instant

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@Node
data class AircraftNeo4j(
    @Id
    @GeneratedValue
    var neoId: Long, // Neo4j는 엔티티에 이미 고유 식별자가 있더라도 데이터베이스에서 생성한 고유 식별자가 필요함

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