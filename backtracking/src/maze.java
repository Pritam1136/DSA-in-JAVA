import java.util.Arrays;

public class maze {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[board.length][board[0].length];
mazeInAllDirection("", board,0,0);
        System.out.println("------------------------------------------");
mazeInAllDirectionWithPath("",board,0,0,path,1);
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
//        This line is where the function will get over
//        so before the function gets over, also remove the changes that were made by that function.
        maze[r][c] = true;
    }
    static void mazeInAllDirectionWithPath(String p, boolean[][] maze, int r, int c,int[][] path, int step){
        if (r == maze.length-1 && c == maze[0].length - 1){
            path[r][c] = step;
            for (int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[r][c]){
            return;
        }
        maze[r][c]  = false;
        path[r][c] = step;
        if (r < maze.length - 1){
            mazeInAllDirectionWithPath(p + 'D', maze, r+1, c, path, step+1);
        }
        if (c < maze[0].length - 1){
            mazeInAllDirectionWithPath(p + 'R', maze, r, c + 1, path, step+1);
        }
        if (r > 0){
            mazeInAllDirectionWithPath(p+ 'U', maze, r-1, c, path, step+1);
        }
        if (c > 0){
            mazeInAllDirectionWithPath(p+ 'L', maze, r, c-1, path, step+1);
        }
//        This line is where the function will get over
//        so before the function gets over, also remove the changes that were made by that function.
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
