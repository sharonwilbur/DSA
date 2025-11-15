package Recursion;

import java.util.*;

public class Nqueens_LC51s {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(board, 0, result);
        return result;
    }

    private void backtrack(char[][] board, int row, List<List<String>> result) {
        int n = board.length;
        if (row == n) {
            // All queens placed; add board configuration to result
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q'; // Place queen
                backtrack(board, row + 1, result); // Move to next row
                board[row][col] = '.'; // Backtrack: remove queen
            }
        }
    }

    // Check if placing a queen at (row, col) is safe
    private boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check column above
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >=0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >=0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    // Convert board 2D char array to list of strings
    private List<String> constructBoard(char[][] board) {
        List<String> boardList = new ArrayList<>();
        for (char[] row : board) {
            boardList.add(new String(row));
        }
        return boardList;
    }

    // Example main to test
    public static void main(String[] args) {
        Nqueens_LC51s sol = new Nqueens_LC51s();
        int n = 4;
        List<List<String>> Nqueens_LC51ss = sol.solveNQueens(n);

        System.out.println("Total Nqueens_LC51ss for " + n + "-Queens: " + Nqueens_LC51ss.size());
        for (List<String> Nqueens_LC51s : Nqueens_LC51ss) {
            for (String row : Nqueens_LC51s) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}

