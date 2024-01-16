package com.example.aircraft.controller

import com.example.aircraft.WebSocketHandler
import com.example.aircraft.jpa.AircraftJpa
import com.example.aircraft.jpa.AircraftJpaRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.TextMessage
import java.util.function.Consumer

@Configuration
class PositionRetriever(
    val repo: AircraftJpaRepository,
    val handler: WebSocketHandler
) {

    @Bean
    fun retrieveAircraftPositions(): Consumer<List<AircraftJpa>> {
        return Consumer<List<AircraftJpa>> {
            repo.deleteAll()
            repo.saveAll(it)
//            repo.findAll().forEach { println() }
            sendPositions()
        }
    }

    private fun sendPositions() {
        if (repo.count() > 0) {
            for (sessionInList in handler.sessionList) {
                sessionInList.sendMessage(TextMessage(repo.findAll().toString()))
            }
        }
    }
}