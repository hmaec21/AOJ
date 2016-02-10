// AOJ 1154 "月曜土曜素因数" (ICPC国内予選 2008 Problem B)
import java.util.Scanner;
import java.util.BitSet;

public class Main {
    static BitSet isNotMSPrime; // 月曜土曜素数でないならtrue
    static final int MAX_N = 300000;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        isNotMSPrime = new BitSet(MAX_N);
        sieve();
        while (true) {
            int n = sc.nextInt();
            if (n == 1) {
                break;
            }
            
            System.out.print(n + ":");
            for (int i = 6; i <= n; i++) {
                if (i % 7 != 1 && i % 7 != 6) {
                    continue;
                }
                if (!isNotMSPrime.get(i) && n % i == 0) {
                    System.out.print(" " + i);
                }
            }
            System.out.println();
        }
    }
    
    public static void sieve() {
        isNotMSPrime.set(0);
        isNotMSPrime.set(1);
        for (int i = 2; i <= MAX_N; i++) {
            if (i % 7 != 1 && i % 7 != 6) {
                isNotMSPrime.set(i);
                continue;
            }
            if (!isNotMSPrime.get(i)) {
                for (int j = i * 2; j <= MAX_N * 2; j += i) {
                    isNotMSPrime.set(j);
                }
            }
        }
    }
}
