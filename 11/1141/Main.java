// AOJ 1141 "ディリクレの算術級数定理" (ICPC国内予選 2006 Problem A)
import java.util.Scanner;
import java.util.BitSet;

public class Main {
    static BitSet isNotPrime; // 素数でないならtrue
    static final int MAX_N = 1000000;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        isNotPrime = new BitSet(MAX_N);
        sieve();
        while (true) {
            int a = sc.nextInt();
            int d = sc.nextInt();
            int n = sc.nextInt();
            if (a == 0) {
                break;
            }
            
            int num = 0; // 素数が現れた個数
            for (int i = a; i < MAX_N; i += d) {
                if (!isNotPrime.get(i)) {
                    num++;
                    if (num == n) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        }
    }
    
    public static void sieve() {
        isNotPrime.set(0);
        isNotPrime.set(1);
        for (int i = 2; i <= MAX_N; i++) {
            if (!isNotPrime.get(i)) {
                for (int j = i * 2; j <= MAX_N * 2; j += i) {
                    isNotPrime.set(j);
                }
            }
        }
    }
}
