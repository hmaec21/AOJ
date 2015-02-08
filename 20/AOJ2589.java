// AOJ 2589 "North North West" (ICPC模擬地区予選 2014 Problem A)
import java.util.Scanner;
import java.math.BigDecimal;

public class AOJ2589 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String s = sc.next();
            if (s.equals("#")) {
                break;
            }
            
            BigDecimal degree;
            int pos = s.length() - 1;
            if (s.charAt(pos) == 't') {
                degree = new BigDecimal("90");
                pos -= 4;
            } else {
                degree = new BigDecimal("0");
                pos -= 5;
            }
            
            int n = 1;
            BigDecimal tmp = new BigDecimal("45");
            while (pos >= 0) {
                if (s.charAt(pos) == 't') {
                    degree = degree.add(tmp);
                    pos -= 4;
                } else {
                    degree = degree.subtract(tmp);
                    pos -= 5;
                }
                n++;
                tmp = tmp.divide(new BigDecimal("2"));
            }
            
            if (n > 2) {
                degree = degree.multiply(new BigDecimal(Math.pow(2, n - 2)));
            }
            System.out.print(degree.intValue());
            if (n > 2) {
                System.out.print("/" + (int)Math.pow(2, n - 2));
            }
            System.out.println();
        }
    }
}
