package com.example.planefinder.neo4j

import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux

@EnableScheduling
@Component("neo4j-poller")
class PlaneFinderPoller(
    val repository: AircraftNeo4jRepository
) {
    var client: WebClient = WebClient.create("http://localhost:7634/aircraft")

    @Scheduled(fixedRate = 1000)
    fun pollPlanes() {
        repository.deleteAll()

        client.get()
            .retrieve()
            .bodyToFlux<AircraftNeo4j>()
            .filter { p -> p.reg.isNotEmpty() }
            .toStream()
            .forEach(repository::save)

        repository.findAll().forEach(::println)
    }
}