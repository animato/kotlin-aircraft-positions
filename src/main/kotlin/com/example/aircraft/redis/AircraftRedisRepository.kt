package com.example.aircraft.redis

import org.springframework.data.repository.CrudRepository

interface AircraftRedisRepository: CrudRepository<AircraftRedis, Long> {
}