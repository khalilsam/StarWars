package io.thinkit.starwarsapp.view.ui.utils

import java.text.SimpleDateFormat
import java.util.*

class Constants {
    companion object {
        const val BASE_URL = "https://swapi.dev/api/"
        const val REQUEST_TIMEOUT_DURATION = 30
        const val DEBUG = true
    }

    class DateUtils {
        companion object {
            fun convertStringDate(date: String, format: String): String {
                var parser = SimpleDateFormat(format)
                val date: Date = parser.parse(date)

                var formatter = SimpleDateFormat("yyyy/MM/dd")
                val formattedDate = formatter.format(date)
                return formattedDate
            }
        }
    }
}