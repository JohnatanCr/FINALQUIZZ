package com.example.examen2

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.examen2.Views.Configuration

class GameViewModel(context: Context) : ViewModel() {

    var conf = Configuration.conf
    lateinit var questions: List<String>
    var currentPis: Int
    var currentQuestion: Int
    var usedChet: Boolean = false

    init {
        currentQuestion = 0
        usedChet = false
        currentPis = conf.clues_number
        conf.categoriesList =
            listOf(
                Category(
                    0, context.resources.getStringArray(R.array.quest_cine), questions = arrayOf(
                        Question(context.resources.getStringArray(R.array.ans_cine1), "22"),
                        Question(
                            context.resources.getStringArray(R.array.ans_cine2),
                            "The Hateful Eight"
                        ),
                        Question(
                            context.resources.getStringArray(R.array.ans_cine3),
                            "Jurassic Park"
                        ),
                        Question(context.resources.getStringArray(R.array.ans_cine4), "Pixar"),
                        Question(context.resources.getStringArray(R.array.ans_cine5), "Terminator")

                    )
                ),
                Category(
                    1,
                    context.resources.getStringArray(R.array.quest_historia),
                    questions = arrayOf(
                        Question(context.resources.getStringArray(R.array.ans_historia), "XIV"),
                        Question(
                            context.resources.getStringArray(R.array.ans_historia1),
                            "Egipcios"
                        ),
                        Question(context.resources.getStringArray(R.array.ans_historia3), "1821"),
                        Question(
                            context.resources.getStringArray(R.array.ans_historia4),
                            "Imperio Britanico"
                        ),
                        Question(context.resources.getStringArray(R.array.ans_historia5), "1917")

                    )
                ), Category(
                    2, context.resources.getStringArray(R.array.quest_mate), questions = arrayOf(
                        Question(
                            context.resources.getStringArray(R.array.ans_mate1),
                            "Martin Gardner"
                        ),
                        Question(
                            context.resources.getStringArray(R.array.ans_mate2),
                            "2 potencia infinito"
                        ),
                        Question(
                            context.resources.getStringArray(R.array.ans_mate3),
                            "4000 veces la poblacion de la tierra"
                        ),
                        Question(
                            context.resources.getStringArray(R.array.ans_mate4),
                            "que todos los numeros son la suma de dos primos"
                        ),
                        Question(context.resources.getStringArray(R.array.ans_mate5), "4")
                    )
                ),
                Category(
                    3, context.resources.getStringArray(R.array.quest_fisica), questions = arrayOf(
                        Question(
                            context.resources.getStringArray(R.array.ans_fisica1),
                            "region del universo a donde se dirige todo"
                        ),
                        Question(
                            context.resources.getStringArray(R.array.ans_fisica2),
                            "el neutrino"
                        ),
                        Question(
                            context.resources.getStringArray(R.array.ans_fisica3),
                            "todas son correctas"
                        ),
                        Question(
                            context.resources.getStringArray(R.array.ans_fisica4),
                            "El antineutron"
                        ),
                        Question(
                            context.resources.getStringArray(R.array.ans_fisica5),
                            "Meterte dentro de un coche"
                        )
                    )
                ),
                Category(
                    4, context.resources.getStringArray(R.array.quest_comics), questions = arrayOf(
                        Question(context.resources.getStringArray(R.array.ans_comics1), "6"),
                        Question(
                            context.resources.getStringArray(R.array.ans_comics2),
                            "Jason Todd"
                        ),
                        Question(context.resources.getStringArray(R.array.ans_comics3), "Darkside"),
                        Question(
                            context.resources.getStringArray(R.array.ans_comics4),
                            "Infinity stones"
                        ),
                        Question(context.resources.getStringArray(R.array.ans_comics5), "Krypton")
                    )
                ),
                Category(
                    5,
                    context.resources.getStringArray(R.array.quest_videojuegos),
                    questions = arrayOf(
                        Question(
                            context.resources.getStringArray(R.array.ans_videojuegos1),
                            "Final Fantasy"
                        ),
                        Question(
                            context.resources.getStringArray(R.array.ans_videojuegos2),
                            "Dark Souls"
                        ),
                        Question(
                            context.resources.getStringArray(R.array.ans_videojuegos3),
                            "Doom"
                        ),
                        Question(
                            context.resources.getStringArray(R.array.ans_videojuegos4),
                            "Ninguno"
                        ),
                        Question(
                            context.resources.getStringArray(R.array.ans_videojuegos5),
                            "Blue Shell"
                        )
                    )
                )
            )
    }

    fun getGameQuestions(): MutableList<Category> {
        var arrayOfQuestions: MutableList<Int> = mutableListOf()
        for ((indice, value) in conf.categories.withIndex()) {
            if (value) {
                arrayOfQuestions.add(indice)
            }
        }
        var finalQuest: MutableList<Category> = mutableListOf()
        for ((indice, value) in arrayOfQuestions.withIndex()) {
            finalQuest.add(conf.categoriesList.find { x -> x.id == value }!!)

        }
        finalQuest.shuffle()
        return finalQuest
    }

    public val numOfQuestion
        get() = questions.size

    public fun getCurrentQuestion() = questions[currentQuestion]

    public fun nextQuestion() {
        currentQuestion = (currentQuestion + 1) % questions.size
    }

    public fun previousQuestion() {
        currentQuestion = (currentQuestion + questions.size - 1) % questions.size
    }

    public fun usedPista() {
        currentPis = if (currentPis > 0) {
            currentPis--
        } else {
            0
        }
    }
}
