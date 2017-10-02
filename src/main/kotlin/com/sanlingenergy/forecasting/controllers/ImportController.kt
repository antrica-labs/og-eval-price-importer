package com.sanlingenergy.forecasting.controllers

import com.sanlingenergy.forecasting.models.Dataset
import com.sanlingenergy.forecasting.models.Price
import com.sanlingenergy.forecasting.models.PriceCode
import com.sanlingenergy.forecasting.models.PriceDeck
import com.sun.xml.internal.ws.wsdl.writer.document.Import
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import org.apache.commons.csv.CSVFormat
import tornadofx.Controller
import java.io.File
import java.io.FileReader
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class ImportController : Controller() {
    enum class ImportHeaders {
        PriceCode,
        ProductType,
        PriceType,
        Linked,
        ProductionMonth,
        Price
    }

    var dataset: Dataset? = null
    val priceCodes: ObservableList<PriceCode> = FXCollections.observableArrayList<PriceCode>()

    fun loadStripFile(file: File) {
        val df = SimpleDateFormat("yyyy-MM-dd")
        val deck = PriceDeck(escalationPercentage = 0.0, effectiveYear = 2017, years = 3, yearsByMonth = 3, description ="Updated ${df.format(Calendar.getInstance().getTime())}")
        val codes = ArrayList<PriceCode>()
        val dictionary = HashMap<String, PriceCode>()
        val linkedPriceCodes = ArrayList<Pair<String, String>>()

        val parser = CSVFormat.EXCEL.withHeader(ImportHeaders::class.java).withSkipHeaderRecord().parse(FileReader(file))

        var priceCode: PriceCode? = null
        for (record in parser) {
            val code = record.get(ImportHeaders.PriceCode)
            val linked = record.get(ImportHeaders.Linked)

            // Check if this is a linked price, which we will have to set aside for now
            if (!linked.isNullOrEmpty()) {
                linkedPriceCodes.add(Pair(code, linked))

                // We will skip on processing this row
                continue
            }

            if (priceCode == null || priceCode.name != code) {
                priceCode = PriceCode(
                        name = code,
                        product = record.get(ImportHeaders.PriceType),
                        priceCodeType = record.get(ImportHeaders.PriceType)
                )

                codes.add(priceCode)
                dictionary[code] = priceCode
            }

            val price = Price(
                effectiveDate = record.get(ImportHeaders.ProductionMonth),
                basePrice = record.get(ImportHeaders.Price).toDouble()
            )

            priceCode.prices.add(price)
        }

        parser.close()

        // Now we have to process all the linked price codes
        linkedPriceCodes.forEach { (code, linked) ->
            try {
                val linkedCode = dictionary[linked]!!

                codes.add(PriceCode(name = code, product = linkedCode.product, priceCodeType = linkedCode.priceCodeType, prices = linkedCode.prices))
            } catch (exception: Throwable) {
                throw Throwable("Unable to link price code ${code} to ${linked}. Make sure that ${linked} isn't also linked code.")
            }
        }

        priceCodes.addAll(codes)
        dataset = Dataset(priceDeck = deck, priceCodes = codes)
    }


}