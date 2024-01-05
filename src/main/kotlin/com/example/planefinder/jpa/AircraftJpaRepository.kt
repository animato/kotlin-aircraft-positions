package com.example.planefinder.jpa

import org.springframework.data.repository.CrudRepository

interface AircraftJpaRepository: CrudRepository<AircraftJpa, Long> {
}