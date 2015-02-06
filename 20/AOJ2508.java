// AOJ 2508 "王様の視察" (ICPC模擬国内予選 2013 Problem A)
import java.util.Scanner;

public class AOJ2508 {
    public static void main(String[] args) {
        String station = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            int[] k = new int[n];
            for (int i = 0; i < n; i++) {
                k[i] = sc.nextInt();
            }
            StringBuffer s = new StringBuffer(sc.next());
            
            for (int i = 0; i < s.length(); i++) {
                char tmp = s.charAt(i);
                int pos = station.indexOf(tmp);
                char newStation = station.charAt((pos + (52 - k[i%k.length])) % 52);
                s.setCharAt(i, newStation);
            }
            System.out.println(s);
        }
    }
}
