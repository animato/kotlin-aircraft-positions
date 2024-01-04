package com.example.planefinder

import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux

@EnableScheduling
@Component
class PlaneFinderPoller(
    val connectionFactory: RedisConnectionFactory,
    val repository: AircraftRepository
) {
    var client: WebClient = WebClient.create("http://localhost:7634/aircraft")

    @Scheduled(fixedRate = 1000)
    fun pollPlanes() {
        connectionFactory.connection.serverCommands().flushDb()

        client.get()
            .retrieve()
            .bodyToFlux<Aircraft>()
            .filter { p -> p.reg.isNotEmpty() }
            .toStream()
            .forEach(repository::save)

        repository.findAll().forEach(::println)
    }
}