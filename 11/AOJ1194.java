// AOJ 1194 "バンパイア" (ICPC国内予選 2014 Problem C)
import java.util.Scanner;
import java.util.Arrays;

public class AOJ1194 {
    public static double INF = 100.0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int r = sc.nextInt();
            int n = sc.nextInt();
            if (r == 0) {
                break;
            }
            
            // field[y][x]: (x-20, y-1)にシルエット(境界も含む)があればtrue
            boolean[][] field = new boolean[41][81];
            Arrays.fill(field[0], true); // 地面に陰があると見なす
            
            for (int i = 0; i < n; i++) {
                int xl = sc.nextInt();
                int xr = sc.nextInt();
                int h  = sc.nextInt();
                
                for (int j = 1; j <= 2 * h; j++) {
                    Arrays.fill(field[j], (xl + 20) * 2, (xr + 20) * 2 + 1, true);
                }
            }
            //printField(field);
            
            double minTime = INF;
            for (int i = 0; i < field.length; i += 2) {
                for (int j = 0; j < field[i].length; j += 2) {
                    if (isBorder(field, j, i)) {
                        // シルエットの上下の境界ならば、円との交点を求める
                        double time = crossTime(j/2 - 20, i/2, r);
                        minTime = Math.min(minTime, time);
                    }
                }
            }
            System.out.println(minTime);
        }
    }
    
    public static boolean isBorder(boolean[][] field, int x, int y) {
        if (!field[y][x]) {
            return false;
        } else if (y == field.length - 1 || (x == 0 || x == field[y].length - 1) && !field[y+1][x]) {
            return true;
        } else if (!field[y+1][x]) {
            return true;
        } else {
            int num = 0;
            for (int i = 0; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (x + j >= 0 && x + j < field[y+i].length && field[y+i][x+j]) {
                        num++;
                    }
                }
            }
            return num == 5 ? true : false;
        }
    }
    
    public static double crossTime(int x, int y, int r) {
        //System.out.println("x: " + x + ", y: " + y + ", r: " + r);
        int d = (int)Math.pow(-2 * (y + r), 2) - 4 * (x * x + y * y + 2 * y * r);
        if (d <= 0) {
            return INF;
        } else {
            double ans = (2 * (y + r) - Math.sqrt(d)) / 2;
            //System.out.println(d + " " + Math.sqrt(d) + " " + ans);
            return ans;
        }
    }
    
    public static void printField(boolean[][] field) {
        for (int i = field.length - 1; i >= 0; i -= 2) {
            for (int j = 0; j < field[i].length; j += 2) {
                if (field[i][j]) {
                    System.out.print("-");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
