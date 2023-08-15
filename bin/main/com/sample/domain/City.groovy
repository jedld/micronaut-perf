package com.sample.domain


import io.micronaut.serde.annotation.Serdeable

import javax.persistence.*

@Entity
@Serdeable
@Table(name = 'city')
class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String name
    Long stateId
    Long visits

    City() {}
}