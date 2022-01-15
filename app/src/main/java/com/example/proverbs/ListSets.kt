package com.example.proverbs

import android.content.Context
import android.widget.TextView
import com.example.proverbs.model.Books
import com.google.gson.Gson
import java.io.IOException


fun getListAllList(context: Context): List<String>{
    val jsonString = getJSONDataFromAsset(context, "Proverbs.json")

    val gson = Gson()
    val list1 = gson.fromJson(jsonString, Books::class.java)
    val newList =  mutableListOf("")
    for (i in list1.chapters){
        var newString = "#Proverbs ${i.chapter}:"
        for (j in i.verses){
            newList.add(j.text+newString+j.verse)
        }
    }
    newList.removeAt(0)
    return newList
}

fun getListShuffledList(context: Context): List<String>{
    val jsonString = getJSONDataFromAsset(context, "Proverbs.json")

    val gson = Gson()
    val list1 = gson.fromJson(jsonString, Books::class.java)
    val newList =  mutableListOf("")
    for (i in list1.chapters){
        var newString = "#Proverbs ${i.chapter}:"
        for (j in i.verses){
            newList.add(j.text+newString+j.verse)
        }
    }
    newList.removeAt(0)
    newList.shuffle()
    return newList
}

/*fun working5(){
    val jsonString = getJSONDataFromAsset(this, "Proverbs.json")
    val gson = Gson()
    val listt = gson.fromJson(jsonString, Books::class.java)
    *//*var displaytext: TextView = findViewById(R.id.testTV)

    displaytext.text = listt.chapters[4].verses[8].text*//*
}*/


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
