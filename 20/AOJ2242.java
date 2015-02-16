// AOJ 2242 "Era Name" (ICPC模擬地区予選 2010 Problem A)
import java.util.Scanner;
import java.util.Arrays;

public class AOJ2242 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            Era[] era = new Era[n];
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                int eraBasedYear = sc.nextInt();
                int westernYear = sc.nextInt();
                era[i] = new Era(name, eraBasedYear, westernYear);
            }
            Arrays.sort(era);
            
            for (int i = 0; i < q; i++) {
                int year = sc.nextInt();
                
                for (int j = 0; j < era.length; j++) {
                    if (era[j].first <= year && year <= era[j].last) {
                        System.out.println(era[j].name + " " + (year - era[j].first + 1));
                        break;
                    } else if (year < era[j].first || j == era.length - 1) {
                        System.out.println("Unknown");
                        break;
                    }
                }
            }
        }
    }
}

class Era implements Comparable<Era> {
    String name;
    int first;
    int last;
    
    Era(String name, int base, int western) {
        this.name = name;
        this.first = western - base + 1;
        this.last = western;
    }
    
    public int compareTo(Era o) {
        return this.first - o.first;
    }
}
