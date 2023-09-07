package com.example.activity4p1_supact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.activity4p1_supact.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {
    lateinit var binding: FragmentQuizBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState)
        binding = FragmentQuizBinding.inflate(layoutInflater)

        binding.btnSubmit.setOnClickListener {
            val Q1 = when (binding.answers.checkedRadioButtonId) {
                R.id.txtanswer1_1 -> 1
                R.id.txtanswer1_2 -> 0
                else -> 0
            }

            val Q2 = when (binding.answers2.checkedRadioButtonId) {
                R.id.txtanswer2_1 -> 0
                R.id.txtanswer2_2 -> 1
                else -> 0
            }

            val Q3 = when (binding.answers3.checkedRadioButtonId) {
                R.id.txtanswer3_1 -> 1
                R.id.txtanswer3_2 -> 0
                else -> 0
            }

            val totalScore = (Q1 + Q2 + Q3)

            if(totalScore == 3) {
                Toast.makeText(activity, "You got it all correct! Great job!", Toast.LENGTH_SHORT).show()
            }

            else if(totalScore == 2) {
                Toast.makeText(activity, "Your overall score is 2/3! Good job!", Toast.LENGTH_SHORT).show()
            }

            else if (totalScore == 1) {
                Toast.makeText(activity, "Your overall score is 1/3! Try harder!", Toast.LENGTH_SHORT).show()
            }

            else {
                Toast.makeText(activity, "Your score is 0/3. Better luck next time!", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}