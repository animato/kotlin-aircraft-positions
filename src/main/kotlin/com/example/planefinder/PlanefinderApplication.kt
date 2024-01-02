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
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@SpringBootApplication
class PlanefinderApplication

fun main(args: Array<String>) {
    runApplication<PlanefinderApplication>(*args)
}

@Configuration
class Configuration {
    @Bean
    fun redisOperations(objectMapper: ObjectMapper, factory: RedisConnectionFactory): RedisOperations<String, Aircraft> {
        val serializer = Jackson2JsonRedisSerializer(objectMapper, Aircraft::class.java)
        val template: RedisTemplate<String, Aircraft> = RedisTemplate()
        template.connectionFactory = factory
        template.setDefaultSerializer(serializer) // TODO 이건 왜 set method?
        template.keySerializer = StringRedisSerializer()

        return template
    }
}
