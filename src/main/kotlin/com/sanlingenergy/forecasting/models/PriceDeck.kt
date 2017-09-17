package com.sanlingenergy.forecasting.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "PRICE_DECK")
data class PriceDeck(
        @get:JacksonXmlProperty(isAttribute = true, localName = "escalation_percentage")
        val escalationPercentage: Double,

        @get:JacksonXmlProperty(isAttribute = true, localName = "effective_year")
        val effectiveYear: Int,

        @get:JacksonXmlProperty(isAttribute = true, localName = "years")
        val years: Int,

        @get:JacksonXmlProperty(isAttribute = true, localName = "years_by_month")
        val yearsByMonth: Int,

        @get:JacksonXmlProperty(isAttribute = true, localName = "description")
        val description: String
)