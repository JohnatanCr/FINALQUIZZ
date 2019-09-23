package com.example.examen2

import android.widget.CheckBox

data class Category(val id: Int, val questions_string:Array<String>,val questions: Array<Question>, var isEnabled : Boolean = true)