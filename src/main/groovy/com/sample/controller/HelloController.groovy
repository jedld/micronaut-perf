package com.sample.controller

import com.sample.Utils
import com.sample.domain.City
import groovy.transform.CompileStatic
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.MediaType
import io.micronaut.transaction.jdbc.DelegatingDataSource
import jakarta.inject.Inject
import groovy.sql.Sql

import javax.sql.DataSource
import java.sql.ResultSet

@CompileStatic
@Controller("/hello")
class HelloController {
    @Inject
    DataSource dataSource

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    String index() {
        // return "Pong"

        /*
        When enabling JTA in the project by adding io.micronaut.data:micronaut-data-hibernate-reactive
        The datasources get 'wrapped' by hibernate transactional bean, and it would need a transaction
        As we want to test plain sql and plain pool we get the original DS instead of the wrapped one by the
        inclusion of io.micronaut.data:micronaut-data-hibernate-reactive
         */
        DataSource db1Ds = ((DelegatingDataSource) dataSource).getTargetDataSource()
        Sql sql = new Sql(db1Ds)
        City city=new City()

        sql.query("select id,name,state_id from city where id=?", [10+ Utils.getRandom(900)] as List<Object>, { ResultSet rs->
            if (rs.next()) {
                city.id = rs.getInt(1)
                city.name = rs.getString(2)
                city.stateId = rs.getInt(3)
            }
        })

        return HttpResponse.ok(city)
    }
}