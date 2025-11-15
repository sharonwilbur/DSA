package Recursion;

public class SudokuSolver_LC37 {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {  // Empty cell
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;  // Try placing num
                            if (solve(board))       // Recursively solve
                                return true;        // Solved!
                            board[row][col] = '.'; // Backtrack
                        }
                    }
                    return false; // No valid number, trigger backtracking
                }
            }
        }
        return true; // Board completed, valid solution
    }

    // Check if placing 'num' at (row, col) is valid
    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int x = 0; x < 9; x++) {
            // Check row and column
            if (board[row][x] == num || board[x][col] == num)
                return false;
        }
        // Check 3x3 box
        int boxRow = (row / 3) * 3, boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    // Print solution
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // Example usage
    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        SudokuSolver_LC37 solver = new SudokuSolver_LC37();
        solver.solveSudoku(board);
        printBoard(board); // Output solved board
    }
}

