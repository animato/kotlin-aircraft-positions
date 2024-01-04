package com.example.planefinder

import org.springframework.data.repository.CrudRepository

interface AircraftRepository: CrudRepository<Aircraft, Long> {
}