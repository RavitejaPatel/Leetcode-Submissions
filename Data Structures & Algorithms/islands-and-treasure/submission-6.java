class Solution 
{
    public void islandsAndTreasure(int[][] grid) 
    {
        if (grid == null || grid.length == 0) return;
        
        Queue<int[]> q = new ArrayDeque<>();

        int R = grid.length;
        int C = grid[0].length;

        int dist=1;
        int[][] dirs = {
            {0,1},{1,0},{0,-1},{-1,0}
        };
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(grid[i][j] == 0)
                {
                    q.add(new int[]{i,j});
                    // bfs(i,j,grid,q,dirs,dist,R,C);
                    dist=0;
                }
            }
        }

        bfs(grid,q,dirs,dist,R,C);
       
    }

    private void bfs(int[][] grid, Queue<int[]> q,int[][] dirs, int dist, int R, int C)
    {
        while(!q.isEmpty())
        {
            int[] idx = q.poll();
            int rIdx = idx[0];
            int cIdx = idx[1];

            for(int[] dir : dirs)
            {
                int nr = dir[0]+rIdx;
                int nc = dir[1]+cIdx;

                if(nr>=0 && nr<R && nc>=0 && nc<C && grid[nr][nc]==Integer.MAX_VALUE)
                {
                    grid[nr][nc] = grid[rIdx][cIdx]+1;;
                    // dist+=1;
                    q.add(new int[]{nr,nc}); 
                }
            }
            dist+=1;
        }
    }
}
