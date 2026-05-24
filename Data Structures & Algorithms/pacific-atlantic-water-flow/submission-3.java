class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // constraints: if height equal or lower than the curr height && inBounds => dfs
        // mark visited as path
        int rows = heights.length;
        int columns = heights[0].length;

        Set<Integer> pacificVisited = new HashSet<>();
        Set<Integer> atlanticVisited = new HashSet<>();

        for (int row = 0; row < rows; row++) {
            dfs(row, 0, heights, pacificVisited);
            dfs(row, columns - 1, heights, atlanticVisited);
        }
        for (int column = 0; column < columns; column++) {
            dfs(0, column, heights, pacificVisited);
            dfs(rows - 1, column, heights, atlanticVisited);
        }

        List<List<Integer>> result = new ArrayList();
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int id = row * columns + column; // transforma (r,c) em um numérico
                if (pacificVisited.contains(id) && atlanticVisited.contains(id)) {
                    result.add(Arrays.asList(row, column));
                }
            }
        }
        return result;
    }

    static void dfs(int row, int column, int[][] grid, Set<Integer> visited) {
        int rows = grid.length;
        int columns = grid[0].length;

        int[] rowDelta = {-1, 1, 0, 0};
        int[] colDelta = {0, 0, -1, 1};
        visited.add(row * columns + column);

        for (int direction = 0; direction < 4; direction++) {
            int neighborRow = row + rowDelta[direction];
            int neighborCol = column + colDelta[direction];

            if (neighborRow >= 0 && neighborRow < rows && 
                neighborCol >= 0 && neighborCol < columns) {
                boolean isSmaller = grid[neighborRow][neighborCol] >= grid[row][column];
                boolean isUnvisited = !visited.contains(neighborRow * columns + neighborCol);
                
                if (isUnvisited && isSmaller) {
                    dfs(neighborRow, neighborCol, grid, visited);
                }
            }
        }
    }
}
