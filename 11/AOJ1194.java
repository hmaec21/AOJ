// AOJ 1194 "バンパイア" (ICPC国内予選 2014 Problem C)
import java.util.Scanner;

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
            
            int[] field = new int[40]; // field[x]: 区間[x-20, x-19）地点の影の高さ
            for (int i = 0; i < n; i++) {
                int xl = sc.nextInt();
                int xr = sc.nextInt();
                int h  = sc.nextInt();
                
                for (int j = xl + 20; j < xr + 20; j++) {
                    field[j] = Math.max(field[j], h);
                }
            }
            //printHeight(field);
            double minTime = INF;
            for (int i = 0; i < field.length; i++) {
                minTime = Math.min(minTime, crossTime(i - 20, field[i], r));
                minTime = Math.min(minTime, crossTime(i + 1 - 20, field[i], r));
            }
            System.out.println(minTime);
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
    
    public static void printHeight(int[] field) {
        for (int i = 0; i < field.length; i++) {
            System.out.println((i - 20) + "-" + ((i - 20) + 1) + ": " + field[i]);
        }
    }
}
