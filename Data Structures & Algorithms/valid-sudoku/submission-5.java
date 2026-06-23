class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        int R = board.length;
        int C = board[0].length;

        Set<Character>[] row = new HashSet[R];
        Set<Character>[] col = new HashSet[C];
        Set<Character>[] block = new HashSet[R];

        for(int i=0;i<R;i++)
        {
            row[i] = new HashSet();
            col[i] = new HashSet();
            block[i] = new HashSet();
        }

        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                char curr = board[i][j];

                if(curr=='.')
                    continue;
                    
                //rowset check
                if(row[i].contains(curr))
                    return false;
                row[i].add(curr);
                
                //col set check
                if(col[j].contains(curr))
                    return false;
                col[j].add(curr);

                //block check
                //getting curr block with i,j
                int blockIdx = (i/3)*3+(j/3);
                if(block[blockIdx].contains(curr))
                    return false;
                block[blockIdx].add(curr);
            }
        }
        return true;

    }
}
