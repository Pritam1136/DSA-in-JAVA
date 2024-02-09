import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(ways(3,3));
        path("", 3, 3);
        System.out.println("-----------------------------------------");
        System.out.println(pathRet("", 3, 3));
        System.out.println("----------------------------------------");
        System.out.println(pathRetDiagnal("", 3, 3));
    }
    static long ways(int row, int col){
        if (row == 1 || col == 1){
            return 1;
        }
        long  count = 0;
            count = count + (ways(row-1, col));
            count = count + (ways(row, col - 1));
        return count;
    }
    static void path(String p, int row, int col){
        if (row == 1 && col == 1){
            System.out.println(p);
            return;
        }
        if (row > 1){
            path(p+'D', row-1, col);
        }
        if (col > 1){
            path(p+'R', row, col-1);
        }
    }
    static ArrayList<String> pathRet(String p, int row, int col){
        if (row == 1 && col == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (row > 1){
           list.addAll(pathRet(p+'D', row-1, col));
        }
        if (col > 1){
           list.addAll(pathRet(p+'R', row, col-1));
        }
        return list;
    }
    static ArrayList<String> pathRetDiagnal(String p, int row, int col){
        if (row == 1 && col == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (row > 1){
            list.addAll(pathRetDiagnal(p+'V', row-1, col));
        }
        if (col > 1){
            list.addAll(pathRetDiagnal(p+'H', row, col-1));
        }
        if (row>1 && col > 1) {
            list.addAll(pathRetDiagnal(p + 'D', row - 1, col - 1));
        }
        return list;
    }
}