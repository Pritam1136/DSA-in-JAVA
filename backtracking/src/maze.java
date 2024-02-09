public class maze {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
mazeInAllDirection("", board,0,0);
    }
    static void mazeInAllDirection(String p, boolean[][] maze, int r, int c){
        if (r == maze.length-1 && c == maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if (!maze[r][c]){
            return;
        }
        maze[r][c]  = false;
        if (r < maze.length - 1){
            mazeInAllDirection(p + 'D', maze, r+1, c);
        }
        if (c < maze[0].length - 1){
            mazeInAllDirection(p + 'R', maze, r, c + 1);
        }
        if (r > 0){
            mazeInAllDirection(p+ 'U', maze, r-1, c);
        }
        if (c > 0){
            mazeInAllDirection(p+ 'L', maze, r, c-1);
        }
        maze[r][c] = true;
    }
}
