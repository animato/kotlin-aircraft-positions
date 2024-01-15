package com.example.aircraft.controller

import com.example.aircraft.jpa.AircraftJpaRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PositionController(val repository: AircraftJpaRepository) {

    @GetMapping("/aircraft")
    fun getCurrentAircraftPositions(model: Model): String {
        model.addAttribute("currentPositions", repository.findAll())
        return "positions"
    }
}