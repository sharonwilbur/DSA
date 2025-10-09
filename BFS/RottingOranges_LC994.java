package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_LC994 {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int column=grid[0].length;
        int freshCount=0;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(grid[i][j]==1) freshCount++;
                else if(grid[i][j]==2) queue.offer(new int[]{i,j});
            }
        }
        if(freshCount==0) return 0;
        return bfs(grid,queue, freshCount);
    }

    public int bfs(int[][] grid, Queue<int[]> queue, int freshCount) {
        int rowLength=grid.length;
        int columnLength=grid[0].length;
        int[][] directions={{1,0}, {-1,0}, {0,1}, {0,-1}};
        int minutes=0;
        while(!queue.isEmpty()&& freshCount>0)
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                int[] current=queue.poll();
                int currentRow=current[0];
                int currentColumn=current[1];
                for(int[] direction:directions)
                {
                    int newRow=currentRow+direction[0];
                    int newColumn=currentColumn+direction[1];
                    if(newRow>=0&&newRow<rowLength&&newColumn>=0&&newColumn<columnLength&&grid[newRow][newColumn]==1)
                    {
                        grid[newRow][newColumn]=2;
                        queue.offer(new int [] {newRow, newColumn});
                        freshCount--;
                        
                    }
                }
            }
             minutes++;
        }
        if(freshCount==0) return minutes;
        else return -1;
    }

    // Sample main method for testing
    public static void main(String[] args) {
        RottingOranges_LC994 solution = new RottingOranges_LC994();

        int[][] grid1 = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        int result1 = solution.orangesRotting(grid1);
        
        System.out.println("Minutes until all oranges rot (grid1): " + result1);
        // Expected output: 4

        int[][] grid2 = {
            {2,1,1},
            {0,1,1},
            {1,0,1}
        };

        int result2 = solution.orangesRotting(grid2);
        System.out.println("Minutes until all oranges rot (grid2): " + result2);
        // Expected output: -1 (some oranges cannot rot)
    }
}
