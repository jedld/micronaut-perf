package com.sample.domain

import groovy.transform.CompileStatic
import io.micronaut.core.annotation.Introspected

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = 'city')
class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String name
    Long stateId

    City() {}
}