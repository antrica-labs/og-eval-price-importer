package com.sanlingenergy.forecasting

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator
import com.sanlingenergy.forecasting.models.*
import com.sanlingenergy.forecasting.views.MainView
import javafx.application.Application
import tornadofx.App

class MyApp : App() {
    override val primaryView = MainView::class
}

/**
 * The main method is needed to support the mvn jfx:run goal.
 */
fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)

}