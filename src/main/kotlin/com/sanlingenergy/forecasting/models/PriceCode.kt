package com.sanlingenergy.forecasting.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "PRICE_CODE")
data class PriceCode(
        @get:JacksonXmlProperty(isAttribute = true, localName = "name")
        val name: String,
        @get:JacksonXmlProperty(isAttribute = true, localName = "product")
        val product: String,
        @get:JacksonXmlProperty(isAttribute = true, localName = "price_code_type")
        val priceCodeType: String,
        @get:JacksonXmlProperty(localName = "PRICE")
        @get:JacksonXmlElementWrapper(useWrapping = false)
        val prices: List<Price>
)