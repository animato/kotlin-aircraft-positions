package com.example.planefinder.mongo

import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux

@EnableScheduling
@Component("mongo-poller")
class PlaneFinderPoller(
    val repository: AircraftMongoRepository
) {
    var client: WebClient = WebClient.create("http://localhost:7634/aircraft")

    @Scheduled(fixedRate = 1000)
    fun pollPlanes() {
        repository.deleteAll()

        client.get()
            .retrieve()
            .bodyToFlux<AircraftMongo>()
            .filter { it.reg.isNotEmpty() }
            .toStream()
            .forEach(repository::save)

        repository.findAll().forEach(::println)
    }
}