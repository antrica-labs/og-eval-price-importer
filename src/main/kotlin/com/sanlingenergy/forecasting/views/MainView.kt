package com.sanlingenergy.forecasting.views

import com.sanlingenergy.forecasting.controllers.ImportController
import com.sanlingenergy.forecasting.controllers.MosaicExportController
import com.sanlingenergy.forecasting.models.PriceCode
import javafx.application.Platform
import javafx.scene.control.Alert
import javafx.scene.layout.Priority
import javafx.stage.FileChooser
import tornadofx.*
import java.io.File

class MainView : View("Price Deck Creation Tool") {
    val importController: ImportController by inject()
    val mosaicController: MosaicExportController by inject()

    override val root = vbox {
        menubar {
            menu("File") {
                item("Open strip...").action {
                    val filename = chooseFile("Select the strip CSV:", arrayOf(FileChooser.ExtensionFilter("CSV", "*.csv")) ) {
                        initialDirectory = File(".")
                    }

                    if (filename.isNotEmpty()) {
                        importController.loadStripFile(filename[0])
                    }
                }

                separator()

                item("Exit").action {
                    Platform.exit()
                }
            }

            menu("Export") {
                item("Mosaic price deck").action {
                    val dataset = importController.dataset

                    if (dataset != null)
                        mosaicController.exportDataset(dataset, File("test"))
                }
            }
        }

        tableview(importController.priceCodes) {
            vboxConstraints {
                vGrow = Priority.ALWAYS
            }

            column("Price code", PriceCode::name)
            column("Total entries", PriceCode::prices).cellFormat {
                text = it.count().toString()
            }

            resizeColumnsToFitContent()
        }
    }
}