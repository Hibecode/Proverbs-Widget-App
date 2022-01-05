package com.example.proverbs.model


data class UserList(
    val user: ArrayList<User>
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

