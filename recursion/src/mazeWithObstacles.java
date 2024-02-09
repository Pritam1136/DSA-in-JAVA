public class mazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
mazeWithObstacle("", board, 0, 0);
    }
    static void mazeWithObstacle(String p, boolean[][] maze, int row, int col){
        if (row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return ;
        }
        if (!maze[row][col]){
            return ;
        }
        if (row < maze.length - 1){
            mazeWithObstacle(p+'V',maze, row+1, col);
        }
        if (col < maze[0].length - 1){
            mazeWithObstacle(p+'H',maze, row, col+1);
        }
    }
}
