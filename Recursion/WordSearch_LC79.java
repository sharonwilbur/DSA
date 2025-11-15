  package Recursion;



  public class WordSearch_LC79 {
      public boolean exist(char[][] board, String word) {
        int rowLength=board.length;
        int colLength=board[0].length;
        boolean[][] visited=new boolean[rowLength][colLength];
        for(int i=0;i<rowLength;i++)
        {
          for(int j=0;j<colLength;j++)
          {
            if(board[i][j]==word.charAt(0))
            {
              if(dfs(board, word, visited, i, j, 0))
              {
                return true;
              }
            }
          }
        }
        return false;
      }

      private boolean dfs(char[][] board,String word, boolean[][] visited, int row, int col, int index) {
          if(index==word.length())
          {
            return true;
          }
          if(row<0||row>=board.length||col<0||col>=board[0].length)
          {
            return false;
          }
          if(visited[row][col]==true||board[row][col]!=word.charAt(index))
          {
            return false;
          }
          visited[row][col]=true;
          boolean found=(
            dfs(board, word, visited, row+1, col, index+1)||
            dfs(board, word, visited, row-1, col, index+1)||
            dfs(board, word, visited, row, col+1, index+1)||
            dfs(board, word, visited, row, col-1, index+1)
          );
          visited[row][col]=false;
          return found;
      }

      // Example usage
      public static void main(String[] args) {
          WordSearch_LC79 sol = new WordSearch_LC79();
          char[][] board = {
              {'A','B','C','E'},
              {'S','F','C','S'},
              {'A','D','E','E'}
          };
          System.out.println(sol.exist(board, "ABCCED")); // true
          System.out.println(sol.exist(board, "SEE"));    // true
          System.out.println(sol.exist(board, "ABCB"));   // false
      }
  }

