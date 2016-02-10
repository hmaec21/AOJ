// AOJ 1172 "チェビシェフの定理" (ICPC国内予選 2011 Problem A)
import java.util.Scanner;
import java.util.BitSet;

public class Main {
    static BitSet isNotPrime; // 素数でないならtrue
    static final int MAX_N = 123456;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        isNotPrime = new BitSet(MAX_N * 2 + 1);
        sieve();
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            int ans = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (!isNotPrime.get(i)) {
                    ans++;
                }
            }
            System.out.println(ans);
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
