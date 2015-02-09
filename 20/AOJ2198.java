// AOJ 2198 "ムーンライト牧場" (ICPC模擬国内予選 2010 Problem B)
import java.util.Scanner;
import java.util.Arrays;

public class AOJ2198 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            Crop[] crops = new Crop[n];
            for (int i = 0; i < crops.length; i++) {
                String l = sc.next();
                int p = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                int d = sc.nextInt();
                int e = sc.nextInt();
                int f = sc.nextInt();
                int s = sc.nextInt();
                int m = sc.nextInt();
                
                int time = a + b + c + (d + e) * m;
                int income = s * f * m - p;
                crops[i] = new Crop(l, (double)income / time);
            }
            Arrays.sort(crops);
            for (int i = 0; i < crops.length; i++) {
                System.out.println(crops[i].name);
            }
            System.out.println("#");
        }
    }
}

class Crop implements Comparable<Crop> {
    String name;
    double efficiency;
    
    Crop(String name, double eff) {
        this.name = name;
        this.efficiency = eff;
    }
    
    public int compareTo(Crop o) {
        if (Math.abs(this.efficiency - o.efficiency) > 1e-8) {
            return Double.compare(o.efficiency, this.efficiency);
        } else {
            return this.name.compareTo(o.name);
        }
    }
}
