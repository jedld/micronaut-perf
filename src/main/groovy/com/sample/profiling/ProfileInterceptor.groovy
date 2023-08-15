package com.sample.profiling

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import io.micronaut.context.annotation.Requires
import io.micronaut.context.annotation.Value
import io.pyroscope.labels.LabelsSet
import io.pyroscope.labels.Pyroscope
import jakarta.inject.Singleton

@Singleton
@CompileStatic
@Requires(classes = [Profile])
@Slf4j
class ProfileInterceptor implements MethodInterceptor<Object, Object> {

    @Value('${pyroscope.enabled}')
    boolean enabled

    @Override
    Object intercept(MethodInvocationContext<Object, Object> context) {
        String[] label = context.stringValues(Profile.class, "label")
        if (enabled) {
            Object result = null
            Pyroscope.LabelsWrapper.run(new LabelsSet(label), () -> {
                // Invoke the method
                result = context.proceed()
            })
            result
        } else {
            context.proceed()
        }
    }
}
