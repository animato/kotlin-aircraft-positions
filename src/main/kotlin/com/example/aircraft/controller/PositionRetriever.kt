package com.example.aircraft.controller

import com.example.aircraft.jpa.AircraftJpa
import com.example.aircraft.jpa.AircraftJpaRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Consumer

@Configuration
class PositionRetriever(val repo: AircraftJpaRepository) {

    @Bean
    fun retrieveAircraftPositions(): Consumer<List<AircraftJpa>> {
        return Consumer<List<AircraftJpa>> {
            repo.deleteAll()
            repo.saveAll(it)
            repo.findAll().forEach { println() }
        }
    }
}