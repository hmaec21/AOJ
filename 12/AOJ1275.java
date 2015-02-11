// AOJ 1275 "And Then There Was One" (ICPCアジア地区予選 2007 東京大会 Problem A)
import java.util.Scanner;
import java.util.ArrayList;

public class AOJ1275 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            ArrayList<Integer> stone = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                stone.add(i);
            }
            
            stone.remove(m - 1);
            int tmp = m - 1;
            while (stone.size() > 1) {
                tmp = (tmp + k - 1) % stone.size();
                stone.remove(tmp);
            }
            System.out.println(stone.get(0));
        }
    }
}
