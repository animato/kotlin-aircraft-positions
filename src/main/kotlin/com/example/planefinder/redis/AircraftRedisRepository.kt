package com.example.planefinder.redis

import org.springframework.data.repository.CrudRepository

interface AircraftRedisRepository: CrudRepository<AircraftRedis, Long> {
}