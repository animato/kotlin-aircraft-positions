package com.example.aircraft.jpa

import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@EnableScheduling
@Component("jpa-poller")
class PlaneFinderPoller(
    val repository: AircraftJpaRepository
) {
    var client: WebClient = WebClient.create("http://localhost:7634/aircraft")

//    @Scheduled(fixedRate = 1000)
    fun pollPlanes() {

//        client.get()
//            .retrieve()
//            .bodyToFlux<AircraftJpa>()
//            .filter { p -> p.reg.isNotEmpty() }
//            .toStream()
//            .forEach(repository::save)

        repository.findAll().forEach(::println)
    }
}