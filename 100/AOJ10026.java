import java.util.Scanner;

public class AOJ10026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            int[] score = new int[n];
            int sum = 0;
            for (int i = 0; i < score.length; i++) {
                score[i] = sc.nextInt();
                sum += score[i];
            }
            double ave = sum / (double)n;
            
            double var = 0;
            for (int i = 0; i < score.length; i++) {
                double tmp = score[i] - ave;
                var += tmp * tmp;
            }
            var /= n;
            double stddev = Math.sqrt(var);
            System.out.println(stddev);
        }
    }
}
