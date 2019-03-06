

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */

    int n,m;
    int[] directionX = {1,1,-1,-1,2,2,-2,-2};
    int[] directionY = {2,-2,2,-2,1,-1,1,-1};//TMD 这题必须把这个放在主函数的外面不然就会报错
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here  
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        n = grid.length;
        m = grid[0].length;

        int res = 0;



        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();

                if (point.x == destination.x && point.y == destination.y) {
                    return res;
                }

                for (int j = 0; j < 8; j++) {
                    Point nextPoint = new Point(point.x + directionX[j], point.y + directionY[j]);

                    if(!inBound(nextPoint, grid)) {
                        continue;
                    }
                    queue.offer(nextPoint);
                    grid[nextPoint.x][nextPoint.y] = true;
                }
            }
            res++;
        }
        return -1;
    }

    private boolean inBound(Point point, boolean[][] grid) {

        return point.x >= 0 && point.x < n && point.y >= 0 && point.y < m && grid[point.x][point.y] == false;
    }
}
