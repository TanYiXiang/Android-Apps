package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.simplecalculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initNumberButtonClickListeners()
        initExpressionButtonClickListeners()


    }

    private fun initNumberButtonClickListeners() {
        binding.apply {
            button_one.setOnClickListener { appendExpression(buttonOne.text) }
            button_two.setOnClickListener { appendExpression(buttonTwo.text) }
            button_three.setOnClickListener { appendExpression(buttonThree.text) }
            button_four.setOnClickListener { appendExpression(buttonFour.text) }
            button_five.setOnClickListener { appendExpression(buttonFive.text) }
            button_six.setOnClickListener { appendExpression(buttonSix.text) }
            button_seven.setOnClickListener { appendExpression(buttonSeven.text) }
            button_eight.setOnClickListener { appendExpression(buttonEight.text) }
            button_nine.setOnClickListener { appendExpression(buttonNine.text) }
            zero_button.setOnClickListener { appendExpression(zeroButton.text) }
            decimal_button.setOnClickListener { appendExpression(decimalButton.text) }

        }
    }

    private fun initExpressionButtonClickListeners() {
        binding.apply {
            left_parentheses_button.setOnClickListener { appendExpression(left_parentheses_button.text) }
            right_parentheses_button.setOnClickListener { appendExpression(rightParenthesesButton.text) }
            plus_button.setOnClickListener { appendExpression(plus_button.text) }
            subtract_button.setOnClickListener { appendExpression(subtract_button.text) }
            multiply_button.setOnClickListener { appendExpression(multiply_button.text) }
            division_button.setOnClickListener { appendExpression(division_button.text) }
            back_button.setOnClickListener { backExpression() }
            CE_button.setOnClickListener { clearExpression() }
        }
    }

    private fun appendExpression(buttonText: CharSequence) {
        binding.expressionText.append(buttonText)

    }

    private fun clearExpression() {
        binding.expressionText.text = ""
    }

    private fun backExpression() {
        val expressionText = binding.expressionText.text
        binding.expressionText.setText(expressionText.substring(0, expressionText.length - 1))
    }
}
