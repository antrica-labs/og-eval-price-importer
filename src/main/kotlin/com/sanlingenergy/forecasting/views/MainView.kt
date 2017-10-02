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
                    val files = chooseFile("Select the strip CSV", arrayOf(FileChooser.ExtensionFilter("CSV", "*.csv")) ) {
                        initialDirectory = File(".")
                    }

                    if (files.isNotEmpty()) {
                        importController.loadStripFile(files[0])
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

                    if (dataset != null) {
                        val files = chooseFile("Save to Mosaic XML", arrayOf(FileChooser.ExtensionFilter("XML", "*.xml")), FileChooserMode.Save ) {
                            initialDirectory = File(".")
                        }

                        if (files.isNotEmpty()) {
                            mosaicController.exportDataset(dataset, files[0])
                            alert(Alert.AlertType.INFORMATION, "", "Mosaic export saved!")
                        }

                    }
                }
            }
        }

        tableview(importController.priceCodes) {
            vboxConstraints {
                vGrow = Priority.ALWAYS
            }

            val priceCol = column("Price code", PriceCode::name)
            val entriesCol = column("Total entries", PriceCode::prices)

            priceCol.weigthedWidth(3.0)
            entriesCol.weigthedWidth(1.0)

            entriesCol.cellFormat {
                text = it.count().toString()
            }

            columnResizePolicy = SmartResize.POLICY
        }
    }
}