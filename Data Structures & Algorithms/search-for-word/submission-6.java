class Solution 
{
    public boolean exist(char[][] board, String word) 
	{
		int R = board.length;
		int C = board[0].length;
		boolean[][] visited = new boolean[R][C];
		for(int i=0;i<R;i++)
		{
			for(int j=0;j<C;j++)
			{
				if(dfs(board,word,i,j,R,C,0))
					return true;
			}
		}
		return false;
    }
	private boolean dfs(
		char[][] board, String word,int r,int c,int R,int C,int idx)
	{
		if(idx==word.length())
			 return true;
			 
		if(r<0 || r>=R || c<0 || c>=C)
			return false;

		// if(word.equals(str))
		// 	return true;
		if(board[r][c] != word.charAt(idx))
			 return false;

		char temp = board[r][c];
		board[r][c] = '#';
		
		boolean found = 
			dfs(board,word,r+1,c,R,C,idx+1)
			||
			dfs(board,word,r,c+1,R,C,idx+1)
			||
			dfs(board,word,r-1,c,R,C,idx+1)
			||
			dfs(board,word,r,c-1,R,C,idx+1);

		board[r][c] = temp;
		
		return found;
	}
}
