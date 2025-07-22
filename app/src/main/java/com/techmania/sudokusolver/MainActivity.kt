package com.techmania.sudokusolver

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.techmania.sudokusolver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val cells = Array(9) { arrayOfNulls<EditText>(9) }

    override fun onCreate(savedInstanceState: Bundle?) {
        // Handle the splash screen transition.
        installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createSudokuBoard()

        // We will add the logic for these buttons in a later step
        binding.solveButton.setOnClickListener {
            // TODO: Add solver logic
        }

        binding.clearButton.setOnClickListener {
            // TODO: Add clear logic
        }
    }

    private fun createSudokuBoard() {
        val gridLayout = binding.sudokuGrid
        gridLayout.post { // We use post to make sure the GridLayout has been measured
            val cellSize = gridLayout.width / 9

            for (i in 0..8) {
                for (j in 0..8) {
                    val cell = LayoutInflater.from(this).inflate(R.layout.cell_layout, gridLayout, false) as EditText
                    val params = GridLayout.LayoutParams()
                    params.width = cellSize
                    params.height = cellSize
                    params.rowSpec = GridLayout.spec(i, 1f)
                    params.columnSpec = GridLayout.spec(j, 1f)
                    cell.layoutParams = params

                    // Add thicker dividers for the 3x3 sub-grids
                    if (i % 3 == 2 && i < 8) {
                        params.bottomMargin = 4
                    }
                    if (j % 3 == 2 && j < 8) {
                        params.rightMargin = 4
                    }

                    gridLayout.addView(cell)
                    cells[i][j] = cell
                }
            }
        }
    }
}