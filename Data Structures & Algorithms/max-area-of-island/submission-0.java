class Solution 
{
    public int maxAreaOfIsland(int[][] grid) 
    {

        int count = 0;
        int R = grid.length;
        int C = grid[0].length;

        boolean[][] isVisited = new boolean[R][C];
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if (grid[i][j] == 1 && !isVisited[i][j])
                {
                    int temp = dfs(grid, isVisited, i, j);
                    System.out.println(temp +" - ");
                    count = Math.max(temp, count);
                }
            }
        }  
      return count; 
    }

    private int dfs(int[][] grid, boolean[][] isVisited, int i, int j)
    {
        if(isNotInRange(i,j,isVisited,grid))
        {
            return 0;
        }
    

        isVisited[i][j] = true;

         
        int count = 
            1 + dfs(grid, isVisited, i-1, j) + 
            dfs(grid, isVisited, i, j-1) +
            dfs(grid, isVisited, i+1, j) +
            dfs(grid, isVisited, i, j+1);

        return count;
    }

    private boolean isNotInRange(int i, int j, boolean[][] isVisited, int[][] grid)
    {
        return ( i<0 || i>=grid.length || j<0 || j>=grid[0].length || isVisited[i][j] || grid[i][j] != 1);
    }
}
