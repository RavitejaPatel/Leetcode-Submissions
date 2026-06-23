
class Solution {
    public boolean exist(char[][] board, String word) {
        int R = board.length;
        int C = board[0].length;
        boolean[][] visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (dfs(board, word, i, j, R, C, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int R, int C, int idx, boolean[][] visited) {
        // Out of bounds
        if (r < 0 || r >= R || c < 0 || c >= C) return false;

        // Already used on current path
        if (visited[r][c]) return false;

        // Character mismatch
        if (board[r][c] != word.charAt(idx)) return false;

        // If we've matched the last character, success
        if (idx == word.length() - 1) return true;

        // Choose: mark visited
        visited[r][c] = true;

        // Explore neighbors
        boolean found =
            dfs(board, word, r + 1, c, R, C, idx + 1, visited) ||
            dfs(board, word, r - 1, c, R, C, idx + 1, visited) ||
            dfs(board, word, r, c + 1, R, C, idx + 1, visited) ||
            dfs(board, word, r, c - 1, R, C, idx + 1, visited);

        // Unchoose: unmark visited for backtracking
        visited[r][c] = false;

        return found;
    }
}
