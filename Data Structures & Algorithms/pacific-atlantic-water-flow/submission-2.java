class Solution 
{
    public List<List<Integer>> pacificAtlantic(int[][] heights) 
	{
		
		int R = heights.length;
		int C = heights[0].length;

		Queue<int[]> qa = new LinkedList<>();
		boolean[][] atlanticVisited = new boolean[R][C];

		Queue<int[]> qp = new LinkedList<>();
		boolean[][] pacificVisited = new boolean[R][C];

		//first and last row
		for(int i=0;i<C;i++)
		{
			qp.offer(new int[]{0,i});
			pacificVisited[0][i] = true;
			qa.offer(new int[]{R-1,i});
			atlanticVisited[R-1][i] = true;
		}

		for(int i=0;i<R;i++)
		{
			qp.offer(new int[]{i,0});
			pacificVisited[i][0] = true;
			qa.offer(new int[]{i,C-1});
			atlanticVisited[i][C-1] = true;
		}

		int[][] dirs = {
			{0,1},{1,0}, {0,-1},{-1,0}
		};
	
		dfs(qp,pacificVisited,heights,dirs,R,C);
		dfs(qa,atlanticVisited,heights,dirs,R,C);


		List<List<Integer>> res = new ArrayList<>();
		for(int i=0;i<R;i++)
		{
			for(int j=0;j<C;j++)
			{
				if(pacificVisited[i][j] && atlanticVisited[i][j])
				{
					List<Integer> temp = new ArrayList<>();
					temp.add(i);
					temp.add(j);
					res.add(temp);
				}
			}
		}

	return res;
	}

	private void dfs(Queue<int[]> q, boolean[][] visited, int[][] heights, int[][] dirs, int R, int C)
	{

		while(!q.isEmpty())
		{
			int[] currCell = q.poll();

			for(int[] dir : dirs)
			{
				int nr = currCell[0]+dir[0];
				int nc = currCell[1]+dir[1];

				if(nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc])
					continue;
				
				if(heights[nr][nc] >= heights[currCell[0]][currCell[1]])
				{
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
	}
}
