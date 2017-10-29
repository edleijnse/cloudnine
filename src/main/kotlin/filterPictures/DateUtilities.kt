package filterPictures

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

object DateUtilities {
    // https://gist.github.com/nickrussler/7527851
    fun toISO8601UTC(date: Date): String {
        val tz = TimeZone.getTimeZone("UTC")
        val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'")
        df.timeZone = tz
        return df.format(date)
    }

    fun fromISO8601UTC(dateStr: String): Date? {
        val tz = TimeZone.getTimeZone("UTC")
        val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'")
        df.timeZone = tz

        try {
            return df.parse(dateStr)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return null
    }

}
