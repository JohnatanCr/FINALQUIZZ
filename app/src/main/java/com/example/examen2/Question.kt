package com.example.examen2

data class Question(var question: String, val arrayOfAnswer : Array<String>, val answer : String,var state : Boolean = true)