package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.geoquiz.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    val question = arrayOf(
        Question(R.string.question_1, true),
        Question(R.string.question_2, false),
        Question(R.string.question_3, true),
        Question(R.string.question_4, true),
        Question(R.string.question_5, false)
    )

    private var indexQuestion = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonTrue.setOnClickListener {
            checkAnswer(true)
        }
        binding.buttonFalse.setOnClickListener {
            checkAnswer(false)
        }

        binding.buttonNext.setOnClickListener {
            indexQuestion = (indexQuestion + 1) % question.size
            binding.textQuestion.setText(question[indexQuestion].textResId)
        }

    }

    private fun checkAnswer(userPressedTrue: Boolean) {
        val answerIsTrue = question[indexQuestion].answerTrue
        var messageResId = 0
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

}
