package com.sanlingenergy.forecasting.views

import com.sanlingenergy.forecasting.Styles
import javafx.scene.control.Alert
import javafx.stage.FileChooser
import tornadofx.*
import java.io.File
import javax.swing.filechooser.FileNameExtensionFilter

class MainView : View("Price Deck Creation Tool") {
    override val root = borderpane {
        addClass(Styles.welcomeScreen)
        top {
            stackpane {
                label(title).addClass(Styles.heading)
            }
        }
        center {
            stackpane {
                addClass(Styles.content)

                button("Select the strip CSV") {
                    setOnAction {
                        val filename = chooseFile("Select the strip CSV:", arrayOf(FileChooser.ExtensionFilter("CSV", "*.csv")) ) {
                            initialDirectory = File(".")
                        }

                        val selectedFile: String

                        if (filename.isNotEmpty())
                            selectedFile = filename[0].name
                        else
                            selectedFile = "NO FILE"

                        alert(Alert.AlertType.INFORMATION, "Filename", selectedFile)
                    }
                }
            }
        }
    }
}