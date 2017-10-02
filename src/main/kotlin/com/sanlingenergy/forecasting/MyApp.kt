package com.sanlingenergy.forecasting

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator
import com.sanlingenergy.forecasting.models.*
import com.sanlingenergy.forecasting.views.MainView
import javafx.application.Application
import javafx.stage.Stage
import tornadofx.App

class MyApp : App() {
    override val primaryView = MainView::class

    override fun start(stage: Stage) {
        super.start(stage)
        stage.width = 500.0
        stage.height = 809.017
    }
}