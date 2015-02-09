// AOJ 2013 "大崎" (ICPC模擬国内予選 2007 Problem B)
import java.util.Scanner;

public class AOJ2013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\r\\n|\\n|:| ");
        
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            int[] departure = new int[86400];
            for (int i = 0; i < n; i++) {
                int dh = sc.nextInt();
                int dm = sc.nextInt();
                int ds = sc.nextInt();
                departure[dh*3600+dm*60+ds]++;
                
                int ah = sc.nextInt();
                int am = sc.nextInt();
                int as = sc.nextInt();
                departure[ah*3600+am*60+as]--;
            }
            
            int max = 0;
            int tmp = 0;
            for (int i = 0; i < departure.length; i++) {
                tmp += departure[i];
                max = Math.max(max, tmp);
            }
            System.out.println(max);
        }
    }
}
