package com.app.rachmad.retrofit

import android.content.Context
import android.net.Uri
import androidx.test.platform.app.InstrumentationRegistry
import com.app.rachmad.movie.MainActivity
import org.junit.Before
import org.junit.Test
import java.io.IOException
import org.junit.Assert.*
import org.junit.runner.RunWith
import android.R.attr.name
import java.nio.charset.StandardCharsets
import java.text.SimpleDateFormat
import java.util.*


class UtilTest {
    @Test
    fun movieData(){
        var json: String?
        try {
            val inputStream = this.javaClass.classLoader!!.getResourceAsStream("movie.json")
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            json = null
        }

        assertNotNull(json)
    }

    @Test
    fun tvData(){
        var json: String?
        try {
            val inputStream = this.javaClass.classLoader!!.getResourceAsStream("tv.json")
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            json = null
        }

        assertNotNull(json)
    }

    @Test
    fun genreData(){
        var json: String?
        try {
            val inputStream = this.javaClass.classLoader!!.getResourceAsStream("genres.json")
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            json = null
        }

        assertNotNull(json)
    }

    @Test
    fun addressData() {
        var df = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val newDate = df.parse("2001-07-19")

        assertNotNull(newDate)

        df = SimpleDateFormat("MMM yyyy", Locale.US)
        assertEquals("Jul 2001", df.format(newDate))
    }
}