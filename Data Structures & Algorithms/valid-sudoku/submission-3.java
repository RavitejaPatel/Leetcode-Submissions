class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
       Set<Character>[] row = new HashSet[9];
       Set<Character>[] col = new HashSet[9];
       Set<Character>[] block = new HashSet[9];

           // Initialize the sets
       for (int i = 0; i < 9; i++) {
           row[i] = new HashSet<>();
           col[i] = new HashSet<>();
           block[i] = new HashSet<>();
       }

       for(int i=0;i<9;i++)
       {
        for(int j=0;j<9;j++)
        {
            char curr = board[i][j];

             if(curr=='.')
    			   continue;
            
            //ROW Check
            if(row[i].contains(curr))
                return false;
            row[i].add(curr);

            //COL check
            if(col[j].contains(curr))
                return false;
            col[j].add(curr);

            //Block Check
/*
 * Context:
    In a 9x9 Sudoku grid, there are 9 smaller 3x3 blocks (also called "subgrids" or "boxes").
    These blocks are arranged as follows:

    mathematica
    Copy
    Block 1 | Block 2 | Block 3
    ---------------------------
    Block 4 | Block 5 | Block 6
    ---------------------------
    Block 7 | Block 8 | Block 9
    The idea is to calculate a unique index for each 3x3 block 
    so that we can easily determine which block a given cell (i, j) belongs to.

    Breaking down the formula:
    Dividing by 3:

    The expression (i / 3) gives the "row" number of the 3x3 blocks.
    The expression (j / 3) gives the "column" number of the 3x3 blocks.

    This division by 3 works because the grid is divided into 3 groups of 3 rows and 3 columns. 
    So, every 3 rows belong to a single group (block), and every 3 columns belong to a single group (block).

    Multiplying by 3:
    We multiply (i / 3) by 3 to scale it up, so it can be used to determine the "block row".
    This is necessary because, for example, if i = 4 (the 5th row), then (i / 3) gives 1, 
    indicating it's in the second block row (i.e., Block 4, Block 5, or Block 6).	
    So, multiplying by 3 ensures the correct block grouping.

    Adding (j / 3):
    The expression (j / 3) gives the "column" number of the 3x3 blocks.
    Adding this to (i / 3) * 3 helps in computing the unique block index.

    Example Walkthrough:
    Let’s take an example with specific values for i and j.
    Suppose i = 4 and j = 5 (i.e., the cell is in row 5, column 6 of the grid).
    
    Step-by-step calculation:
    Row Division: (i / 3)
    i = 4, so i / 3 = 4 / 3 = 1 (integer division).
    This means the 5th row (row 4, 0-indexed) belongs to the second block row (blocks 4, 5, 6).
    Column Division: (j / 3)
    j = 5, so j / 3 = 5 / 3 = 1 (integer division).
    This means the 6th column (column 5, 0-indexed) belongs to the second block column (blocks 2, 5, 8).
    Combining Row and Column Information:
    Now, calculate the block index: blockIndex = (i / 3) * 3 + (j / 3)
    blockIndex = 1 * 3 + 1 = 3 + 1 = 4.
    So, for the cell (4, 5) (5th row, 6th column), the block index is 4, meaning it's in Block 5.
 */
            int blockIdx = (i/3)*3+(j/3);

            if(block[blockIdx].contains(curr))
                return false;
            block[blockIdx].add(curr);

        }
       }
    return true;
    }
}
