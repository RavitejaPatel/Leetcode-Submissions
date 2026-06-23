class Solution 
{
    public int numIslands(char[][] grid) 
    {
        int count = 0;
        int R = grid.length;
        int C = grid[0].length;

        boolean[][] isVisited = new boolean[R][C];
      for(int i=0;i<R;i++)
      {
        for(int j=0;j<C;j++)
        {
            if (grid[i][j] == '1' && !isVisited[i][j])
            {
                dfs(grid, isVisited, i, j);

                count+=1;
            }
        }
      }  
      return count;
    }

    private void dfs(char[][] grid, boolean[][] isVisited, int i, int j)
    {
        if(isInRange(i,j,isVisited,grid))
        {
            return ;
        }

        isVisited[i][j] = true;

         
            dfs(grid, isVisited, i-1, j);
            dfs(grid, isVisited, i, j-1);
            dfs(grid, isVisited, i+1, j);
            dfs(grid, isVisited, i, j+1);

    }

    private boolean isInRange(int i, int j, boolean[][] isVisited, char[][] grid)
    {
        return ( i<0 || i>=grid.length || j<0 || j>=grid[0].length || isVisited[i][j] || grid[i][j] != '1');
    }
}
