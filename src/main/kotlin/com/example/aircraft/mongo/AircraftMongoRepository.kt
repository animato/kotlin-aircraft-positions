package com.example.aircraft.mongo

import org.springframework.data.repository.CrudRepository

interface AircraftMongoRepository: CrudRepository<AircraftMongo, Long> {
}