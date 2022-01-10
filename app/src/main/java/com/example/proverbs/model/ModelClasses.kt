package com.example.proverbs.model


data class UserList(
    val users: Array<User>
)

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val gender: String,
    val weight: Double,
    val height: Int,
    val phone: Phone
)


data class Phone(
    val mobile: String,
    val office: String
)


class Tutorial(
    val title: String,
    val author: String,
    val categories: List<String>
) {
    override fun toString(): String {
        return "Category [title: ${this.title}, author: ${this.author}, categories: ${this.categories}]"
    }
}


class Dog(
    val name: String,
    val age: Int,
    val breed: String
    ){
    override fun toString(): String {
        return "categories [Name: ${this.name}, Age: ${this.age}, Breed: ${this.breed}]"
    }
}

class DogList(
    val doglist: Array<Dog>
)


// To parse the JSON, install Klaxon and do:
//
//   val welcome8 = Welcome8.fromJson(jsonString)


data class Books (
    val book: String,
    val chapters: List<Chapter>
)


data class Chapter (
    val chapter: String,
    val verses: List<Verse>
)

data class Verse (
    val verse: String,
    val text: String
)


