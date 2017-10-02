package com.sanlingenergy.forecasting.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "DEFAULT_PRICE")
data class DefaultPrice(
        @get:JacksonXmlProperty(isAttribute = true, localName = "price_code")
        val priceCodeName: String,

        @get:JacksonXmlProperty(isAttribute = true, localName = "product")
        val product: String,

        @get:JacksonXmlProperty(isAttribute = true, localName = "jurisdiction")
        val jurisdiction: String
)