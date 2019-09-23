package com.example.examen2


class Game_Configuration() {
    var all_categories : Boolean = true

    var categories: Array<Boolean> = arrayOf(true,true,true,true,true,true)
    lateinit var categoriesList: List<Category>
    private var categoriesNumber = 6

    val arrayQuestionsNumber = arrayOf(5, 6, 7, 8, 9,10)
    val arrayCluesNumber = arrayOf(1, 2, 3)

    var questions_number : Int = 5
    var dificulty : Int = 0
    var cluesOn : Boolean = false
    var clues_number: Int = 1

    fun getCheckedCategory(pos:Int): Boolean {
        return categories[pos]
    }
    fun getNumOfCategories(): Int{
        return categoriesNumber
    }
    fun setEnabledCategory(pos:Int, value: Boolean){
        categories[pos]= value
        if(value){
            if(categoriesNumber < 6){
                categoriesNumber++
            }
        }
        else{
            categoriesNumber--
        }
    }

}