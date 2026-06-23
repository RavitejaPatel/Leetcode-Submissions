class Solution {
public boolean exist(char[][] board, String word) 
	{
		boolean[][] isVisited = new boolean[board.length][board[0].length];

		 for(int i=0;i<board.length;i++)
		 {
			 for(int j=0;j<board[0].length;j++)
			 {
				 if(dfs(i,j,board,isVisited, 0, word))
					 return true;
			 }
		 }
        return false;
    }
	
	public boolean dfs(int i, int j, char[][] board, boolean[][] isVisited, int index, String word)
	{
      if(index==word.length())
			 return true;

		if(!isInRange(board,i,j))
			return false;
        
        if(board[i][j] != word.charAt(index))
			 return false;
		
		char temp = board[i][j];
		board[i][j] = '#';
		
		
		boolean found =
				dfs(i+1,j, board, isVisited, index+1, word) 
				||
				dfs(i,j+1, board, isVisited, index+1,word )
				||
				dfs(i-1,j, board, isVisited, index+1,word )
				||
				dfs(i,j-1, board, isVisited, index+1,word);
		
		board[i][j] = temp;
		return found;
	}
	
	private boolean isInRange(char[][] board, int i, int j)
	{
		return i>=0 && i<board.length && j>=0 && j<board[0].length ;
	}
}
