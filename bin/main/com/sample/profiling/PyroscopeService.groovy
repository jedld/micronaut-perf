package com.sample.profiling

import groovy.util.logging.Slf4j
import io.micronaut.context.annotation.Value
import io.micronaut.context.event.StartupEvent
import io.pyroscope.http.Format
import io.pyroscope.javaagent.EventType
import io.pyroscope.javaagent.PyroscopeAgent
import io.pyroscope.javaagent.config.Config
import jakarta.inject.Singleton
import io.micronaut.runtime.event.annotation.EventListener

@Singleton
@Slf4j
class PyroscopeService {

    @Value('${pyroscope.server}')
    String pyroscopeServerURL

    @Value('${pyroscope.password}')
    String password

    @Value('${pyroscope.username}')
    String username

    @Value('${pyroscope.enabled}')
    boolean enabled

    @EventListener
    void onStartup(StartupEvent event) {
        if (enabled) {
            log.info("Pyroscope server at" + pyroscopeServerURL)
            PyroscopeAgent.start(
                    new Config.Builder()
                            .setApplicationName("mn-perf-test")
                            .setBasicAuthPassword(password)
                            .setBasicAuthUser(username)
                            .setProfilingEvent(EventType.ITIMER)
                            .setFormat(Format.JFR)
                            .setServerAddress(pyroscopeServerURL)
                            .build()
            )
        } else {
            log.info("Pyroscope is disabled.")
        }
    }
}
