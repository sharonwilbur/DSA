package BFS;


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_LC200 {
    

    public int numIslands(char[][] grid){
        int row=grid.length;
        int column=grid[0].length;
        int count=0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(grid[i][j]=='1')
                {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid,int r,int c)
    {
        int rowLength=grid.length;
        int columnLength=grid[0].length;
        Queue<int []> queue=new LinkedList<>();
        queue.offer(new int[]{r,c});
        int[][] directions={{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!queue.isEmpty())
        {
            int[] current=queue.poll();
            int currentRow=current[0];
            int currentColumn=current[1];
            for(int[] direction:directions)
            {
                int newRow=currentRow+direction[0];
                int newColumn=currentColumn+direction[1];
                if(newRow>=0&&newRow<rowLength&&newColumn>=0&&newColumn<columnLength&&grid[newRow][newColumn]=='1')
                {
                    queue.offer(new int[]{newRow, newColumn});
                    grid[newRow][newColumn]='0';
                }
            }
        }
    }

    

    

    public static void main(String[] args) {
        NumberOfIslands_LC200 solution = new NumberOfIslands_LC200();

        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of islands: " + solution.numIslands(grid));
    }
}
