class Solution 
{
	public int orangesRotting(int[][] grid) 
    {
        int min=0;
        int R = grid.length;
        int C = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCt = 0;
       

        
        for(int i=0;i<R;i++)
        {
        	for(int j=0;j<C;j++)
        	{
        		if(grid[i][j] == 2)
        		{
        			q.offer(new int[]{i,j});
        		}
                 if (grid[i][j] == 1) 
                {
                   freshCt++; 
                }
        	}
        }

         int[][] directions = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };

        while(!q.isEmpty() && freshCt>0)
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                int[] cell = q.poll();
				int r1 = cell[0];
				int c1 = cell[1];

                for(int[] dir : directions)
                {
                    int row = dir[0]+r1;
                    int col = dir[1]+c1;

                    if(isNotInRange(row,col,q,grid,R,C))
                        continue ;
                    
                    // if (row < 0 || row >= R || col < 0 || col >= C || grid[row][col] != 1) {
                    //     continue;
                    // }

                    q.add(new int[]{row,col});
                    grid[row][col] = 2;
                    freshCt-=1;
                }
            }
            min+=1;
        }

       // System.out.println(min);
        return freshCt == 0 ? min : -1;
    }
	
	private boolean isNotInRange(int i, int j, Queue<int[]> q, int[][] grid, int R, int C)
	{
		if(i < 0 || i == R || j < 0 || j==C  || grid[i][j] != 1 )
            return true;

        return false;
	}
	
}
