package com.example.aircraft.controller

import com.example.aircraft.jpa.AircraftJpa
import com.example.aircraft.jpa.AircraftJpaRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux

@Controller
class PositionController(val repository: AircraftJpaRepository) {
    var client: WebClient = WebClient.create("http://localhost:7634/aircraft")

    @GetMapping("/aircraft")
    fun getCurrentAircraftPositions(model: Model): String {
        repository.deleteAll()

        client.get()
            .retrieve()
            .bodyToFlux<AircraftJpa>()
            .filter { p -> p.reg.isNotEmpty() }
            .toStream()
            .forEach { repository.save(it) }

        model.addAttribute("currentPositions", repository.findAll())
        return "positions"
    }
}