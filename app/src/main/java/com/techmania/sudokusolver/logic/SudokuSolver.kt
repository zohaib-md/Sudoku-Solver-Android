package com.techmania.sudokusolver.logic

class SudokuSolver {

    fun solve(board: Array<IntArray>): Boolean {
        val find = findEmpty(board)
        val row: Int
        val col: Int

        if (find == null) {
            return true
        } else {
            row = find.first
            col = find.second
        }
        for (num in 1..9) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num

                if (solve(board)) {
                    return true
                }

                board[row][col] = 0
            }
        }

        return false
    }
    private fun findEmpty(board: Array<IntArray>): Pair<Int, Int>? {
        for (r in 0..8) {
            for (c in 0..8) {
                if (board[r][c] == 0) {
                    return Pair(r, c)
                }
            }
        }
        return null
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