class Solution 
{
    public void islandsAndTreasure(int[][] grid) 
    {
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 0)
                {
                    q.add(new int[]{i,j});
                }
            }
        }

        int[][] directions = {
            {1,0},{-1,0},{0,1},{0,-1}
        };

        while(!q.isEmpty())
        {
            int[] idx = q.poll();

            for(int[] dir : directions)
            {
                int r = dir[0]+idx[0];
                int c = dir[1]+idx[1];

                if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]==Integer.MAX_VALUE)
                {
                    grid[r][c] = grid[idx[0]][idx[1]]+1;
                    q.offer(new int[]{r,c});
                }
            }
        }
    }
}
