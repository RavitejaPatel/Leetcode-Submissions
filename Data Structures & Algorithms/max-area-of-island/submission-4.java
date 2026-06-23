class Solution 
{
    //int area=0;
    public int maxAreaOfIsland(int[][] grid) 
    {
        if(grid==null || grid.length<=0)
            return 0;
        
        int R = grid.length;
        int C = grid[0].length;
        int maxArea = 0;
        

        boolean[][] visited = new boolean[R][C];
        int[][] dirs = {
            {0,1},{1,0},{0,-1},{-1,0}
        };

        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(grid[i][j]==1 && !visited[i][j])
                {
                    
                    maxArea = Math.max(maxArea, dfs(i,j,visited,grid,R,C,dirs));
                    //area=0;
                }   
            }
        }
        return maxArea;
    }

    private int dfs(int r, int c, boolean[][] visited, int[][] grid, int R, int C, int[][] dirs)
    {
        if(r<0 || r>=R || c<0 || c>=C || grid[r][c]==0 || visited[r][c])
            return 0;
        
        visited[r][c] = true;
        int area=1;// count this land cell
        
        for(int[] dir : dirs)
        {
            int rIdx = dir[0];
            int cIdx = dir[1];

            int nr = rIdx+r;
            int nc = cIdx+c;

            area += dfs(nr,nc,visited,grid,R,C,dirs);
            System.out.print("-"+area);
        }
        System.out.println();
        return area;
    }
}
