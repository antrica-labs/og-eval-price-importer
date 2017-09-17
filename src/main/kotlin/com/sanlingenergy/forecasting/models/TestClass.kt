package com.sanlingenergy.forecasting.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "test")
class TestClass(name: String) {
    @get:JacksonXmlProperty(isAttribute = true)
    private var name: String? = null
        set

    init {
        this.name = name
    }
}
