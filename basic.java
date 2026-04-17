import java.util.ArrayList;
import java.util.List;

public class NQueensSolver {
    
    public static List<List<Integer>> dfsNQueens(int n) {
        List<List<Integer>> solutions = new ArrayList<>();
        
        if (n < 1) {
            return solutions;
        }
        
        int[] board = new int[n];
        for (int i = 0; i < n; i++) {
            board[i] = -1;
        }
        
        dfs(solutions, board, n, 0);
        return solutions;
    }
    
    private static boolean isValid(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            // Same column
            if (board[i] == col) return false;
            // Same diagonal
            if (Math.abs(board[i] - col) == Math.abs(i - row)) return false;
        }
        return true;
    }
    
    private static void dfs(List<List<Integer>> solutions, int[] board, int n, int row) {
        if (row == n) {
            // Found a valid solution
            List<Integer> solution = new ArrayList<>();
            for (int col : board) {
                solution.add(col);
            }
            solutions.add(solution);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                board[row] = col;
                dfs(solutions, board, n, row + 1);
                board[row] = -1; // Backtrack
            }
        }
    }
    
    // Test the implementation
    public static void main(String[] args) {
        System.out.println("n=1: " + dfsNQueens(1));  // [[0]]
        System.out.println("n=2: " + dfsNQueens(2));  // []
        System.out.println("n=3: " + dfsNQueens(3));  // []
        System.out.println("n=4: " + dfsNQueens(4));  // [[1,3,0,2], [2,0,3,1]]
        System.out.println("n=5 count: " + dfsNQueens(5).size());  // 10
        System.out.println("n=8 count: " + dfsNQueens(8).size());  // 92
    }
}
