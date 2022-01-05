package com.example.proverbs

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.proverbs.model.Tutorial
import com.example.proverbs.model.User
import com.example.proverbs.model.UserList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.lang.NullPointerException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try{
            /*val jsonString = getJSONFromAssets()!!*/
            val jsonString = getJSONDataFromAsset(this, "practice.json")
            val json = """
                {
                "title":
                 "Kotlin Tutorial #1",
                  "author": "bezkoder",
                   "categories" :
                    ["Kotlin","Basic"
                    ]
                    }""".trimIndent()
            val gson = Gson()/*fromJson(jsonString, UserList::class.java)*/
            //val listUserType = object : TypeToken<List<UserList>>() {}.type
            var users = gson.fromJson(json, Tutorial::class.java)
            val listt = users
            var first = listt.categories[0]
            var displaytext: TextView = findViewById(R.id.testTV)
            displaytext.text = first.toString()
        }
        catch(e: JSONException) {
            e.printStackTrace()
        }
        /*catch(e: NullPointerException) {
            e.printStackTrace()
        }*/
    }



    private fun getJSONFromAssets(): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myJSONFile = assets.open("practice.json")
            val size = myJSONFile.available()
            val buffer = ByteArray(size)
            myJSONFile.read(buffer)
            myJSONFile.close()
            json = String(buffer, charset)
        }catch(ex: IOException){
            ex.printStackTrace()
            return null
        }
        return json
    }

    fun getJSONDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try{
            jsonString = context.assets.open(fileName)
                .bufferedReader().use{it.readText()}
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return jsonString
    }
}