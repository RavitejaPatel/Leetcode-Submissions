class Solution {
 public List<List<Integer>> pacificAtlantic(int[][] heights) 
	{
		List<List<Integer>> results = new ArrayList<>();
		
		//Finding cells which flows to pacific ocean
		int Row = heights.length;
		int Col = heights[0].length;
		
		boolean[][] pacific = new boolean[Row][Col];
		boolean[][] atlantic = new boolean[Row][Col];
		
		Queue<int[]> pacificQueue = new LinkedList<>();
		Queue<int[]> atlanticQueue = new LinkedList<>();
		
		//Add top row bottom row
		for(int c=0;c<Col;c++)
		{
			pacificQueue.offer(new int[] {0,c});
			pacific[0][c] = true;
			
			atlanticQueue.offer(new int[] {Row-1,c});
			atlantic[Row-1][c] = true;
		}
		
		
		//Add left col right col
		for(int r=0;r<Row;r++)
		{
			pacificQueue.offer(new int[] {r,0});
			pacific[r][0] = true;
			
			atlanticQueue.offer(new int[] {r,Col-1});
			atlantic[r][Col-1] = true;
		}
		
		int[][] directions = {
	        {-1,0},
	        {1,0},
	        {0,-1},
	        {0,1}
		};
		
		bfs(directions, pacificQueue, pacific, Row, Col, heights);
		bfs(directions, atlanticQueue, atlantic, Row, Col, heights);
		
		for(int i=0;i<Row;i++)
		{
			for(int j=0;j<Col;j++)
			{
				if(pacific[i][j] && atlantic[i][j])
				{
					List<Integer> curr = new ArrayList<>();
					curr.add(i);
					curr.add(j);
					results.add(curr);
				}
			}
		}
		
		System.out.println(results);
		
		return results;
		   
	}
	
	private void bfs(int[][] directions, Queue<int[]> queue, boolean[][] visited, int R, int C, int[][] heights)
	{
		while(!queue.isEmpty())
		{
			int[] currCell = queue.poll();
			//00
			int r = currCell[0];
			int c = currCell[1];
			
			for(int[] dir : directions)
			{
				int nextRow = r+dir[0];
				int nextCol = c+dir[1];
				
				if(nextRow<0 || nextRow>=R || nextCol<0 || nextCol>=C || visited[nextRow][nextCol])
					continue;
				
				if(heights[nextRow][nextCol] >= heights[r][c])
				{
					visited[nextRow][nextCol] = true;
					queue.offer(new int[] {nextRow, nextCol});
				}
			}
		}
		
	}
}
