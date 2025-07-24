package com.techmania.sudokusolver

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.techmania.sudokusolver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sudokuBoardView: SudokuBoardView

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sudokuBoardView = binding.sudokuBoardView

        setupNumberPad()

        binding.solveButton.setOnClickListener {
            sudokuBoardView.solve()
        }

        binding.clearButton.setOnClickListener {
            sudokuBoardView.clear()
        }
    }

    private fun setupNumberPad() {
        val numberPad = binding.numberPad
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            1f
        )
        for (i in 1..9) {
            val button = Button(this).apply {
                text = i.toString()
                layoutParams = params
                setOnClickListener {
                    sudokuBoardView.setNumber(i)
                }
            }
            numberPad.addView(button)
        }
    }
}