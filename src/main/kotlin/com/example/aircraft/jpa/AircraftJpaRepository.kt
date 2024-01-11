package com.example.aircraft.jpa

import org.springframework.data.repository.CrudRepository

interface AircraftJpaRepository: CrudRepository<AircraftJpa, Long> {
}