package com.sanlingenergy.forecasting.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

data class Price(
        @get:JacksonXmlProperty(isAttribute = true, localName = "effective_date")
        val effectiveDate: String,
        @get:JacksonXmlProperty(isAttribute = true, localName = "base_price")
        val basePrice: Double,
        @get:JacksonXmlProperty(isAttribute = true, localName = "base_offset")
        val baseOffset: Double,
        @get:JacksonXmlProperty(isAttribute = true, localName = "currency_factor")
        val currencyFactor: Double,
        @get:JacksonXmlProperty(isAttribute = true, localName = "currency_offset")
        val currencyOffset: Double,
        @get:JacksonXmlProperty(isAttribute = true, localName = "adjustment_factor")
        val adjustmentFactor: Double,
        @get:JacksonXmlProperty(isAttribute = true, localName = "net_price")
        val netPrice: Double
)