package com.example.planefinder.neo4j

import org.springframework.data.repository.CrudRepository

interface AircraftNeo4jRepository: CrudRepository<AircraftNeo4j, Long> {
}