import java.util.Scanner;

public class AOJ10025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        double rad = c * Math.PI / 180;
        
        double s = a * b * Math.sin(rad) / 2;
        double l = Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(rad)) + a + b;
        double h = s / a * 2;
        
        System.out.println(s);
        System.out.println(l);
        System.out.println(h);
    }
}
