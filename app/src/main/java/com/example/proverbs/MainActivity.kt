package com.example.proverbs

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.proverbs.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.lang.NullPointerException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displaytext: TextView = findViewById(R.id.testTV)
        val tex = displaytext.text
        val listts = getListAllLists(this)
        var pos = 0

        val prev = findViewById<Button>(R.id.prev)
        val next = findViewById<Button>(R.id.nextB)


        prev.setOnClickListener{
            displaytext.text = listts[pos-1]
            pos -= 1
        }
        next.setOnClickListener{
            displaytext.text = listts[pos+1]
            pos += 1
        }
        /*while(true){
            val listts = getListAllLists(this)

            for (i in listts){


            }
        }*/





       /* try{
            *//*val jsonString = getJSONFromAssets()!!
            val jsonString = getJSONDataFromAsset(this, "practice.json")
            val json = jsonprac.trimIndent()
            val gson = Gson()fromJson(jsonString, UserList::class.java)
            val listUserType = object : TypeToken<ArrayList<User>>() {}.type
            var users = gson.fromJson(jsonString, listUserType::class.java)
            val listt = users
            var first = listt

            displaytext.text = first.toString()*//*

            working4()

            //tryme()
        }
        catch(e: JSONException) {
            e.printStackTrace()
        }
        catch(e: NullPointerException) {
            e.printStackTrace()
        }

        //jsonToDataClass()
*/



    }



    fun jsonToDataClass(){
        var displaytext: TextView = findViewById(R.id.testTV)
        val userJson = jsonprac

        val moshi = Moshi.Builder().build()
        val userAdapter : JsonAdapter<UserList> = moshi.adapter(UserList::class.java)
        val userItem = userAdapter.fromJson(userJson)

        displaytext.text = userItem.toString()


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

    fun tryme(){
        val jsonList =
            """[
                {
              "title":"Kotlin Tutorial #1",
              "author":"bezkoder",
              "categories":["Kotlin, Basic"]},
			{
            "title":"Kotlin Tutorial #2",
            "author":"bezkoder",
            "categories":["Kotlin, Practice"]
             }
             ]""".trimIndent()

        val gson = Gson()
        val arrayTutorialType = object : TypeToken<Array<Tutorial>>() {}.type

        var tutorials: Array<Tutorial> = gson.fromJson(jsonList, arrayTutorialType)
        //tutorials.forEachIndexed  { idx, tut -> println("> Item ${idx}:\n${tut}") }

        var displaytext: TextView = findViewById(R.id.testTV)
        displaytext.text = tutorials[0].categories[0]





    }


    fun working1(){
        val json = """[
                {
                "name": "Ron",
                "age": 12,
                "breed": "terrier"
                },
                {
                  "name": "Bob",
                  "age": 4,
                  "breed": "bulldog"
                },
                {
                  "name": "Johny",
                  "age": 3,
                  "breed": "golden retriever"
                }
              ]""".trimIndent()


        val gson = Gson()
        val dogType = object : TypeToken<Array<Dog>>() {}.type
        val listt: Array<Dog> = gson.fromJson(json, dogType)
        var displaytext: TextView = findViewById(R.id.testTV)
        displaytext.text = listt[0].age.toString()
    }

    fun working2(){
        val json = """
            {"doglist": [
                {
                "name": "Ron",
                "age": 12,
                "breed": "terrier"
                },
                {
                  "name": "Bob",
                  "age": 4,
                  "breed": "bulldog"
                },
                {
                  "name": "Johny",
                  "age": 3,
                  "breed": "golden retriever"
                }
              ]}""".trimIndent()


        val gson = Gson()
        //val dogType = object : TypeToken<Array<Dog>>() {}.type
        //val listt: Array<Dog> = gson.fromJson(json, dogType)
        val listt = gson.fromJson(json, DogList::class.java)
        var displaytext: TextView = findViewById(R.id.testTV)
        displaytext.text = listt.doglist[0].breed
    }

    fun working3(){
        val jsonString = getJSONDataFromAsset(this, "practice.json")
        val gson = Gson()
        //val dogType = object : TypeToken<Array<Dog>>() {}.type
        //val listt: Array<Dog> = gson.fromJson(json, dogType)
        val listt = gson.fromJson(jsonString, UserList::class.java)
        var displaytext: TextView = findViewById(R.id.testTV)

        displaytext.text = listt.users[0].email
    }

    fun working4(){
        val jsonString = getJSONDataFromAsset(this, "Proverbs.json")
        val gson = Gson()
        val listt = gson.fromJson(jsonString, Books::class.java)
        var displaytext: TextView = findViewById(R.id.testTV)

        displaytext.text = listt.chapters[4].verses[8].text


        getListAllLists(this)
    }





}