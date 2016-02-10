// AOJ 2330 "雅先生の地球侵略日誌" (JAG夏合宿 2010 day 2 Problem A)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        long a = 1;
        int count = 0;
        while (a < n) {
            a *= 3;
            count++;
        }
        System.out.println(count);
    }
}
