package com.example.examen2.Views

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.examen2.GameViewModel
import com.example.examen2.R
import kotlinx.android.synthetic.main.activity_quiz_game.*


class QuizGameActivity : AppCompatActivity() {

    private lateinit var nextButton : Any
    private lateinit var previousButton : Any

    private lateinit var ansOneButton : Button
    private lateinit var ansTwoButton: Button
    private lateinit var ansThreeButton: Button
    private lateinit var ansFourButton : Button

    private lateinit var questionTextView: TextView
    private lateinit var questionNumTextView: TextView
    private lateinit var cluesNumTextView: TextView

    private lateinit var currentQuestion : String

    private var score: Int = 0
    private var cont: Int = 0

    //    private fun updateQuestion() {
//        tvQuestion.setText(model.getCurrentQuestion().id)
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_game)
        var model = GameViewModel(this)

        nextButton = findViewById(R.id.nxt_Btn)
        previousButton= findViewById(R.id.prev_Btn)

        ansOneButton = findViewById(R.id.answ1_btn)
        ansTwoButton = findViewById(R.id.answ2_btn)
        ansThreeButton= findViewById(R.id.answ3_btn)
        ansFourButton= findViewById(R.id.answ4_btn)

        questionTextView = findViewById(R.id.quesTl_text)
        questionNumTextView = findViewById(R.id.quesNum_text)
        cluesNumTextView = findViewById(R.id.pistas_counter)

        questionTextView.text = model.getGameQuestions()[0].question
}

    fun onAnswered(){

    }
}
