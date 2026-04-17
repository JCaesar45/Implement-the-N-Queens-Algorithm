function dfsNQueens(n) {
    if (n < 1) return [];
    
    const solutions = [];
    const board = new Array(n).fill(-1);
    
    function isValid(row, col) {
        // Check all previous rows
        for (let i = 0; i < row; i++) {
            // Same column
            if (board[i] === col) return false;
            // Same diagonal
            if (Math.abs(board[i] - col) === Math.abs(i - row)) return false;
        }
        return true;
    }
    
    function dfs(row) {
        if (row === n) {
            // Found a valid solution
            solutions.push([...board]);
            return;
        }
        
        for (let col = 0; col < n; col++) {
            if (isValid(row, col)) {
                board[row] = col;
                dfs(row + 1);
                board[row] = -1; // Backtrack
            }
        }
    }
    
    dfs(0);
    return solutions;
}
