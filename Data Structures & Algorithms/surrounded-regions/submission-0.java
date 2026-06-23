class Solution {
   
public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) return;

    int rows = board.length;
    int cols = board[0].length;

    // Step 1: iterate over borders and start DFS from any 'O'
    // top and bottom rows
    for (int j = 0; j < cols; j++) {
        if (board[0][j] == 'O') dfs(board, 0, j, rows, cols);
        if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j, rows, cols);
    }
    // left and right columns
    for (int i = 0; i < rows; i++) {
        if (board[i][0] == 'O') dfs(board, i, 0, rows, cols);
        if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1, rows, cols);
    }

    // Step 3: flip remaining
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (board[i][j] == 'O') board[i][j] = 'X';   // captured
            else if (board[i][j] == '#') board[i][j] = 'O'; // safe
        }
    }
}

private void dfs(char[][] board, int r, int c, int rows, int cols) {
    // stop if out of bounds or not an 'O'
    if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O') return;

    board[r][c] = '#'; // mark this 'O' as safe

    // explore 4-directional neighbors
    dfs(board, r + 1, c, rows, cols);
    dfs(board, r - 1, c, rows, cols);
    dfs(board, r, c + 1, rows, cols);
    dfs(board, r, c - 1, rows, cols);
}

}
