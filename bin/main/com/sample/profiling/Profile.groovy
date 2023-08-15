package com.sample.profiling

import io.micronaut.aop.Around
import io.micronaut.context.annotation.Type

import java.lang.annotation.*

@Around
@Type(ProfileInterceptor.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Profile {
    String[] label();
}
