def dfsNQueens(n):
    if n < 1:
        return []
    
    solutions = []
    board = [-1] * n
    
    def is_valid(row, col):
        # Check all previous rows
        for i in range(row):
            # Same column
            if board[i] == col:
                return False
            # Same diagonal
            if abs(board[i] - col) == abs(i - row):
                return False
        return True
    
    def dfs(row):
        if row == n:
            # Found a valid solution
            solutions.append(board.copy())
            return
        
        for col in range(n):
            if is_valid(row, col):
                board[row] = col
                dfs(row + 1)
                board[row] = -1  # Backtrack
    
    dfs(0)
    return solutions
