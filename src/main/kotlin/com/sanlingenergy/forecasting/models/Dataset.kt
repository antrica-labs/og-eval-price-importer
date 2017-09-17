package com.sanlingenergy.forecasting.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "dataset")
data class Dataset(
        @get:JacksonXmlProperty(localName = "PRICE_DECK")
        var priceDeck: PriceDeck,
        @get:JacksonXmlProperty(localName = "PRICE_CODE")
        @get:JacksonXmlElementWrapper(useWrapping = false)
        var priceCodes: List<PriceCode>
)
