package com.example.aircraft

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories

@SpringBootApplication
class AircraftApplication

fun main(args: Array<String>) {
    runApplication<AircraftApplication>(*args)
}

@Configuration
@EnableNeo4jRepositories(basePackages = ["com.example.aircraft.neo4j"])
@EnableMongoRepositories(basePackages = ["com.example.aircraft.mongo"])
@EnableJpaRepositories(basePackages = ["com.example.aircraft.jpa"])
@EnableRedisRepositories(basePackages = ["com.example.aircraft.redis"])
class Configuration {

}
