package com.techmania.sudokusolver.logic

class SudokuSolver {

    fun solve(board: Array<IntArray>): Boolean {
        // TODO: Implement backtracking algorithm
        return false
    }

    private fun isValid(board: Array<IntArray>, row: Int, col: Int, num: Int): Boolean {
        for (c in 0..8) {
            if (board[row][c] == num) {
                return false
            }
        }

        for (r in 0..8) {
            if (board[r][col] == num) {
                return false
            }
        }

        val startRow = row - row % 3
        val startCol = col - col % 3
        for (r in 0..2) {
            for (c in 0..2) {
                if (board[r + startRow][c + startCol] == num) {
                    return false
                }
            }
        }

        return true
    }
}
