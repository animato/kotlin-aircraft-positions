package com.example.planefinder

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@SpringBootApplication
class PlanefinderApplication

fun main(args: Array<String>) {
    runApplication<PlanefinderApplication>(*args)
}

@Configuration
@EnableNeo4jRepositories(basePackages = ["com.example.planefinder.neo4j"])
@EnableMongoRepositories(basePackages = ["com.example.planefinder.mongo"])
@EnableJpaRepositories(basePackages = ["com.example.planefinder.jpa"])
@EnableRedisRepositories(basePackages = ["com.example.planefinder.redis"])
class Configuration {

}
