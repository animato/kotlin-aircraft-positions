package com.example.planefinder.mongo

import org.springframework.data.repository.CrudRepository

interface AircraftMongoRepository: CrudRepository<AircraftMongo, Long> {
}