import java.util.Scanner;

public class AOJ10019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String s = sc.next();
            if (s.equals("0")) {
                break;
            }
            
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
            }
            System.out.println(sum);
        }
    }
}
