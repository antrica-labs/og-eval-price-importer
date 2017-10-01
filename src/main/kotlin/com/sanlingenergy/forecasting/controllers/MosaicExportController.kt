package com.sanlingenergy.forecasting.controllers

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator
import com.sanlingenergy.forecasting.models.Dataset
import tornadofx.Controller
import java.io.File

class MosaicExportController : Controller() {
    fun exportDataset(dataset: Dataset, exportFile: File) {
        val mapper = XmlMapper()

        mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true )
        mapper.enable(SerializationFeature.INDENT_OUTPUT)

        val xml = mapper.writeValueAsString(dataset)

        println(xml)
    }
}