package com.example.composecomponent.data.domain

import com.example.composecomponent.data.model.Person

object PersonRepository {

    fun getPersons(): List<Person> {
        return listOf(Person("John", "wick", 78), Person("John", "Tee", 78),Person("John", "okafor", 78))
    }
}