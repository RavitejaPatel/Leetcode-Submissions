class Solution 
{
  public void solve(char[][] board) 
    {
		int row = board.length;
		int col = board[0].length;
		
		int[][] dirs = {
		        {-1,0},
		        {1,0},
		        {0,-1},
		        {0,1}
			};
		
		//first row last row
		for(int i=0;i<col;i++)
		{
			if(board[0][i] == 'O')
			{
				dfs(board, 0, i, row,col, dirs);
			}
			
			if(board[row-1][i] == 'O')
			{
				dfs(board, row-1, i, row, col, dirs);
			}
		}
		
		//left right col
		for(int i=0;i<row;i++)
		{
			if(board[i][0] == 'O')
			{
				dfs(board, i, 0, row, col, dirs);
			}
			
			if(board[i][col-1] == 'O')
			{
				dfs(board, i, col-1, row, col, dirs);
			}
		}
		
		// print
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
        
		// Step 3: flip remaining
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(board[i][j] == 'O')
					board[i][j] = 'X';
				
				else if(board[i][j] == '#')
					board[i][j] = 'O';
					
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
        
    }

    	private void dfs(char[][] board, int r, int c, int row, int col, int[][] dirs)
	{
		if(r<0 || r>=row || c<0 || c>=col || board[r][c] != 'O')
			return;
		
		board[r][c] = '#';
		
		for(int[] dir : dirs)
		{
			int nr = dir[0]+r;
			int nc = dir[1]+c;
			
			dfs(board, nr, nc, row, col, dirs);
		}
	}
}