class Solution 
{
 	public boolean isValidSudoku(char[][] board) 
    {
		int R = board.length;
		int C = board[0].length;
		
		//Step1 : Declaring appropriate data structures
		Set<Character>[] rowSet = new HashSet[9];
		Set<Character>[] colSet = new HashSet[9];
		Set<Character>[] cellSet = new HashSet[9];
		
		//Step2 : Initialize our ArraySet with set for us to progress with step 3
		for(int i=0;i<9;i++)
		{
			rowSet[i] = new HashSet<Character>();
			colSet[i] = new HashSet<Character>();
			cellSet[i] = new HashSet<Character>();
		}
		
		
		
		//Set 3 -> Travelling through board and feeding our sets
		
		for(int i=0;i<9;i++)
		{	
			for(int j=0;j<9;j++)
			{
				char curr = board[i][j];
				
				if(curr=='.')
	    			   continue;
				
				//step3-a checking at Adding to rows
				if(rowSet[i].contains(curr)) return false;
				rowSet[i].add(curr);
				
				//step3-b checking at Adding to cols
				if(colSet[j].contains(curr)) return false;
				colSet[j].add(curr);
				
				//step3-c checking at Adding to cols  ....If you need to research more take break here, write a separete code on how to find cells in a N*N matrix
				int rowBlock = i/3;//4
				int colBlock = j/3;//5
				
				int blockIdx = (rowBlock*3+colBlock);
				
				if(cellSet[blockIdx].contains(curr)) return false;
				cellSet[blockIdx].add(curr);
				
			}
			
		}
		
		return true;
    }
}
