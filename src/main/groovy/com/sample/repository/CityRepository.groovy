package com.sample.repository

import com.sample.domain.City
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.PageableRepository
import jakarta.annotation.Nullable

@Repository
interface CityRepository extends PageableRepository<City, Long> {
    @Nullable
    Optional<City> findById(Long id)
}