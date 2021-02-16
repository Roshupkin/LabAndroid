package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
private val TAG = "Main Activity"
    private var indexQuestion: Int = 0
        set(value) {
            if (value < 0) {
                field = question.size - 1
            }else{
                field = value
            }


        }

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
            nextQuestion()
        }
        binding.textQuestion.setOnClickListener {
            nextQuestion()
        }
        binding.buttonBefore.setOnClickListener {
            beforeQuestion()
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

    private fun nextQuestion() {
        indexQuestion = (indexQuestion + 1) % question.size
        binding.textQuestion.setText(question[indexQuestion].textResId)
        Log.e(TAG, "Размер массива: ${question.size}, индекс вопроса в массиве: ${indexQuestion}")
    }

    private fun beforeQuestion() {
        indexQuestion = (indexQuestion - 1) % question.size
        binding.textQuestion.setText(question[indexQuestion].textResId)
        Log.e(TAG, "Размер массива: ${question.size}, индекс вопроса в массиве: ${indexQuestion}")
    }

}
