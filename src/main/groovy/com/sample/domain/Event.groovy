package com.sample.domain

import com.fasterxml.jackson.annotation.JsonFormat

class Event {

    String id
    String type
    String event
    String domain
    Long   value
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    Date timestamp
}
