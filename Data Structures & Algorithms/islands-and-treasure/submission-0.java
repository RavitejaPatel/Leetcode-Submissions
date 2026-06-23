class Solution 
{
    public void islandsAndTreasure(int[][] grid) 
    {
        int ROWS = grid.length;
	    if (ROWS == 0) return;
	    int COLS = grid[0].length;

        boolean[][] visited = new boolean[ROWS][COLS];
        Queue<int[]> q = new LinkedList<>();
    
        for(int r=0;r<ROWS;r++)
        {
            for(int c=0;c<COLS;c++)
            {
                if(grid[r][c] == 0)
                {
                    q.offer(new int[]{r,c});
                    visited[r][c] = true;
                }
            }
        }

        int dist = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i=0;i<size;i++)
            {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];

                grid[r][c] = dist;
             
                addRoom(r + 1, c, visited, q, grid, ROWS, COLS);
                addRoom(r - 1, c, visited, q, grid, ROWS, COLS);
                addRoom(r, c + 1, visited, q, grid, ROWS, COLS);
                addRoom(r, c - 1, visited, q, grid, ROWS, COLS);
            }
            dist+=1;
        }
    }

    private void addRoom(int i, int j, boolean[][] visited, Queue<int[]> q, int[][] grid, int R, int C)
    {
        // if(isNotInRange(i,j,visited,q,grid,R,C))
        //     return ;
            if (i < 0 || i == R || j < 0 || j == C ||
	            visited[i][j] || grid[i][j] == -1) {
	            return;
	        }
        
        q.offer(new int[]{i,j});
        visited[i][j] = true;
        
    }

    private boolean isNotInRange(int i, int j, boolean[][] visited, Queue<int[]> q, int[][] grid, int R, int C)
	{
		if(i<0 || i==R || j<0 && j==C || visited[i][j] || grid[i][j] == -1)
            return true;

        return false;
	}
}
