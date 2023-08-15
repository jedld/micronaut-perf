package com.sample.controller

import com.sample.Utils
import com.sample.domain.City
import com.sample.profiling.Profile
import com.sample.repository.CityRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject

@Controller("/test")
class HelloController {
    @Inject
    CityRepository cityRepository

    @Profile(label = ["controller", "city"])
    @Get(value = '/city', produces = MediaType.APPLICATION_JSON)
    HttpResponse<?> index() {
        Optional<City> cityOpt = cityRepository.findById(10+Utils.getRandom(900))

        if (cityOpt.present) {
            City city = cityOpt.get()
            city.visits++
            cityRepository.update(city)
            return HttpResponse.ok(city)
        }
        return HttpResponse.notFound()
    }
}