class Coordinate{
    int x;
    int y;
    public Coordinate (int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    markBFS(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void markBFS(boolean[][] grid, int x, int y) {
        int[] directionX = {0,1,-1,0};
        int[] directionY = {1,0,0,-1};

        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        queue.offer(new Coordinate(x,y));
        grid[x][y] = false;

        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate adj = new Coordinate(coor.x + directionX[i], coor.y + directionY[i]);
                if (!inBound(adj,grid)) {
                    continue;
                }
                if (grid[adj.x][adj.y]) {
                    grid[adj.x][adj.y] = false;
                    queue.offer(adj);
                }
            }
        }
    }
    private boolean inBound(Coordinate adj, boolean[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return adj.x >= 0 && adj.x < n && adj.y >= 0 && adj.y < m;
    }
}
