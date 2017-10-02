package com.sanlingenergy.forecasting.controllers

import com.sanlingenergy.forecasting.models.Dataset
import com.sanlingenergy.forecasting.models.Price
import com.sanlingenergy.forecasting.models.PriceCode
import com.sanlingenergy.forecasting.models.PriceDeck
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.Controller
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class ImportController : Controller() {
    var dataset: Dataset? = null
    val priceCodes: ObservableList<PriceCode> = FXCollections.observableArrayList<PriceCode>()

    fun loadStripFile(file: File) {
        val df = SimpleDateFormat("yyyy-MM-dd")

        val d = Dataset(
                priceDeck = PriceDeck(escalationPercentage = 2.0, effectiveYear = 2017, years = 5, yearsByMonth = 3, description = "Updated ${df.format(Calendar.getInstance().getTime())}"),
                priceCodes = arrayListOf(
                        PriceCode(name = "AB Plantgate Spot", product = "Gas", priceCodeType = "Price", prices = arrayListOf(
                                Price(effectiveDate = "2017-01-01", basePrice = 1.78636796, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 1.78636796),
                                Price(effectiveDate = "2017-02-01", basePrice = 2.28729823, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.28729823),
                                Price(effectiveDate = "2017-03-01", basePrice = 2.31084258, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.31084258),
                                Price(effectiveDate = "2017-04-01", basePrice = 2.50415351, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.50415351),
                                Price(effectiveDate = "2017-05-01", basePrice = 2.67584483, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.67584483),
                                Price(effectiveDate = "2017-06-01", basePrice = 2.25128692, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.25128692),
                                Price(effectiveDate = "2017-07-01", basePrice = 1.3550751, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 1.3550751),
                                Price(effectiveDate = "2017-08-01", basePrice = 1.54068734, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 1.54068734),
                                Price(effectiveDate = "2017-09-01", basePrice = 1.26712021, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 1.26712021),
                                Price(effectiveDate = "2017-10-01", basePrice = 1.85875922, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 1.85875922),
                                Price(effectiveDate = "2017-11-01", basePrice = 2.20572756, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.20572756),
                                Price(effectiveDate = "2017-12-01", basePrice = 2.34388212, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.34388212),
                                Price(effectiveDate = "2018-01-01", basePrice = 2.11353663, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.11353663),
                                Price(effectiveDate = "2018-02-01", basePrice = 2.42297825, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.42297825),
                                Price(effectiveDate = "2018-03-01", basePrice = 2.38817595, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.38817595),
                                Price(effectiveDate = "2018-04-01", basePrice = 2.07284607, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.07284607),
                                Price(effectiveDate = "2018-05-01", basePrice = 2.0327707, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.0327707),
                                Price(effectiveDate = "2018-06-01", basePrice = 2.03804377, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.03804377),
                                Price(effectiveDate = "2018-07-01", basePrice = 2.03909839, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.03909839),
                                Price(effectiveDate = "2018-08-01", basePrice = 2.06862761, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.06862761),
                                Price(effectiveDate = "2018-09-01", basePrice = 2.04542608, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.04542608),
                                Price(effectiveDate = "2018-10-01", basePrice = 2.1171399, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.1171399),
                                Price(effectiveDate = "2018-11-01", basePrice = 2.27111369, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.27111369),
                                Price(effectiveDate = "2018-12-01", basePrice = 2.41559594, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.41559594),
                                Price(effectiveDate = "2019-01-01", basePrice = 2.04296531, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.04296531),
                                Price(effectiveDate = "2019-02-01", basePrice = 2.44301593, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.44301593),
                                Price(effectiveDate = "2019-03-01", basePrice = 2.35548289, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.35548289),
                                Price(effectiveDate = "2019-04-01", basePrice = 1.92098151, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 1.92098151),
                                Price(effectiveDate = "2019-05-01", basePrice = 1.80602847, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 1.80602847),
                                Price(effectiveDate = "2019-06-01", basePrice = 1.82712077, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 1.82712077),
                                Price(effectiveDate = "2019-07-01", basePrice = 1.84188538, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 1.84188538),
                                Price(effectiveDate = "2019-08-01", basePrice = 1.84821307, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 1.84821307),
                                Price(effectiveDate = "2019-09-01", basePrice = 1.85770461, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 1.85770461),
                                Price(effectiveDate = "2019-10-01", basePrice = 1.91570843, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 1.91570843),
                                Price(effectiveDate = "2019-11-01", basePrice = 2.09288375, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.09288375),
                                Price(effectiveDate = "2019-12-01", basePrice = 2.29642445, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.29642445),
                                Price(effectiveDate = "2020-01-01", basePrice = 2.042438, baseOffset = 0.0, currencyFactor = 0.0, currencyOffset = 0.0, adjustmentFactor = 0.0, netPrice = 2.042438)
                        ))
                ))


        priceCodes.addAll(d.priceCodes)
        dataset = d
    }
}