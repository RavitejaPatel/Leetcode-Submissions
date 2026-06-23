class Solution 
{
    public int orangesRotting(int[][] grid) 
    {
        int totalMin = 0;
        int freshCt = 0;

        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new int[]{i,j});
                }
                if (grid[i][j] == 1) 
                {
                   freshCt++; 
                }
            }
        }

        int[][] directions = {
            {1,0},{-1,0},{0,1},{0,-1}
        };

        while(!q.isEmpty() && freshCt > 0)
        {
            int size = q.size();

            for (int i = 0; i < size; i++) 
            {
                int[] idx = q.poll();

                int r = idx[0];
                int c = idx[1];

                for(int[] dir : directions)
                {
                    int nextRow = r+dir[0];
                    int nextCol = c+dir[1];

                    if( nextRow>=0 && nextRow<grid.length && nextCol>=0 && nextCol<grid[0].length && grid[nextRow][nextCol] == 1)
                    {
                        grid[nextRow][nextCol] = 2;
                        q.add(new int[]{nextRow,nextCol});
                        
                        freshCt-=1;
                    }
                }
            
            }

            
            totalMin+=1;
        }
        
        return freshCt==0 ? totalMin : -1;
    }
}
