class Solution 
{
    public int maxAreaOfIsland(int[][] grid) 
    {
        int R = grid.length;
        int C = grid[0].length;
        boolean[][] isVisited = new boolean[R][C];
        int maxLen = 0;

        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(grid[i][j]==1 && !isVisited[i][j])
                {
                    maxLen = Math.max(dfs(grid,i,j,isVisited,R,C), maxLen);
                }
            }
        }
        return maxLen;
        
    }

    private int dfs(int[][] grid,int i, int j, boolean[][] isVisited, int R, int C)
    {
        if(!isInBounder(i,j,grid,isVisited, R,C))
            return 0;

        isVisited[i][j] = true;
         
        return 
            1 + 
            dfs(grid, i+1, j, isVisited, R, C)
            + 
            dfs(grid, i-1, j, isVisited, R, C)
            +
            dfs(grid, i, j+1, isVisited, R, C)
            +
            dfs(grid, i, j-1, isVisited, R, C);
    }

    private boolean isInBounder(int i, int j, int[][] grid, boolean[][] isVisited, int R, int C)
    {
        return i>=0 && i<R && j>=0 && j<C && isVisited[i][j]==false && grid[i][j]==1;
    } 

}
